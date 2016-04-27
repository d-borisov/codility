package com.dborisov.lesson_02_task_02_oddOccurrencesInArray;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Solution2Test {

    @Test
    public void testBadInput() throws Exception {
        forArray().oddIs(0);
        forArray(1, 1).oddIs(0);
    }

    @Test
    public void test() throws Exception {
        forArray(1).oddIs(1);
        forArray(1, 1, 2).oddIs(2);
        forArray(1, 2, 3, 4, 1, 2, 3).oddIs(4);
    }

    @Test
    public void testBorders() throws Exception {
        forArray(1, 1, 1).oddIs(1);
        forArray(1_000_000_000, 1_000_000_000, 1).oddIs(1);
        forArray(1_000_000_000, 1_000_000_000, 1, 1, 1).oddIs(1);
        forArray(1_000_000_000, 1_000_000_000, 2, 2, 1).oddIs(1);
    }

    @Test
    public void testFromCodility() throws Exception {
        forArray(9, 3, 9, 3, 9, 7, 9).oddIs(7);
    }

    private Assertion forArray(int... arr) {
        return new Assertion(arr);
    }

    private static final class Assertion {
        private final int[] arr;

        private Assertion(int... arr) {
            this.arr = arr;
        }

        public void oddIs(int res) {
            final Solution2 solution = new Solution2();
            assertThat("For array: " + Arrays.toString(arr), solution.solution(arr), is(res));
        }
    }
}