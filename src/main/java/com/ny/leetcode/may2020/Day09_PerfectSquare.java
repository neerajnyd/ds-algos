package com.ny.leetcode.may2020;

public class Day09_PerfectSquare {

    public static void main(String[] args) {
        System.out.println(Math.sqrt(808201));
        System.out.println(isPerfectSquare(808201));
    }

    public static boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        int lo = 1;
        int hi = num/2;

        while(lo <= hi) {
            long mid = lo + (hi-lo)/2;
            long sq = mid * mid;
            if(sq == num) return true;
            else if(sq > num) hi = (int)mid-1;
            else lo = (int)mid + 1;
        }
        return false;
    }

}
