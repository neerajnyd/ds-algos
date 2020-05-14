package com.ny.leetcode.may2020;

public class Day04_NumberComplement {

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(0));
    }

    public static int bitwiseComplement(int num) {
        if(num == 0) return 1;
        boolean negative = num < 0;
        num = Math.abs(num);
        int result = 0;
        int[] A = new int[32];
        int i = 0;
        while(num != 0) {
            int lsd = num & 1;
            A[i++] = lsd;
            num >>>= 1;
        }

        for(int j=0; j<i; j++) {
            if(A[j] == 0)
                result += Math.pow(2, j);
        }

        return negative ? -result : result;
    }

}
