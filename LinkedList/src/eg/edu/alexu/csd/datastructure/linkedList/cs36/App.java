package eg.edu.alexu.csd.datastructure.linkedList.cs36;

import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static PolynomialSolver polynomialSolver = new PolynomialSolver();

    public static void main(String[] args) {
        while (true) {
            printList();
            String chosen = scanner.nextLine();
            switch (chosen) {
                case "1":
                    subList();
                    break;
                case "2":
                    System.out.println("Insert the variable name: A, B, C or R");
                    String c = scanner.nextLine();
                    char c1 = c.charAt(0);
                    System.out.println(polynomialSolver.print(c1));
                    break;
                case "3":
                    boolean flag = false;
                    System.out.println("Insert first operand variable name: A, B or C");
                    String first = scanner.nextLine();
                    DoubleLinkedList doubleLinkedList = polynomialSolver.getPoly(first.charAt(0));
                    if (doubleLinkedList.size() == 0) {
                        System.out.println("Variable not set");
                        flag = true;
                        while (flag) {
                            System.out.println("Insert first operand variable name: A, B or C");
                            first = scanner.nextLine();
                            doubleLinkedList = polynomialSolver.getPoly(first.charAt(0));
                            if (doubleLinkedList.size() == 0) {
                                System.out.println("Variable not set");
                            } else {
                                flag = false;
                            }

                        }

                    }
                    boolean flag2 = false;
                    System.out.println("Insert second operand variable name: A, B or C");
                    String second = scanner.nextLine();
                    doubleLinkedList = polynomialSolver.getPoly(second.charAt(0));
                    if (doubleLinkedList.size() == 0) {
                        System.out.println("Variable not set");
                        flag = true;
                        while (flag) {
                            System.out.println("Insert second operand variable name: A, B or C");
                            second = scanner.nextLine();
                            doubleLinkedList = polynomialSolver.getPoly(second.charAt(0));
                            if (doubleLinkedList.size() == 0) {
                                System.out.println("Variable not set");
                            } else {
                                flag = false;
                            }

                        }

                    }
                    polynomialSolver.add(first.charAt(0), second.charAt(0));
                    System.out.println("Result value in R "+polynomialSolver.print('R'));

//                    System.out.println("Insert first operand variable name: A, B or C");
//                    String first = scanner.nextLine();
//                    System.out.println("Insert second operand variable name: A, B or C");
//                    String second = scanner.nextLine();
//                    polynomialSolver.add(first.charAt(0), second.charAt(0));
                    break;
                case "4":

                    flag = false;
                    System.out.println("Insert first operand variable name: A, B or C");
                    first = scanner.nextLine();
                    doubleLinkedList = polynomialSolver.getPoly(first.charAt(0));
                    if (doubleLinkedList.size() == 0) {
                        System.out.println("Variable not set");
                        flag = true;
                        while (flag) {
                            System.out.println("Insert first operand variable name: A, B or C");
                            first = scanner.nextLine();
                            doubleLinkedList = polynomialSolver.getPoly(first.charAt(0));
                            if (doubleLinkedList.size() == 0) {
                                System.out.println("Variable not set");
                            } else {
                                flag = false;
                            }

                        }

                    }
                    flag2 = false;
                    System.out.println("Insert second operand variable name: A, B or C");
                    second = scanner.nextLine();
                    doubleLinkedList = polynomialSolver.getPoly(second.charAt(0));
                    if (doubleLinkedList.size() == 0) {
                        System.out.println("Variable not set");
                        flag = true;
                        while (flag) {
                            System.out.println("Insert second operand variable name: A, B or C");
                            second = scanner.nextLine();
                            doubleLinkedList = polynomialSolver.getPoly(second.charAt(0));
                            if (doubleLinkedList.size() == 0) {
                                System.out.println("Variable not set");
                            } else {
                                flag = false;
                            }

                        }

                    }
                    polynomialSolver.subtract(first.charAt(0), second.charAt(0));
                    System.out.println("Result value in R "+polynomialSolver.print('R'));

//                    System.out.println("Insert first operand variable name: A, B or C");
//                    String first = scanner.nextLine();
//                    DoubleLinkedList doubleLinkedList = polynomialSolver.getPoly(first.charAt(0));
//                    if (doubleLinkedList.size() == 0) {
//                        System.out.println("Variable not set");
//                    }
//                    System.out.println("Insert second operand variable name: A, B or C");
//                    String second = scanner.nextLine();
//                    polynomialSolver.subtract(first.charAt(0), second.charAt(0));
                    break;
                case "5":

                    flag = false;
                    System.out.println("Insert first operand variable name: A, B or C");
                    first = scanner.nextLine();
                    doubleLinkedList = polynomialSolver.getPoly(first.charAt(0));
                    if (doubleLinkedList.size() == 0) {
                        System.out.println("Variable not set");
                        flag = true;
                        while (flag) {
                            System.out.println("Insert first operand variable name: A, B or C");
                            first = scanner.nextLine();
                            doubleLinkedList = polynomialSolver.getPoly(first.charAt(0));
                            if (doubleLinkedList.size() == 0) {
                                System.out.println("Variable not set");
                            } else {
                                flag = false;
                            }

                        }

                    }
                    flag2 = false;
                    System.out.println("Insert second operand variable name: A, B or C");
                    second = scanner.nextLine();
                    doubleLinkedList = polynomialSolver.getPoly(second.charAt(0));
                    if (doubleLinkedList.size() == 0) {
                        System.out.println("Variable not set");
                        flag = true;
                        while (flag) {
                            System.out.println("Insert second operand variable name: A, B or C");
                            second = scanner.nextLine();
                            doubleLinkedList = polynomialSolver.getPoly(second.charAt(0));
                            if (doubleLinkedList.size() == 0) {
                                System.out.println("Variable not set");
                            } else {
                                flag = false;
                            }

                        }

                    }
                    polynomialSolver.multiply(first.charAt(0), second.charAt(0));
                    System.out.println("Result value in R "+polynomialSolver.print('R'));


//                    System.out.println("Insert first operand variable name: A, B or C");
//                    first = scanner.nextLine();
//                    System.out.println("Insert second operand variable name: A, B or C");
//                    second = scanner.nextLine();
//                    polynomialSolver.multiply(first.charAt(0), second.charAt(0));
                    break;
                case "6":
                    System.out.println("Insert  operand variable name: A, B or C");
                    String operand = scanner.nextLine();
                    doubleLinkedList = polynomialSolver.getPoly(operand.charAt(0));
                    if (doubleLinkedList.size() == 0) {
                        boolean f = true;
                        System.out.println("variable not set");
                        while (f) {
                            System.out.println("Insert  operand variable name: A, B or C");
                            operand = scanner.nextLine();
                            doubleLinkedList = polynomialSolver.getPoly(operand.charAt(0));
                            if(doubleLinkedList.size()==0){
                                System.out.println("variable not set");
                            }else {
                                f = false;
                            }

                        }
                    }
                    System.out.println("Insert the point you want to evaluate at ");
                    float value = scanner.nextFloat();
                    scanner.nextLine();
                    polynomialSolver.evaluatePolynomial(operand.charAt(0), value);
                    System.out.println("the value of the point "+ value +" is "+ polynomialSolver.evaluatePolynomial(operand.charAt(0), value));
                    break;
                case "7":
                    System.out.println("Insert  operand variable name: A, B or C");
                    operand = scanner.nextLine();
                    polynomialSolver.clearPolynomial(operand.charAt(0));
                    break;
                default:
                    throw new RuntimeException("wrong input");
            }

        }
    }


    public static int[][] translateStringIntoArr(String s) {
        if (s.length() == 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        String index = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                index += '-';
            } else if (Character.isDigit(s.charAt(i))) {
                index += s.charAt(i);
            } else if (s.charAt(i) == '.') {
                throw new RuntimeException("you must enter just Integers");
            } else {
                if (index == "") {
                    //do nothing
                } else {
                    arrayList.add(index);
                    index = "";
                }
            }
        }
        int[] poly = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            poly[i] = Integer.parseInt(arrayList.get(i));
        }
        int[][] requiredArr = new int[poly.length / 2][2];
        int polyIndex = 0;
        for (int i = 0; i < requiredArr.length; i++) {
            for (int j = 0; j < 2; j++) {
                requiredArr[i][j] = poly[polyIndex];
                polyIndex++;
            }
        }

        return requiredArr;
    }

    public static void printList() {
        System.out.println("Please choose an action\n" +
                "-----------------------\n" +
                "1- Set a polynomial variable\n" +
                "2- Print the value of a polynomial variable\n" +
                "3- Add two polynomials\n" +
                "4- Subtract two polynomials\n" +
                "5- Multiply two polynomials\n" +
                "6- Evaluate a polynomial at some point\n" +
                "7- Clear a polynomial variable\n" +
                "====================================================================");
    }

    public static void subList() {
        System.out.println("Insert the variable name: A, B or C");
        String name = scanner.nextLine();

        switch (name) {
            case "A":
                System.out.println("Insert the polynomial terms in the form:\n" +
                        "(coeff1, exponent1), (coeff2, exponent2), ..");
                String input = scanner.nextLine();
                int arr[][] = translateStringIntoArr(input);
                if (arr == null) {//you didn't enter anything fool
                    System.out.println("Variable not set");
                } else {
                    polynomialSolver.setPolynomial('A', arr);
                    System.out.println("Polynomial A is set");
                }
                break;

            case "B":
                System.out.println("Insert the polynomial terms in the form:\n" +
                        "(coeff1, exponent1), (coeff2, exponent2), ..");
                input = scanner.nextLine();
                int arr1[][] = translateStringIntoArr(input);
                if (arr1 == null) {
                    System.out.println("Variable not set");
                } else {
                    polynomialSolver.setPolynomial('B', arr1);
                    System.out.println("Polynomial B is set");
                }
                break;

            case "C":
                System.out.println("Insert the polynomial terms in the form:\n" +
                        "(coeff1, exponent1), (coeff2, exponent2), ..");
                input = scanner.nextLine();
                int arr2[][] = translateStringIntoArr(input);
                if (arr2 == null) {
                    System.out.println("Variable not set");
                } else {
                    polynomialSolver.setPolynomial('B', arr2);
                    System.out.println("Polynomial C is set");
                }
                break;
            default:
                throw new RuntimeException("wrong input");
        }
    }

}
