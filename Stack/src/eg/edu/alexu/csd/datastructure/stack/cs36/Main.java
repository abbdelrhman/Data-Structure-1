package eg.edu.alexu.csd.datastructure.stack.cs36;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        String string= expressionEvaluator.infixToPostfix("-10(311+1)");
        System.out.println(string);
        String arr [] = string.split(",");
        System.out.println(Arrays.toString(arr));
        System.out.println(expressionEvaluator.evaluate(string));

    }
    public static String distributeTheNegative(String exp){
        for(int i=0 ; i<exp.length()-1 ; i++){
            //here we need to distribute the sign
            if(exp.charAt(i)=='-' && isOpeningParenthesis(exp.charAt(i+1))) { // ana wa2f 3nd - w b3deeh (   -( (5-3) * 4 )
                exp = exp.substring(0,i+1)+"1*"+exp.substring(i+1);
            }
        }
        return exp;
    }

    private static boolean isOpeningParenthesis(char c) {
        if (c == '(' || c == '[' || c == '{') {
            return true;
        }
        return false;
    }

}
