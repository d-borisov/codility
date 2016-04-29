package com.dborisov.lesson_03_task_01_frogJmp;

public class Solution {

    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_VALUE = 1_000_000_000;

    public int solution(int X, int Y, int D) {
        if (X < MINIMUM_VALUE || X > MAXIMUM_VALUE) {
            return 0;
        }

        if (Y < MINIMUM_VALUE || Y > MAXIMUM_VALUE) {
            return 0;
        }

        if (D < MINIMUM_VALUE || D > MAXIMUM_VALUE) {
            return 0;
        }

        if (X > Y) {
            return 0;
        }

        final int quotient = (Y - X) / D;
        final int remainder = (Y - X) % D;

        return remainder > 0
                ? quotient + 1
                : quotient;
    }

}
