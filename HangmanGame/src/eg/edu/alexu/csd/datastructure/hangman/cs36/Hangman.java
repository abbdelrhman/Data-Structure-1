package eg.edu.alexu.csd.datastructure.hangman.cs36;

import java.io.*;
import java.rmi.MarshalException;
import java.util.ArrayList;

public class Hangman implements IHangman {
    private String words[];
    private ArrayList<String> arrayList = new ArrayList<>();
    private int RandomAccessIndex;
    private String randomWord;
    private String shownWord = "";
    private int maxGuess;

    private static ArrayList<Character> charList = new ArrayList<>();
    @Override
    public void setDictionary(String[] words) {
        this.words = words;
    }

    @Override
    public String selectRandomSecretWord() {
        if (words == null) {
            return null;
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Dictionary.txt"))) {
            for (int i = 0; i < words.length; i++) {
                bufferedWriter.write(words[i] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Dictionary.txt"))) {
            String s = null;
            s = bufferedReader.readLine();

            while (s != null) {
                System.out.println("i added " + s + " to the arraylist");
                arrayList.add(s);
                s = bufferedReader.readLine();
            }
            System.out.println(arrayList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        RandomAccessIndex = (int) ((arrayList.size()) * Math.random());
        randomWord = arrayList.get(RandomAccessIndex);

        for (int i = 0; i < randomWord.length(); i++) {
            shownWord += "-";
        }
        return randomWord;


    }

    @Override
    public String guess(Character c) throws Exception {
        if (this.words[RandomAccessIndex].equalsIgnoreCase(shownWord)){
            return shownWord ;
        }

        StringBuilder stringBuilder = new StringBuilder(shownWord);
        if (randomWord.charAt(0) == ' ' || randomWord.length() == 0) {
            throw new UnsupportedOperationException();
        }
        if (randomWord == null) {
            return null;
        }
        boolean flag = false;
        randomWord = randomWord.toLowerCase();
        c = Character.toLowerCase(c);

        if (c == null) {
            System.out.println("wrong input");
            return shownWord;
        }

        if(charList.contains(c)){
            System.out.println("you have already entered this character");
            return shownWord;
        }
        for (int i = 0; i < randomWord.length(); i++) {

            if (c == randomWord.charAt(i) && !charList.contains(c)) {
               stringBuilder.setCharAt(i,c);

                flag = true;
            }
        }
        charList.add(c);
        shownWord = stringBuilder.toString();
        if (flag == false) {
            maxGuess--;
            System.out.println(maxGuess+" tries left");
        }
        if (maxGuess == 0) {
            System.out.println("hangman");
            return shownWord;
        } else {
            return shownWord;
        }


    }

    @Override
    public void setMaxWrongGuesses(Integer max) {
        if (max == null) {
            this.maxGuess = 1;
        } else {
            this.maxGuess = max;
        }
    }
}
