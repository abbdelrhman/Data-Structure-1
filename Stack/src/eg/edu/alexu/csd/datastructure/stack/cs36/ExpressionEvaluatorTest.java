package eg.edu.alexu.csd.datastructure.stack.cs36;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionEvaluatorTest {
    @Test
    public void firsTest() throws Exception{
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        // The Assignment Test Cases
        Assert.assertEquals("-32,-23,4,*,+",expressionEvaluator.infixToPostfix("-(32 + 23 * -4)"));
        Assert.assertEquals("a,b,*,c,/",expressionEvaluator.infixToPostfix("a * b / c"));
        Assert.assertEquals("1,2,+,7,*",expressionEvaluator.infixToPostfix("(1 + 2) * 7"));
        Assert.assertEquals("a,b,*,5,+",expressionEvaluator.infixToPostfix("a * b + 5"));
        Assert.assertEquals("a,b,c,-,d,+,/,e,a,-,*,c,*",expressionEvaluator.infixToPostfix("(a / (b - c + d)) * (e - a) * c"));
        Assert.assertEquals("a,b,/,c,-,d,e,*,+,a,c,*,-",expressionEvaluator.infixToPostfix("a / b - c + d * e - a * c"));
    }

    @Test
    public void test1() {
        IExpressionEvaluator post = new ExpressionEvaluator();
        final String test = "b-c+d*e-a";
        final String ans = "bc-de*+a-";
        Assert.assertEquals(ans, post.infixToPostfix(test));
    }


    @Test
    public void secondTest() throws Exception{
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        //Assignment Test Case
        assertEquals(8,expressionEvaluator.evaluate("6,2,/,3,-,4,2,*,+"));
        assertEquals((2+3) * 4,expressionEvaluator.evaluate("2,3,+,4,*"));
        assertEquals((1 + 2) * 7,expressionEvaluator.evaluate("1,2,+,7,*"));
        Assert.assertEquals(20,expressionEvaluator.evaluate("-1,-1,2,3,+,*,4,*,*"));


        // Some negative/multiple integer numbers Test Cases
        assertEquals(6/2 - -3 + (4*2),expressionEvaluator.evaluate("6,2,/,-3,-,4,2,*,+"));
        assertEquals(6/-2 - 3 + (4*-2),expressionEvaluator.evaluate("6,-2,/,3,-,4,-2,*,+"));
        assertEquals((int)Math.round(5/-2 - 3 + (4*-2)),expressionEvaluator.evaluate("5,-2,/,3,-,4,-2,*,+"));
        assertEquals((3*(1+(4+6))+2+8)*5+4*(7+2),expressionEvaluator.evaluate("3,1,4,6,+,+,*,2,+,8,+,5,*,4,7,2,+,*,+"));

    }

}