package com.ny.leetcode.contest337;

import java.util.Arrays;

public class OddAndEvenBits {

    public static void main(String[] args) {
        OddAndEvenBits b = new OddAndEvenBits();
//        System.out.println(Arrays.toString(b.evenOddBit(17)));
        System.out.println(Arrays.toString(b.evenOddBit(2)));
    }

    public int[] evenOddBit(int num) {

        String s = Integer.toBinaryString(num);

        char[] chars = s.toCharArray();
        int n = chars.length;
        int even = 0, odd = 0;

        int j = 0;
        for (int i = n-1; i >= 0; i--,j++) {
            int c = chars[i];
            if (c == '1') {
                if (j % 2 == 0) even++;
                else odd++;
            }
        }
        return new int[]{even, odd};

    }

}
