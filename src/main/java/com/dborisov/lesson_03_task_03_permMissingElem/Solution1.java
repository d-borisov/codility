package com.dborisov.lesson_03_task_03_permMissingElem;

public class Solution1 {

    static final int MINIMUM_COUNT = 0;
    static final int MAXIMUM_COUNT = 100_000;

    static final int MINIMUM_VALUE = 1;
    static final int MAXIMUM_VALUE = 100_001;


    public int solution(int[] A) {
        for (int a : A) {
            if (a < MINIMUM_VALUE || a > MAXIMUM_VALUE) {
                return 0;
            }

            if (a > A.length + 1) {
                return 0;
            }
        }

        if (A.length == MINIMUM_COUNT || A.length > MAXIMUM_COUNT) {
            return 0;
        }

        if (A.length == 1 && A[0] == 1) {
            return 0;
        }

        return findMissedValue(A);
    }

    private static int findMissedValue(int[] A) {
        final long idealSum = sumOfArithmeticProgression(A.length + 1);
        long sum = 0;
        for (int a : A) {
            sum += a;
        }

        return (int) (idealSum - sum);
    }

    static long sumOfArithmeticProgression(int n) {
        final long resOfMultiplication = (long) n * (n + 1);
        final long res = resOfMultiplication / 2;

        // by checking it we test was there stack overflow
        if (res * 2 / n != (long) n + 1) {
            throw new RuntimeException("Invalid argument: " + n);
        }

        return res;
    }
}
