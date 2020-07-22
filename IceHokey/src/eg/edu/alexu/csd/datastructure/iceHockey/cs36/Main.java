package eg.edu.alexu.csd.datastructure.iceHockey.cs36;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String photo[] = {"8D88888J8L8E888",
                "88NKMG8N8E8JI88",
                "888NS8EU88HN8EO",
                "LUQ888A8TH8OIH8",
                "888QJ88R8SG88TY",
                "88ZQV88B88OUZ8O",
                "FQ88WF8Q8GG88B8",
                "8S888HGSB8FT8S8",
                "8MX88D88888T8K8",
                "8S8A88MGVDG8XK8",
                "M88S8B8I8M88J8N",
                "8W88X88ZT8KA8I8",
                "88SQGB8I8J88W88",
                "U88H8NI8CZB88B8",
                "8PK8H8T8888TQR8"};
        PlayersFinder playersFinder = new PlayersFinder();
//        char [][] charArr = new char[photo.length][photo[0].length()];
//        for (int i = 0; i < photo.length; i++) {
//            for (int j = 0; j < photo[i].length(); j++) {
//                charArr[i][j] = photo[i].charAt(j);
//            }
//        }
        //  playersFinder.recursion(0,6,charArr,3);

        System.out.println("===============================================");
        playersFinder.findPlayers(photo, 8, 9);
    }

    private static void printArrOfChar(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printArrOfString(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length(); j++) {
                System.out.print(arr[i].charAt(j) + " ");
            }
            System.out.println();
        }
    }
}

