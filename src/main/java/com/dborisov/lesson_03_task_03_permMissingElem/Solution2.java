package com.dborisov.lesson_03_task_03_permMissingElem;

import java.util.BitSet;

public class Solution2 {

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
        final BitSet bits = new BitSet(A.length + 1);
        for (int a : A) {
            bits.flip(a - 1);
        }

        return bits.nextClearBit(0) + 1;
    }
}
