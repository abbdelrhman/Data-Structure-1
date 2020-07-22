package eg.edu.alexu.csd.datastructure.iceHockey.cs36;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PlayersFinder implements IPlayersFinder {

    private String photo[];
    private boolean arr2[][];
    private char arr[][];
    private int cont = 0;
    private int i, j;
    private ArrayList<Integer> arrX = new ArrayList<>();
    private ArrayList<Integer> arrY = new ArrayList<>();
    private ArrayList<Point> points = new ArrayList<>();
    private int maxX, minX, maxY, minY, centreX, centreY;





    @Override
    public Point[] findPlayers(String[] photo, int team, int threshold) {
        arr2 = new boolean[photo.length][photo[0].length()];
        arr = new char[photo.length][photo[0].length()];
        if (photo == null) {
            return null;
        }

        if ((photo.length) <= 0) {
            throw new IllegalArgumentException("Empty");
        }

        int requiredNo = (int) Math.ceil((double) threshold / 4);
//        System.out.println("the required number/s of indices is " + requiredNo);
//        int noOfPlayers = 0;
        char[][] charArr = new char[photo.length][photo[0].length()];
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length(); j++) {
                charArr[i][j] = photo[i].charAt(j);
            }
        }

        for (int i = 0; i < charArr.length; i++) {
            for (int j = 0; j < charArr[i].length; j++) {

                if (!arr2[i][j] && team == charArr[i][j] - '0') {
//                    System.out.println("the current index is (" + i + "," + j + ")");
                    recursion(i, j, charArr, team);
//                    System.out.println("the count variable in the find players method is " + cont);
                    if (requiredNo == 1 && cont == 0) {
                        arr2[i][j] = true;
                        arrX.add(j * 2);
                        arrX.add(j * 2 + 2);
                        arrY.add((i) * 2);
                        arrY.add((i) * 2 + 2);
                        cont++;
                    }
                    if (cont >= requiredNo) {
//                        System.out.println("i am in the dark here you understand");
//                        noOfPlayers++;
                        cont = 0;
                        Collections.sort(arrX);
                        Collections.sort(arrY);
//                        System.out.println("the x axes "+arrX.toString());
//                        System.out.println("the y axes is "+arrY.toString());
                        maxX = arrX.get(arrX.size() - 1);
                        minX = arrX.get(0);
                        maxY = arrY.get(arrY.size() - 1);
                        minY = arrY.get(0);
                        arrX = new ArrayList<>();
                        arrY = new ArrayList<>();
                        centreX = (minX + maxX) / 2;
                        centreY = (minY + maxY) / 2;
//                        System.out.println("the centre x is "+centreX +" the centre Y is"+centreY);
                        Point point = new Point(centreX, centreY);
                        points.add(point);
                    } else {
                        arrX = new ArrayList<>();
                        arrY = new ArrayList<>();
                        cont = 0;
                    }
                }
            }
        }
        Point[] arr = new Point[points.size()];
        arr = points.toArray(arr);
        Arrays.sort(arr, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                int xComp = Integer.compare(a.x, b.x);
                if (xComp == 0)
                    return Integer.compare(a.y, b.y);
                else
                    return xComp;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
//        System.out.println("the number of players is " + noOfPlayers);
        return arr;

    }
    public void recursion(int i, int j, char arr[][], int team) {
        if ((i + 1 < arr.length) &&
                team == arr[i + 1][j] - '0' && !arr2[i + 1][j]) {
            arr2[i + 1][j] = true;
            cont++;
//            System.out.println("there is exist a team member at location " + (i+1) +"," + j);
//            System.out.println("the count was " + (cont-1) + " and now the count is "+cont);
            arrX.add(j * 2);
            arrX.add(j * 2 + 2);
            arrY.add((i + 1) * 2);
            arrY.add((i + 1) * 2 + 2);
            recursion(i + 1, j, arr, team);//first recursion ,second recursion
        }

        if (((j - 1) >= 0) && team == arr[i][j - 1] - '0' && !arr2[i][j - 1]) {
            arr2[i][j - 1] = true;
            cont++;

//            System.out.println("there is exist a team member at location " + (i) +"," + (j-1));
//            System.out.println("the count was " + (cont-1) + " and now the count is "+cont);
            arrY.add(2 * i);
            arrY.add(i * 2 + 2);
            arrX.add((j - 1) * 2);
            arrX.add((j - 1) * 2 + 2);
            recursion(i, j - 1, arr, team);
        }
        if ((j + 1 < arr[0].length) && team == arr[i][j + 1] - '0' && !arr2[i][j + 1]) {
            arr2[i][j + 1] = true;
            cont++;
//            System.out.println("there is exist a team member at location " + (i) +"," + (j+1));
//            System.out.println("the count was " + (cont-1) + " and now the count is "+cont);
            arrY.add(2 * i);
            arrY.add(i * 2 + 2);
            arrX.add((j + 1) * 2);
            arrX.add(2 * (j + 1) + 2);
            recursion(i, j + 1, arr, team);

        }
        if ((i - 1 >= 0) &&
                team == arr[i - 1][j] - '0' && !arr2[i - 1][j]) {
            arr2[i - 1][j] = true;
            cont++;
//            System.out.println("there is exist a team member at location " + (i-1) +"," + (j));
//            System.out.println("the count was " + (cont-1) + " and now the count is "+cont);
            arrX.add(j * 2);
            arrX.add(j * 2 + 2);
            arrY.add((i - 1) * 2);
            arrY.add((i - 1) * 2 + 2);
            recursion(i - 1, j, arr, team);
        }
//        System.out.println("the number of player is " + cont);

    }




}
