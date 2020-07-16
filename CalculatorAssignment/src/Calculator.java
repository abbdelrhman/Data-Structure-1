public class Calculator implements ICalculator {
	//hendawy says hello
    @Override
    public int add(final int x,final int y) {
        return (x + y);
    }

    @Override
    public float divide(final int x, final int y) throws RuntimeException {
        if (y == 0) {
            throw new RuntimeException("Division by zero!");
        }else {
            return (float)x/y ;
        }
    }
}
