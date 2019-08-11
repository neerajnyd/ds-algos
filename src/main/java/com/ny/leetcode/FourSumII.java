package com.ny.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

    public static void main(String[] args) {

    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        final Map<Integer, Integer> freqs = new HashMap<>();
        for (int x : A) {
            for (int y : B) {
                int sum = x + y;
                freqs.put(sum, freqs.getOrDefault(sum, 0) + 1);
            }
        }
        int result = 0;
        for (int x : C) {
            for (int y : D) {
                int sum = -1 * (x + y);
                result += freqs.getOrDefault(sum, 0);
            }
        }
        return result;
    }


}
