package com.dborisov.lesson_03_task_03_permMissingElem;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Solution2Test {

    @Test
    public void testInvalid() throws Exception {
        forArguments(-1).isEqual(0);
        forArguments(100_001).isEqual(0);
        forArguments(-1, 1).isEqual(0);
        forArguments(1, 100_001).isEqual(0);
    }

    @Test
    public void testBorder() throws Exception {
        forArguments().isEqual(0);
    }

    @Test
    public void test() throws Exception {
        forArguments(1).isEqual(0);
        forArguments(2).isEqual(1);
        forArguments(1, 3).isEqual(2);
        forArguments(2, 3).isEqual(1);
        forArguments(1, 2, 3).isEqual(4);
        forArguments(1, 2, 4).isEqual(3);
    }

    @Test
    public void testBigData() throws Exception {
        final int missedValue = new Random().nextInt(Solution2.MAXIMUM_VALUE);
        final int[] arr = IntStream
                .rangeClosed(Solution2.MINIMUM_VALUE, Solution2.MAXIMUM_VALUE)
                .filter(value -> value != missedValue)
                .toArray();
        forArguments(arr).isEqual(missedValue);
    }

    @Test
    public void testFromCodility() throws Exception {
        forArguments(2, 3, 1, 5).isEqual(4);
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
            final Solution2 solution = new Solution2();
            assertThat(solution.solution(elements), is(result));
        }
    }
}