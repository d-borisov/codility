package com.dborisov.lesson_02_task_02_oddOccurrencesInArray;

import java.util.BitSet;

public class Solution1 {

    private static final int MAXIMUM_VALUE = 1_000_000_000;
    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_LENGTH = 1_000_000;
    private static final int MINIMUM_LENGTH = 1;

    public int solution(int[] A) {
        final int length = A.length;
        if (length < MINIMUM_LENGTH) {
            return 0;
        }
        if (length % 2 != 1) {
            return 0;
        }
        if (length > MAXIMUM_LENGTH) {
            return 0;
        }

        return findOddOccurence(A);
    }

    private int findOddOccurence(int[] A) {
        final BitSet bits = new BitSet(MAXIMUM_VALUE);
        for (int val : A) {
            if (val < MINIMUM_VALUE || val > MAXIMUM_VALUE) {
                throw new RuntimeException("Unexpected value: " + val);
            }
            bits.flip(val - 1);
        }
        final int i = bits.nextSetBit(0);
        return i + 1;
    }

}
