package com.dborisov.lesson_02_task_01_cyclicRotation;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

    @Test
    public void testRotationForZero() throws Exception {
        assertArray().withSteps(0).is().equal();
        assertArray(1).withSteps(0).is().equal(1);
        assertArray(1, 2).withSteps(0).is().equal(1, 2);
        assertArray(1, 2, 3).withSteps(0).is().equal(1, 2, 3);
        assertArray(1, 2, 3, 4).withSteps(0).is().equal(1, 2, 3, 4);
        assertArray(1, 2, 3, 4, 5).withSteps(0).is().equal(1, 2, 3, 4, 5);
    }

    @Test
    public void testRotationForOne() throws Exception {
        assertArray().withSteps(1).is().equal();
        assertArray(1).withSteps(1).is().equal(1);
        assertArray(1, 2).withSteps(1).is().equal(2, 1);
        assertArray(1, 2, 3).withSteps(1).is().equal(3, 1, 2);
        assertArray(1, 2, 3, 4).withSteps(1).is().equal(4, 1, 2, 3);
        assertArray(1, 2, 3, 4, 5).withSteps(1).is().equal(5, 1, 2, 3, 4);
    }

    @Test
    public void testRotationForTwo() throws Exception {
        assertArray().withSteps(2).is().equal();
        assertArray(1).withSteps(2).is().equal(1);
        assertArray(1, 2).withSteps(2).is().equal(1, 2);
        assertArray(1, 2, 3).withSteps(2).is().equal(2, 3, 1);
        assertArray(1, 2, 3, 4).withSteps(2).is().equal(3, 4, 1, 2);
        assertArray(1, 2, 3, 4, 5).withSteps(2).is().equal(4, 5, 1, 2, 3);
    }

    @Test
    public void testRotationForThree() throws Exception {
        assertArray().withSteps(3).is().equal();
        assertArray(1).withSteps(3).is().equal(1);
        assertArray(1, 2).withSteps(3).is().equal(2, 1);
        assertArray(1, 2, 3).withSteps(3).is().equal(1, 2, 3);
        assertArray(1, 2, 3, 4).withSteps(3).is().equal(2, 3, 4, 1);
        assertArray(1, 2, 3, 4, 5).withSteps(3).is().equal(3, 4, 5, 1, 2);
    }

    @Test
    public void testRotationForFour() throws Exception {
        assertArray().withSteps(4).is().equal();
        assertArray(1).withSteps(4).is().equal(1);
        assertArray(1, 2).withSteps(4).is().equal(1, 2);
        assertArray(1, 2, 3).withSteps(4).is().equal(3, 1, 2);
        assertArray(1, 2, 3, 4).withSteps(4).is().equal(1, 2, 3, 4);
        assertArray(1, 2, 3, 4, 5).withSteps(4).is().equal(2, 3, 4, 5, 1);
    }

    @Test
    public void testRotationForFive() throws Exception {
        assertArray().withSteps(5).is().equal();
        assertArray(1).withSteps(5).is().equal(1);
        assertArray(1, 2).withSteps(5).is().equal(2, 1);
        assertArray(1, 2, 3).withSteps(5).is().equal(2, 3, 1);
        assertArray(1, 2, 3, 4).withSteps(5).is().equal(4, 1, 2, 3);
        assertArray(1, 2, 3, 4, 5).withSteps(5).is().equal(1, 2, 3, 4, 5);
    }

    @Test
    public void testRotationForSix() throws Exception {
        assertArray().withSteps(6).is().equal();
        assertArray(1).withSteps(6).is().equal(1);
        assertArray(1, 2).withSteps(6).is().equal(1, 2);
        assertArray(1, 2, 3).withSteps(6).is().equal(1, 2, 3);
        assertArray(1, 2, 3, 4).withSteps(6).is().equal(3, 4, 1, 2);
        assertArray(1, 2, 3, 4, 5).withSteps(6).is().equal(5, 1, 2, 3, 4);
    }

    @Test
    public void testFromCodility() throws Exception {
        assertArray(3, 8, 9, 7, 6).withSteps(3).is().equal(9, 7, 6, 3, 8);
    }

    private static Assertion assertArray(int... arr) {
        return new Assertion(arr);
    }

    private static final class Assertion {
        private final int[] A;
        private int K = 0;

        private Assertion(int[] A) {
            this.A = A;
        }

        private Assertion withSteps(int K) {
            this.K = K;
            return this;
        }

        private Equality is() {
            return new Equality(A, K);
        }
    }

    private static final class Equality {
        private final int[] A;
        private final int K;

        private Equality(int[] A, int K) {
            this.A = A;
            this.K = K;
        }

        public void equal(int... res) {
            final Solution s = new Solution();
            assertThat("for array : " + Arrays.toString(A) + " and K=" + K, s.solution(A, K), is(res));
        }
    }
}