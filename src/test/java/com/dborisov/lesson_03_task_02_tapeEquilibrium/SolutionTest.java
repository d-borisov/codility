package com.dborisov.lesson_03_task_02_tapeEquilibrium;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    // check that int buffer for sum is enough
    @Test
    public void testAssumption() throws Exception {
        assertTrue(Solution.MAXIMUM_VALUE * Solution.MAXIMUM_LENGTH < Integer.MAX_VALUE);
        assertTrue(Solution.MINIMUM_VALUE * Solution.MAXIMUM_LENGTH > Integer.MIN_VALUE);
    }

    @Test
    public void testInvalid() throws Exception {
        forArguments().isEqual(0);
        forArguments(1).isEqual(0);
        forArguments(1_000).isEqual(0);
        forArguments(1, 1_001).isEqual(0);
        forArguments(1, -1_001).isEqual(0);
        forArguments(1, 999_999).isEqual(0);
        forArguments(1, -999_999).isEqual(0);
    }

    @Test
    public void testTwo() throws Exception {
        forArguments(0, 0).isEqual(0);
        forArguments(1, 1).isEqual(0);
        forArguments(-1, -1).isEqual(0);
        forArguments(1_000, 1_000).isEqual(0);
        forArguments(-1_000, -1_000).isEqual(0);
        forArguments(-1, 1).isEqual(2);
        forArguments(1, -1).isEqual(2);
        forArguments(1_000, -1_000).isEqual(2_000);
        forArguments(-1_000, 1_000).isEqual(2_000);
        forArguments(0, 1_000).isEqual(1_000);
        forArguments(0, -1_000).isEqual(1_000);
    }

    @Test
    public void testThree() throws Exception {
        forArguments(0, 0, 0).isEqual(0);
        forArguments(0, 0, 1).isEqual(1);
        forArguments(0, 1, 2).isEqual(1);
        forArguments(1, 2, 3).isEqual(0);
        forArguments(1_000, 1_000, 1_000).isEqual(1_000);
        forArguments(-1_000, -1_000, -1_000).isEqual(1_000);
        forArguments(1_000, -1_000, -1_000).isEqual(1_000);
        forArguments(1_000, 1_000, -1_000).isEqual(1_000);
        forArguments(0, -1_000, 1_000).isEqual(0);
        forArguments(0, 0, 1_000).isEqual(1_000);
        forArguments(0, 0, -1_000).isEqual(1_000);
    }

    @Test
    public void testFour() throws Exception {
        forArguments(0, 0, 0, 0).isEqual(0);
        forArguments(0, 0, 0, 1).isEqual(1);
        forArguments(0, 0, 1, 2).isEqual(1);
        forArguments(0, 1, 2, 3).isEqual(0);
    }

    @Test
    public void testFive() throws Exception {
        forArguments(0, 0, 0, 0, 0).isEqual(0);
        forArguments(0, 0, 0, 0, 1).isEqual(1);
        forArguments(0, 0, 0, 1, 2).isEqual(1);
        forArguments(0, 0, 1, 2, 3).isEqual(0);
        forArguments(0, 1, 2, 3, 4).isEqual(2);
    }

    @Test
    public void testSix() throws Exception {
        forArguments(0, 0, 0, 0, 0, 0).isEqual(0);
        forArguments(0, 0, 0, 0, 0, 1).isEqual(1);
        forArguments(0, 0, 0, 0, 1, 2).isEqual(1);
        forArguments(0, 0, 0, 1, 2, 3).isEqual(0);
        forArguments(0, 0, 1, 2, 3, 4).isEqual(2);
        forArguments(0, 1, 2, 3, 4, 5).isEqual(3);
    }

    @Test
    public void testSeven() throws Exception {
        forArguments(0, 0, 0, 0, 0, 0, 0).isEqual(0);
        forArguments(0, 0, 0, 0, 0, 0, 1).isEqual(1);
        forArguments(0, 0, 0, 0, 0, 1, 2).isEqual(1);
        forArguments(0, 0, 0, 0, 1, 2, 3).isEqual(0);
        forArguments(0, 0, 0, 1, 2, 3, 4).isEqual(2);
        forArguments(0, 0, 1, 2, 3, 4, 5).isEqual(3);
        forArguments(0, 1, 2, 3, 4, 5, 6).isEqual(1);
    }

    @Test
    public void testFromCodility() throws Exception {
        forArguments(3, 1, 2, 4, 3).isEqual(1);
    }

    private static Assertion forArguments(int... elements) {
        return new Assertion(elements);
    }

    private static class Assertion {

        private final int[] elements;

        private Assertion(int[] elements) {
            this.elements = elements;
        }

        private void isEqual(int result) {
            final Solution solution = new Solution();
            assertThat(solution.solution(elements), is(result));
        }
    }
}