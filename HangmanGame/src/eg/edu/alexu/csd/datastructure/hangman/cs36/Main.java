package eg.edu.alexu.csd.datastructure.hangman.cs36;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Hangman hangman = new Hangman() ;
        hangman.setDictionary(new String[]{"egypt", "sudana" , "singala" , "aswan"});
        System.out.println("the word is " + hangman.selectRandomSecretWord());
        hangman.setMaxWrongGuesses(10);
        for(int i=0 ; i<10 ; i++){
            char c = scanner.next().charAt(0);
            System.out.println(hangman.guess(c));
        }
        }

}
