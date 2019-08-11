package com.ny.leetcode;

public class PlusOne {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        final int[] ints = plusOne(nums);
        for (int n : ints) {
            System.out.print(n);
        }
    }

    private static int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        do {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
            i--;
        } while (i >= 0);
        if (digits[0] == 0) {
            int[] N2 = new int[digits.length+1];
            N2[0] = 1;
            for(int j=0; j<digits.length; j++) {
                int k = j+1;
                N2[k] = digits[j];
            }
            return N2;
        } else {
            return digits;
        }
    }

}
