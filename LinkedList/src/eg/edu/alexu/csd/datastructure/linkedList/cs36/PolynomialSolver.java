package eg.edu.alexu.csd.datastructure.linkedList.cs36;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PolynomialSolver implements IPolynomialSolver {
    private static Scanner scanner = new Scanner(System.in);
    private DoubleLinkedList A = new DoubleLinkedList();
    private DoubleLinkedList B = new DoubleLinkedList();
    private DoubleLinkedList C = new DoubleLinkedList();
    private DoubleLinkedList R = new DoubleLinkedList();
    private String ans;


    @Override
    public void setPolynomial(char poly, int[][] terms) {
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < terms.length; i++) {
            if (terms[i] == null) {

            } else {
                Point point = new Point(terms[i][0], terms[i][1]);
                arr.add(point);
                switch (poly) {
                    case 'A':
                        A.add(point);
                        break;
                    case 'B':
                        B.add(point);
                        break;
                    case 'C':
                        C.add(point);
                        break;
                    case 'R':
                        R.add(point);
                        break;
                    default:
                        throw new RuntimeException("wrong input name for poly");
                }
            }
        }
    }


    @Override
    public String print(char poly) {
        DoubleLinkedList d = getPoly(poly);
        String answer = "";

        if (d.size() == 0) {
            throw new RuntimeException("empty polynomial");
        }
        Point arr[] = translateListIntoArrOfPoints(d);
        arr = sortPoints(arr);
        int start = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == null) {
                //skip
            } else {
                if (start == 0) {
                    // start of the expression so we indicate this condition because we don't put a sign in it
                    if (arr[i].x == 0) {
                        //the coefficients is equal to zero
                    } else if (arr[i].x > 0 && arr[i].y == 1) {
                        if (arr[i].x == 1) {
                            answer += "x";//1x^1 = x
                        } else {
                            answer += arr[i].x + "x";  // .5x , 3x , 11x
                        }
                        start++;
                    } else if (arr[i].x < 0 && arr[i].y == 1) {
                        //-1x^1    -5x^1
                        if (arr[i].x == -1) {
                            answer += "-x";
                        } else {
                            answer += arr[i].x + "x";
                        }
                        start++;
                    } else if (arr[i].y == 0) {
                        answer += arr[i].x;
                        start++;
                    } else if ((arr[i].y != 1) && ((arr[i].y != 0))) {
                        if (arr[i].x == 1) {
                            answer += "x^" + arr[i].y;
                        } else if (arr[i].x == -1) {
                            answer += "-x^" + arr[i].y;
                        } else {
                            answer += arr[i].x + "x^" + arr[i].y;
                        }
                        start++;
                    }
                } else {
                    start++;

                    //at the end of the expression
                    if (arr[i].x == 0) {
                        //the coefficients is equal to zero
                    } else if (arr[i].x > 0 && arr[i].y == 1) {
                        if (arr[i].x == 1) {
                            answer += "+x";//1x^1 = x
                        } else {
                            answer += "+" + arr[i].x + "x";  // .5x , 3x , 11x
                        }
                        start++;
                    } else if (arr[i].x < 0 && arr[i].y == 1) {
                        //-1x^1    -5x^1
                        if (arr[i].x == -1) {
                            answer += "-x";
                        } else {
                            answer += arr[i].x + "x";
                        }
                        start++;
                    } else if (arr[i].y == 0) {
                        if (arr[i].x < 0) {
                            answer += arr[i].x;
                        } else {
                            answer += "+" + arr[i].x;
                            start++;
                        }
                    } else if ((arr[i].y != 1) && ((arr[i].y != 0))) {
                        if (arr[i].x == 1) {
                            answer += "+x^" + arr[i].y;
                        } else if (arr[i].x == -1) {
                            answer += "-x^" + arr[i].y;
                        } else if (arr[i].x > 0) {
                            answer += "+" + arr[i].x + "x^" + arr[i].y;
                        } else {
                            answer += arr[i].x + "x^" + arr[i].y;
                        }
                        start++;
                    }

                }
            }

        }

        return answer;
    }

    @Override
    public void clearPolynomial(char poly) {
        DoubleLinkedList list = getPoly(poly);
        list.clear();
    }

    @Override
    public float evaluatePolynomial(char poly, float value) {
        DoubleLinkedList list = getPoly(poly);
        float answer = 0;
        if (list.size() == 0) {
            throw new RuntimeException("empty polynomial");
        }
        Point arr[] = translateListIntoArrOfPoints(list);
        arr = sortPoints(arr);


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {

            } else {
                answer += (float) ((float) arr[i].x * Math.pow((double) value, (double) arr[i].y));
            }
        }
        return answer;
    }

    @Override
    public int[][] add(char poly1, char poly2) {
        DoubleLinkedList list1 = getPoly(poly1);
        DoubleLinkedList list2 = getPoly(poly2);
        if(list1 == null || list2 ==null){
            System.out.println("variable not set");
            return null;
        }
        if (list1.size() == 0 && list2.size() == 0) {
            throw new RuntimeException("empty polynomial");
        }

        Point arr1[] = translateListIntoArrOfPoints(list1);
        Point arr2[] = translateListIntoArrOfPoints(list2);
        arr1 = sortPoints(arr1);
        arr2 = sortPoints(arr2);
        int ansLength = arr1.length > arr2.length ? arr1.length : arr2.length;
        Point[] ans = new Point[ansLength];

        int i = 0, j = 0;
        int pointCounter = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == null) {
                break;
            }
            if (arr2[j] == null) {
                break;
            }
            //3 cases
            // 1-> arr1.y = arr2.y     add the x's of them and put new point in ans
            //2-> arr1.y > arr2.y      add the point of arr2 and put in the ans increment j
            //3-> arr1.y < arr2.y      add the point of arr1 and put in the ans increment i

            if (arr1[i].y == arr2[j].y) {
                //sort points function don't allow more than one point for similar power (arr[].y)
                ans[pointCounter] = new Point(arr1[i].x + arr2[j].x, arr1[i].y);
                i++;
                j++;
                pointCounter++;
            } else if (arr1[i].y > arr2[j].y) {
                ans[pointCounter] = arr2[j];
                j++;
                pointCounter++;
            } else if (arr1[i].y < arr2[j].y) {
                ans[pointCounter] = arr1[i];
                i++;
                pointCounter++;
            }
        }
        while (i < arr1.length) {
            if (arr1[i] == null) {
                break;
            } else {
                ans[pointCounter] = arr1[i];
                i++;
                pointCounter++;
            }
        }
        while (j < arr2.length) {
            if (arr2[j] == null) {
                break;
            } else {
                ans[pointCounter] = arr2[j];
                j++;
                pointCounter++;
            }
        }
        for (int index = pointCounter; index < ansLength; index++) {
            ans[index] = null;
        }
        //    System.out.println("in the add function");
        ans = sortPoints(ans);
        int answer[][] = new int[ans.length][2];
        for (int I = 0; I < ans.length; I++) {
            answer[I][0] = ans[I].x;
            answer[I][1] = ans[I].y;
        }
        setPolynomial('R', answer);
        return answer;
    }

    @Override
    public int[][] subtract(char poly1, char poly2) {
        DoubleLinkedList list1 = getPoly(poly1);
        DoubleLinkedList list2 = getPoly(poly2);
        if (list1.size() == 0 && list2.size() == 0) {
            throw new RuntimeException("empty polynomial");
        }

        Point arr1[] = translateListIntoArrOfPoints(list1);
        Point arr2[] = translateListIntoArrOfPoints(list2);
        arr1 = sortPoints(arr1);
        arr2 = sortPoints(arr2);

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == null) {

            } else {
                arr2[i].x = -1 * arr2[i].x;
            }
        }
        int ansLength = arr1.length > arr2.length ? arr1.length : arr2.length;
        Point[] ans = new Point[ansLength];

        int i = 0, j = 0;
        int pointCounter = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == null) {
                break;
            }
            if (arr2[j] == null) {
                break;
            }
            //3 cases
            // 1-> arr1.y = arr2.y     add the x's of them and put new point in ans
            //2-> arr1.y > arr2.y      add the point of arr2 and put in the ans increment j
            //3-> arr1.y < arr2.y      add the point of arr1 and put in the ans increment i

            if (arr1[i].y == arr2[j].y) {
                //sort points function don't allow more than one point for similar power (arr[].y)
                ans[pointCounter] = new Point(arr1[i].x + arr2[j].x, arr1[i].y);
                i++;
                j++;
                pointCounter++;
            } else if (arr1[i].y > arr2[j].y) {
                ans[pointCounter] = arr2[j];
                j++;
                pointCounter++;
            } else if (arr1[i].y < arr2[j].y) {
                ans[pointCounter] = arr1[i];
                i++;
                pointCounter++;
            }
        }
        while (i < arr1.length) {
            if (arr1[i] == null) {
                break;
            } else {
                ans[pointCounter] = arr1[i];
                i++;
                pointCounter++;
            }
        }
        while (j < arr2.length) {
            if (arr2[j] == null) {
                break;
            } else {
                ans[pointCounter] = arr2[j];
                j++;
                pointCounter++;
            }
        }
        for (int index = pointCounter; index < ansLength; index++) {
            ans[index] = null;
        }
        //   System.out.println("in the sub function");
        ans = sortPoints(ans);
        int answer[][] = new int[ans.length][2];
        for (int I = 0; I < ans.length; I++) {
            answer[I][0] = ans[I].x;
            answer[I][1] = ans[I].y;
        }
        setPolynomial('R', answer);
        return answer;
    }

    @Override
    public int[][] multiply(char poly1, char poly2) {

        DoubleLinkedList list1 = getPoly(poly1);
        DoubleLinkedList list2 = getPoly(poly2);
        if (list1.size() == 0 && list2.size() == 0) {
            throw new RuntimeException("empty polynomial");
        }
        Point arr1[] = translateListIntoArrOfPoints(list1);
        Point arr2[] = translateListIntoArrOfPoints(list2);
        arr1 = sortPoints(arr1);
        arr2 = sortPoints(arr2);
        ArrayList<Point> arrayList = new ArrayList<>();
        int i = 0;
        while (i < arr1.length) {
            for (int j = 0; j < arr2.length; j++) {
                Point point = new Point(arr1[i].x * arr2[j].x, arr1[i].y + arr2[j].y);
                arrayList.add(point);
            }
            i++;
        }
        Point[] ans = translateListIntoArray(arrayList);
        ans = sortPoints(ans);
        int answer[][] = new int[ans.length][2];
        for (int I = 0; I < ans.length; I++) {
            answer[I][0] = ans[I].x;
            answer[I][1] = ans[I].y;
        }
        setPolynomial('R', answer);
        return answer;
    }

    public DoubleLinkedList getA() {
        return A;
    }

    public DoubleLinkedList getB() {
        return B;
    }

    public DoubleLinkedList getC() {
        return C;
    }

    public DoubleLinkedList getR() {
        return R;
    }

    public String getAns() {
        return ans;
    }

    public Point[] translateListIntoArrOfPoints(DoubleLinkedList list) {
        Point arr[] = new Point[list.size()];
        DNode temp = list.getHead();
        int i = 0;
        while (temp != null) {
            arr[i] = (Point) list.get(i);
            temp = temp.next;
            i++;
        }
        return arr;
    }

    public Point[] sortPoints(Point[] arr) {
        arr = arrayWithoutNull(arr);

        Arrays.sort(arr, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                int yComp = Integer.compare(a.y, b.y);
                if (yComp == 0)
                    return Integer.compare(a.x, b.x);
                else
                    return yComp;
            }
        });
        // System.out.println("arr in sort points function" + Arrays.toString(arr));


        //if y (the power is equal ) we must get the sum of the x's (the coefficients)
        Point temp[] = new Point[arr.length];

//        ArrayList<Point> sumOfCoefficients = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].y != arr[i + 1].y) {
//                sumOfCoefficients.add(arr[i]);
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
        temp = arrayWithoutNull(temp);
        //     System.out.println("temp in sort points function" + Arrays.toString(temp));
        return temp;
    }

    public DoubleLinkedList getPoly(char c) {
        switch (c) {
            case 'A':
                return A;
            case 'B':
                return B;
            case 'C':
                return C;
            case 'R':
                return R;

            default:
                throw new RuntimeException();
        }
    }

    public int sizeWithoutNull(Point[] arr) {
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                size++;
            }
        }
        return size;
    }

    public Point[] arrayWithoutNull(Point arr[]) {
        Point ans[] = new Point[sizeWithoutNull(arr)];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public Point[] translateListIntoArray(ArrayList<Point> arrayList) {
        Point arr[] = new Point[arrayList.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrayList.get(i);
        }
        return arr;
    }
}
