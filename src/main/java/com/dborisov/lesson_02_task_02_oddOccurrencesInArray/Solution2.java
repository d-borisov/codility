package com.dborisov.lesson_02_task_02_oddOccurrencesInArray;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

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
        final HashMap<Integer, Integer> map = new HashMap<>(A.length);
        for (int val : A) {
            if (val < MINIMUM_VALUE || val > MAXIMUM_VALUE) {
                throw new RuntimeException("Unexpected value: " + val);
            }
            final Integer counter = map.get(val);
            if (counter == null) {
                map.put(val, 1);
            } else {
                map.put(val, counter + 1);
            }
        }
        for (Map.Entry<Integer, Integer> valAndCounter : map.entrySet()) {
            if (valAndCounter.getValue() % 2 == 1) {
                return valAndCounter.getKey();
            }
        }
        return 0;
    }

}
