package com.ny.leetcode.contest333;

import java.util.HashMap;
import java.util.Map;

public class MinOpsReduceIntToZero {

    Map<Integer, Integer> numToCount = new HashMap<>();

    {
        for (int i = 0; i < 18; i++) {
            int number = (int) Math.pow(2, i);
            numToCount.put(number, 1);
        }
    }

    public static void main(String[] args) {
//        int num = 39;
        int num = 38;

        MinOpsReduceIntToZero zero = new MinOpsReduceIntToZero();


        System.out.println(zero.minOperations(num));
    }

    public int minOperations(int n) {
        int[] r = getMinMax(n);
        int diff1 = n - (int)Math.pow(2, r[0]);
        int diff2 = (int)Math.pow(2, r[1]) - n;
        int op1 = minOperations(diff1, 0);
        int op2 = minOperations(diff2, 0);
        return Math.min(op1, op2);
    }
    
    private int minOperations(int n, int count) {
        if (numToCount.containsKey(n)) {
            int result = count + numToCount.get(n);
            numToCount.put(n, result);
            return result;
        }
        int[] r = getMinMax(n);
        int diff1 = n - (int)Math.pow(2, r[0]);
        int diff2 = (int)Math.pow(2, r[1]) - n;
        int op1 = minOperations(diff1, count + 1);
        int op2 = minOperations(diff2, count + 1);
        return Math.min(op1, op2);

    }

    private int[] getMinMax(int n) {
        int min, max;
        for (int i = 0; i < 18; i++) {
            int number = (int) Math.pow(2, i);
            if(number > n) {
                max = i;
                min = i - 1;
                return new int[]{min, max};
            }
        }
        return new int[2];
    }

}
