package com.dborisov.lesson_02_task_01_cyclicRotation;

public class Solution {

    public int[] solution(int[] A, int K) {
        if (K <= 0) {
            return A;
        }

        if (A.length == 0 || A.length == 1) {
            return A;
        }

        final int normalizedShifts = K % A.length;
        if (normalizedShifts == 0) {
            return A;
        }

        return doRotation(A, normalizedShifts);
    }

    private int[] doRotation(int[] A, int K) {
        final int length = A.length;
        final int[] res = new int[length];
        for (int i = 0; i < K; i++) {
            res[i] = A[length - K + i];
        }
        for (int i = 0; i < length - K; i++) {
            res[K + i] = A[i];
        }
        return res;
    }
}
