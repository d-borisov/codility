package com.dborisov.lesson_1_task_01_binaryGap;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

    private static void assertSolution(int N, int result) {
        final Solution s = new Solution();
        assertThat("for number : " + N + ", 0b" + Integer.toBinaryString(N), s.solution(N), is(result));
    }

    @Test
    public void testSimple() throws Exception {
        assertSolution(0b0, 0);
        assertSolution(0b1, 0);
        assertSolution(0b10, 0);
        assertSolution(0b11, 0);
        assertSolution(0b100, 0);
        assertSolution(0b101, 1);
        assertSolution(0b110, 0);
        assertSolution(0b111, 0);
        assertSolution(0b1000, 0);
        assertSolution(0b1001, 2);
        assertSolution(0b1010, 1);
        assertSolution(0b1011, 1);
        assertSolution(0b1100, 0);
        assertSolution(0b1101, 1);
        assertSolution(0b1110, 0);
        assertSolution(0b1111, 0);
    }

    @Test
    public void testStairway() throws Exception {
        assertSolution(0b101, 1);
        assertSolution(0b1001, 2);
        assertSolution(0b10001, 3);
        assertSolution(0b100001, 4);
        assertSolution(0b1000001, 5);
        assertSolution(0b10000001, 6);
        assertSolution(0b100000001, 7);
        assertSolution(0b1000000001, 8);
    }

    @Test
    public void testOpenedFromTheLeft() throws Exception {
        assertSolution(0b1, 0);
        assertSolution(0b01, 0);
        assertSolution(0b001, 0);
        assertSolution(0b0001, 0);
        assertSolution(0b00001, 0);
        assertSolution(0b000001, 0);
    }

    @Test
    public void testOpenedFromTheRight() throws Exception {
        assertSolution(0b1, 0);
        assertSolution(0b10, 0);
        assertSolution(0b100, 0);
        assertSolution(0b1000, 0);
        assertSolution(0b10000, 0);
        assertSolution(0b100000, 0);
    }

    @Test
    public void testIncremented() throws Exception {
        assertSolution(0b101, 1);
        assertSolution(0b101001, 2);
        assertSolution(0b1010010001, 3);
        assertSolution(0b101001000100001, 4);
        assertSolution(0b101001000100001000001, 5);
    }

    @Test
    public void testDecremented() throws Exception {
        assertSolution(0b1000001, 5);
        assertSolution(0b100000100001, 5);
        assertSolution(0b1000001000010001, 5);
        assertSolution(0b1000001000010001001, 5);
        assertSolution(0b100000100001000100101, 5);
    }

    @Test
    public void testIncrementedWithRightOpened() throws Exception {
        assertSolution(0b10100000000, 1);
        assertSolution(0b10100100000000, 2);
        assertSolution(0b101001000100000000, 3);
        assertSolution(0b10100100010000100000000, 4);
        assertSolution(0b10100100010000100000100000000, 5);
    }

    @Test
    public void testDecrementedWithRightOpened() throws Exception {
        assertSolution(0b100000100000000, 5);
        assertSolution(0b10000010000100000000, 5);
        assertSolution(0b100000100001000100000000, 5);
        assertSolution(0b100000100001000100100000000, 5);
        assertSolution(0b10000010000100010010100000000, 5);
    }

    @Test
    public void testFromCodility() throws Exception {
        assertSolution(0b10000010001, 5);
    }
}