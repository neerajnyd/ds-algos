package com.ny.leetcode;

public class BitwiseAndOfNumbersRange {

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int x = 0;
        while(m != n){
            m >>= 1;
            n >>= 1;
            x++;
        }
        return m << x;
    }
}
