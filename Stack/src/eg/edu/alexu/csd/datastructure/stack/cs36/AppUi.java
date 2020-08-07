package eg.edu.alexu.csd.datastructure.stack.cs36;

import java.util.EmptyStackException;
import java.util.Scanner;

public class AppUi {
    static Scanner s1 = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("enter 1 for stack application or 2 for infix to postfix application");
        String  i = s1.nextLine();
        int g= Integer.parseInt(i) ;
        if(g==1){
            Object n;
            Stack st = new Stack();

            while (true) {
                System.out.println("Choose An Option :\n===============================" + "\n1: Push\n" + "2: Pop\n"
                        + "3: Peek\n" + "4: Get size\n" + "5: Check if empty");
                n = s1.nextLine();
                if (((String)n).equals("1")) {
                    System.out.println("Enter Any Object/Primitive Type/NumberOrText");
                    n = s1.nextLine();
                    st.push(n);
                } else if (((String)n).equals("2")) {
                    System.out.println(st.pop());
                } else if (((String)n).equals("3")) {
                    System.out.println(st.peek());
                } else if (((String)n).equals("4")) {
                    System.out.println(st.size());
                } else if (((String)n).equals("5")) {
                    System.out.println(st.isEmpty());
                } else {
                    throw new RuntimeException("Invalid Choice");
                }
//                System.out.println("Press Enter Key To Continue....");
//                s1.nextLine();
            }
        }else if(g==2){
            String expression = new String(), n = new String();
            int a = 0;
            ExpressionEvaluator tester = new ExpressionEvaluator();
            Scanner s1 = new Scanner(System.in);
            while (true) {

                System.out.println("Choose An Option :\n===============================" + "\n1:to convert Infix To Postfix\n"
                        + "2: Evaluate Previous Expression\n");
                n = s1.nextLine();
                if (n.equals("1")) {
                    System.out.println("Enter Expression");
                    expression = s1.nextLine();
                    expression = tester.infixToPostfix(expression);
                    System.out.println(expression);
                } else if (n.equals("2")) {
                    if (expression.length() != 0) {
                        a = tester.evaluate(expression);
                        System.out.println(a);
                    } else {
                        System.out.println("Empty");
                        continue;
                    }
                } else {
                    throw new RuntimeException("Invalid Choice");
                }
                System.out.println("Press Enter Key To Continue....");
                s1.nextLine();
            }
        }
    }

    public static void main1() {

    }
    public static void main2() throws EmptyStackException {

    }
}
