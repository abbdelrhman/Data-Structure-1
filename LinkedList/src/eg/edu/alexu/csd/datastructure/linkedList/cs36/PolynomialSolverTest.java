package eg.edu.alexu.csd.datastructure.linkedList.cs36;

import org.junit.Test;

import static org.junit.Assert.*;

public class PolynomialSolverTest {
    @Test
    public void testSolveAdd() {
        final IPolynomialSolver instance =
                (IPolynomialSolver) new PolynomialSolver();
        final int[][] c = {{3, 7 }, {45, 5 },
                {176, 3 }, {128, 1 } };
        final int[][] b = {{-120, 5 }, {-1, 3 },
                {27, 2 }, {1, 1 }, {-1, 0 } };
        instance.setPolynomial('C', c);
        instance.setPolynomial('B', b);
        assertEquals("3x^7+45x^5+176x^3+128x",
                instance.print('C'));
    }

    /**
     * TO TEST POLY2.
     */
    @Test
    public void testSolveMULTIBLY() {
        final IPolynomialSolver instance =
                (IPolynomialSolver) new PolynomialSolver();
        final int[][] a = {{0, 7 }, {0, 5 },
                {0, 3 }, {0, 1 } };
        final int[][] b = {{0, 5 }, {-1, 3 },
                {0, 2 }, {1, 1 }, {-1, 0 } };
        instance.setPolynomial('A', a);
        instance.setPolynomial('B', b);
        instance.multiply('A', 'B');
        assertEquals("", instance.print('R'));
    }

}