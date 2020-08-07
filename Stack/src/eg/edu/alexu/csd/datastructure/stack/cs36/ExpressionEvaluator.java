package eg.edu.alexu.csd.datastructure.stack.cs36;

public class ExpressionEvaluator implements IExpressionEvaluator {
    /***
     * this method translate from infix to postfix
     * @param expression and this expression in the infix form
     * infix expression
     * @return this expression in postfix form
     */

    @Override
    public String infixToPostfix(String expression) {
        expression = expression.replaceAll("\\s+", "");
        if (checkConsecutiveOperator(expression)) {
            System.out.println("consecutive operator ");
            throw new RuntimeException("Syntax error");
        }
        expression = distributeTheNegative(expression);
        Stack s = new Stack();
        String ans = "";
        for (int i = 0; i < expression.length(); i++) {
//parenthesis
            if (IsOperand(expression.charAt(i)) || (i == 0 && expression.charAt(i) == '-') ||
                    (i > 0 && isOpeningParenthesis(expression.charAt(i - 1)) && expression.charAt(i) == '-') ||
                    (i > 0 && (expression.charAt(i - 1) == '*' || expression.charAt(i - 1) == '+' || expression.charAt(i - 1) == '/') && expression.charAt(i) == '-')) {

                ans += expression.charAt(i);

            } else if (isOperator(expression.charAt(i))) {
                ans += ',';
                while (!s.isEmpty() && higherPrecedence((char) s.peek(), expression.charAt(i)) && !isOpeningParenthesis((char) s.peek())) {
                    ans += (char) s.pop();
                    ans += ',';
                }
                s.push((char) expression.charAt(i));
            } else if (isOpeningParenthesis(expression.charAt(i))) {
                s.push((char) expression.charAt(i));
            } else if (isClosingParenthesis(expression.charAt(i))) {
                int test = 0;
                while (!s.isEmpty() && !isOpeningParenthesis((char) s.peek())) {
                    test++;
                    ans += ',';
                    ans += (char) s.pop();

                }
                s.pop();
                if (test == 0) {
                    throw new RuntimeException("unbalanced expression");
                }
            }
        }
        while (!s.isEmpty()) {
            if (isOpeningParenthesis((char) s.peek())) {
                throw new RuntimeException("unbalanced expression");
            }
            ans += ',';
            ans += (char) s.pop();

        }
        for(int i=0 ; i<ans.length()-1 ; i++){
            if(ans.charAt(i) == '-' && ans.charAt(i+1) == '-'){
                ans=ans.replace(ans.charAt(i+1),' ');
              ans = ans.replace(ans.charAt(i+1),' ');
            }
        }
        ans =ans.replaceAll("\\s+" , "");
      //  System.out.println("the answer is "+ans);

        return ans;
    }

    /***
     * this method evaluate an expression but the expression in postfix form
     * @param expression in postfix form
     * postfix expression
     * @return the value of the evaluation of the expression
     */
    @Override
    public int evaluate(String expression) {
        Stack s = new Stack();
        String[] arr = expression.split(",");
        for (int i = 0; i < arr.length; i++) {
            if (isOperator(arr[i].charAt(0)) && arr[i].length() == 1) {
                int op2 = (int) s.pop();
                int op1 = (int) s.pop();
                int res = calc(op1, op2, arr[i].charAt(0));
                s.push(res);
            } else {
                int value = Integer.parseInt(arr[i]);
                s.push(value);
            }
        }

        return (int) s.peek();
    }

    /***
     * this method evaluate a sub expression in the whole expression
     * @param op1 operand 1
     * @param op2 operand 2
     * @param charAt operator
     * @return the value of operand 1 operator operand 2
     */

    private int calc(int op1, int op2, char charAt) {
        switch (charAt) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;
            default:
                return -1;
        }
    }

    /***
     * this method returns the weight of operator which will help in the precedence
     * @param c the operator
     * @return the weight of the operator
     */

    private int weight(char c) {
        if (isOpeningParenthesis(c)) {
            return 3;
        }
        switch (c) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    /*** this method helps to know if this character is closing parenthesis ) ] }
     * @param c character
     * @return true if this character is closing and false otherwise
     */

    private boolean isClosingParenthesis(char c) {

        if (c == ')' || c == ']' || c == '}') {
            return true;
        }
        return false;
    }

    /***
     * test if first param has higher precedence above the second one
     * @param peek an operator at the peek of the stack
     * @param charAt an operator in the expression
     * @return true if the peek has higher precedence false other wise
     */
    private boolean higherPrecedence(char peek, char charAt) {
        if (weight(peek) >= weight(charAt)) {
            return true;
        }
        return false;
    }

    private boolean isOperator(char charAt) {
        if (charAt == '+' || charAt == '-' || charAt == '*' || charAt == '/') {
            return true;
        } else {
            return false;
        }

    }

    private boolean isOpeningParenthesis(char c) {
        if (c == '(' || c == '[' || c == '{') {
            return true;
        }
        return false;
    }

    private boolean IsOperand(char charAt) {
        if (charAt >= 'a' && charAt <= 'z') return true;
        if (charAt >= 'A' && charAt <= 'Z') return true;
        return Character.isDigit(charAt) ? true : false;
    }

    private boolean checkConsecutiveOperator(String expression) {
        for (int i = 1; i < expression.length(); i++) {
            if ((i > 0 &&
                    (expression.charAt(i - 1) == '*' || expression.charAt(i - 1) == '*' || expression.charAt(i - 1) == '+' || expression.charAt(i - 1) == '/') && expression.charAt(i) == '-')) {

            } else if (isOperator(expression.charAt(i)) && isOperator(expression.charAt(i - 1))) {
                return true;
            }
        }
        return false;
    }

    public String distributeTheNegative(String exp){
        for(int i=0 ; i<exp.length()-1 ; i++){
            //here we need to distribute the sign
            if(exp.charAt(i)=='-' && isOpeningParenthesis(exp.charAt(i+1))) { // ana wa2f 3nd - w b3deeh (   -( (5-3) * 4 )
              exp = exp.substring(0,i+1)+"1*"+exp.substring(i+1);
            }else if (IsOperand(exp.charAt(i)) && isOpeningParenthesis(exp.charAt(i+1))){
                exp = exp.substring(0,i+1)+"*"+exp.substring(i+1);
            }
        }
        return exp;
    }

}
