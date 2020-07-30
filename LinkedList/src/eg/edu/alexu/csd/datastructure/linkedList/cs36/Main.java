package eg.edu.alexu.csd.datastructure.linkedList.cs36;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {


        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        int arr[][] = {{13, 2}, {10, 2}, {-3, 1}, {5, 1}, {-1, 0}, {-1, 1}, {4, 2}};
        PolynomialSolver polynomialSolver = new PolynomialSolver();
        polynomialSolver.setPolynomial('A', arr);
        System.out.println("the return function " + polynomialSolver.print('A'));
        Point father[] = polynomialSolver.translateListIntoArrOfPoints(polynomialSolver.getA());
        // System.out.println("the god father array is : " + Arrays.toString(father));
        father = sortPoints(father);
        // System.out.println("the god father array after sorting is  : " + Arrays.toString(father));
        System.out.println("the value of evaluation polynomial method is " + polynomialSolver.evaluatePolynomial('A', 2));
        int arr2[][] = {{-3, 2}, {1, 0}, {-4, 1}, {13, 2}, {5, 3}};
        polynomialSolver.setPolynomial('B', arr2);
        System.out.println("the return function " + polynomialSolver.print('B'));
        System.out.println("the value of evaluation polynomial method is " + polynomialSolver.evaluatePolynomial('B', (float) -1));
        polynomialSolver.multiply('A', 'B');
        System.out.println("the multiplication ");
        System.out.println(polynomialSolver.print('R'));
//        doubleLinkedList.add(0, 1);
//        doubleLinkedList.add(1, 2);
//        doubleLinkedList.add(2, 3);
//        doubleLinkedList.add(3, 4);
//        doubleLinkedList.add(1, 20);
//        doubleLinkedList.add(3, 26);
//        doubleLinkedList.add(0, 0);
//        doubleLinkedList.add(0, -1);
//        doubleLinkedList.add(1, -2);
//        doubleLinkedList.add(7, 13);
//        doubleLinkedList.add(8, 10);
//        doubleLinkedList.add(0, -3);
//        doubleLinkedList.add(doubleLinkedList.size(), 100);
//        doubleLinkedList.add(150);
//        doubleLinkedList.add(160);
//        doubleLinkedList.add(170);
//        doubleLinkedList.add(180);
//        doubleLinkedList.printList(doubleLinkedList);
//        doubleLinkedList.reverseList(doubleLinkedList);
//
//        System.out.println(doubleLinkedList.size());
//        DoubleLinkedList newLinkedList = (DoubleLinkedList) doubleLinkedList.sublist(14, 16);
//        System.out.println("the new sub list ");
//        newLinkedList.printList(newLinkedList);
//
////        for (int i=0 ; i<doubleLinkedList.size();i++){
////            Integer index = (Integer) (doubleLinkedList.get(i));
////
////            System.out.println(doubleLinkedList.contains(index));
////        }
//
//
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(0, 1);
//        linkedList.add(1, 2);
//        linkedList.add(2, 3);
//        linkedList.add(3, 4);
//        linkedList.add(1, 20);
//        linkedList.add(3, 26);
//        linkedList.add(0, 0);
//        linkedList.add(0, -1);
//        linkedList.add(1, -2);
//        linkedList.add(7, 13);
//        linkedList.add(8, 10);
//        linkedList.add(0, -3);
//        linkedList.add(linkedList.size(), 100);
//        linkedList.add(150);
//        linkedList.add(160);
//        linkedList.add(170);
//        linkedList.add(180);
//
//
//        System.out.println(linkedList.toString());
//        System.out.println(linkedList.size());
    }

    public static Point[] sortPoints(Point[] arr) {

        Arrays.sort(arr, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                int yComp = Integer.compare(a.y, b.y);
                if (yComp == 0)
                    return Integer.compare(a.x, b.x);
                else
                    return yComp;
            }
        });
        //    System.out.println("arr in sort points function" + Arrays.toString(arr));


        //if y (the power is equal ) we must get the sum of the x's (the coefficients)
        Point temp[] = new Point[arr.length];

        ArrayList<Point> sumOfCoefficients = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].y != arr[i + 1].y) {
                sumOfCoefficients.add(arr[i]);
            } else {
                Point point = new Point(arr[i].x + arr[i + 1].x, arr[i].y);
                arr[i] = point;
                arr[i + 1] = point;
                if (i > 0) {
                    if (arr[i - 1].y == arr[i].y) {
                        arr[i - 1] = point;
                    }
                }
            }
        }

        //this code is supposed to remove the the duplicates
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (!arr[i].equals(arr[i + 1])) {
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[arr.length - 1];
        for (int i = 0; i < j; i++) {
            arr[i] = temp[i];
        }
        //   System.out.println("temp in sort points function" + Arrays.toString(temp));
        return temp;
    }

}
