package com.dborisov.lesson_1_task_01_binaryGap;

public class Solution {

    public int solution(int N) {
        if (N <= 0) {
            return 0;
        }
        if (N == 2_147_483_647) {
            return 0;
        }

        final int isPowerOfTwo = N & (N - 1);
        if (isPowerOfTwo == 0) {
            return 0;
        }

        final int isLessOnOneFromPowerOfTwo = N & (N + 1);
        if (isLessOnOneFromPowerOfTwo == 0) {
            return 0;
        }

        return calculateGap(Integer.toBinaryString(N));
    }

    private int calculateGap(String s) {
        final char char_0 = '0';
        final char char_1 = '1';

        int maxGapSize = 0;
        int currentGapSize = 0;
        boolean gapDetected = false;
        boolean beReadyForGap = false;

        for (char c : s.toCharArray()) {
            if (c == char_0 && !gapDetected && !beReadyForGap) {
                continue;
            }

            if (c == char_1 && !gapDetected) {
                beReadyForGap = true;
                continue;
            }

            if (c == char_0 && beReadyForGap) {
                currentGapSize = 1;
                gapDetected = true;
                beReadyForGap = false;
                continue;
            }

            if (c == char_0) {
                currentGapSize++;
                continue;
            }

            if (c == char_1) {
                if (currentGapSize > maxGapSize) {
                    maxGapSize = currentGapSize;
                }
                gapDetected = false;
                beReadyForGap = true;
            }
        }

        return maxGapSize;
    }
}
