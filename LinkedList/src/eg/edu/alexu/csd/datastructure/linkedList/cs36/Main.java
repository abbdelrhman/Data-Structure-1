package eg.edu.alexu.csd.datastructure.linkedList.cs36;

import java.awt.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //printList();
        int choice ;
        String s = "(1,0),(2,3),(4,5)";
        Pattern pattern = Pattern.compile("[amn]");
        Matcher matcher = pattern.matcher("n");
        System.out.println(matcher.find());
        System.out.println(matcher.matches());
        System.out.println(matcher.find());

//        while (true){
//            choice=scanner.nextInt();
//            if(choice<0 || choice>7){
//                System.out.println("wrong choice");
//            }
//            scanner.nextLine();
//            switch (choice){
//                case 1:
//                    System.out.println("Insert the variable name: A, B or C");
//                    String  c = scanner.next();
//                    String input ;
//                    switch (c){
//                        case "A":
//                            System.out.println("Insert the polynomial terms in the form:\n" +
//                                    "(coeff1, exponent1), (coeff2, exponent2), ..");
//                            input = scanner.nextLine();
//
//
//                    }
//
//            }
//        }
    }

//    public static int[][] translateIntoPoly(String s){
//        ArrayList<Point> arrayList = new ArrayList<>();
//        for(int i=0 ; i<s.length() ; i++){
//            if()
//        }
//        return null;
//    }
}
