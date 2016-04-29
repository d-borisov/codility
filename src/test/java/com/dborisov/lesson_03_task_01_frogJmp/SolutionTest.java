package com.dborisov.lesson_03_task_01_frogJmp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

    @Test
    public void testBorders() throws Exception {
        forArguments(0, 2, 3).isEqual(0);
        forArguments(1, 0, 3).isEqual(0);
        forArguments(1, 2, 0).isEqual(0);
    }

    @Test
    public void testForOne() throws Exception {
        forArguments(1, 1, 1).isEqual(0);
        forArguments(1, 2, 1).isEqual(1);
        forArguments(1, 3, 1).isEqual(2);
        forArguments(1, 4, 1).isEqual(3);
        forArguments(1, 5, 1).isEqual(4);
    }

    @Test
    public void testForTwo() throws Exception {
        forArguments(1, 1, 2).isEqual(0);
        forArguments(1, 2, 2).isEqual(1);
        forArguments(1, 3, 2).isEqual(1);
        forArguments(1, 4, 2).isEqual(2);
        forArguments(1, 5, 2).isEqual(2);
    }

    @Test
    public void testForThree() throws Exception {
        forArguments(1, 1, 3).isEqual(0);
        forArguments(1, 2, 3).isEqual(1);
        forArguments(1, 3, 3).isEqual(1);
        forArguments(1, 4, 3).isEqual(1);
        forArguments(1, 5, 3).isEqual(2);
    }

    @Test
    public void testFromCodility() throws Exception {
        forArguments(10, 85, 30).isEqual(3);
    }

    private Assertion forArguments(int X, int Y, int D) {
        return new Assertion(X, Y, D);
    }

    private static final class Assertion {
        private final int x;
        private final int y;
        private final int d;

        private Assertion(int X, int Y, int D) {
            this.x = X;
            this.y = Y;
            this.d = D;
        }

        private void isEqual(int res) {
            final Solution solution = new Solution();
            assertThat(solution.solution(x, y, d), is(res));
        }
    }
}