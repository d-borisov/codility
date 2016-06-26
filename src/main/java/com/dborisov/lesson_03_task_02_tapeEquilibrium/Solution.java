package com.dborisov.lesson_03_task_02_tapeEquilibrium;

public class Solution {

    static final int MINIMUM_LENGTH = 2;
    static final int MAXIMUM_LENGTH = 100_000;
    static final int MINIMUM_VALUE = -1_000;
    static final int MAXIMUM_VALUE = 1_000;

    public int solution(int[] A) {
        if (A.length < MINIMUM_LENGTH || A.length > MAXIMUM_LENGTH) {
            return 0;
        }

        for (int a : A) {
            if (a < MINIMUM_VALUE || a > MAXIMUM_VALUE) {
                return 0;
            }
        }

        return calculate(A);
    }

    private static int calculate(int[] A) {
        final int[] fromTheBeginning = new int[A.length];
        final int[] fromTheEnd = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                fromTheBeginning[0] = A[i];
                fromTheEnd[A.length - 1] = A[A.length - 1];
                continue;
            }
            fromTheBeginning[i] = fromTheBeginning[i - 1] + A[i];
            fromTheEnd[A.length - 1 - i] = fromTheEnd[A.length - i] + A[A.length - i - 1];
        }

        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            final int difference = Math.abs(fromTheBeginning[i] - fromTheEnd[i + 1]);
            if (difference == 0) {
                return 0;
            }

            if (difference < minimum) {
                minimum = difference;
            }
        }

        return minimum;
    }

}
