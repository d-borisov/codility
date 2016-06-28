package com.dborisov.lesson_04_task_01_frogRiverOne.lesson_03_task_03_permMissingElem;

public class Solution {

    static final int MINIMUM_LENGTH = 0;
    static final int MAXIMUM_LENGTH = 100_000;
    static final int MINIMUM_LARGE = 0;
    static final int MAXIMUM_LARGE = 100_000;
    static final int CANNOT_PASS = -1;

    public int solution(int X, int[] A) {
        if (X == MINIMUM_LARGE) {
            return CANNOT_PASS;
        }

        if (X > MAXIMUM_LARGE) {
            return CANNOT_PASS;
        }

        if (A.length < X) {
            return CANNOT_PASS;
        }

        if (A.length > MAXIMUM_LENGTH) {
            return CANNOT_PASS;
        }

        for (final int a : A) {
            if (a < 1 || a > X) {
                return CANNOT_PASS;
            }
        }

        return calculateSolution(X, A);
    }

    private static int calculateSolution(int X, int[] A) {
        final int[] count = new int[X];
        int madeJumps = 0;

        for (int i = 0; i < A.length; i++) {
            final int leafPosition = A[i] - 1;
            if (count[leafPosition] == 0) {
                count[leafPosition]++;
                madeJumps++;

                if (madeJumps == X) {
                    return i;
                }
            }
        }

        return CANNOT_PASS;
    }
}
