package com.ny.leetcode;

public class PerformStringShifts {

    public static void main(String[] args) {
        String s = "mecsk";

        int[][] shift = {{1,4},{0,5},{0,4},{1,1},{1,5}};
        System.out.println(s);
        String ss = stringShift(s, shift);
        System.out.println(ss);
    }

    public static String stringShift(String s, int[][] shift) {
        int left = 0;
        int right = 0;
        boolean shiftLeft;
        for(int[] sh : shift) {
            final int dir = sh[0];
            final int amount = sh[1];
            if(dir == 0) {
                left += amount;
            } else {
                right += amount;
            }
        }
        if(left == right) return s;
        int shiftBy;
        if(left > right) {
            shiftBy = left - right;
            shiftLeft = true;
        } else {
            shiftBy = right - left;
             shiftLeft = false;
        }
        return stringShift(s, shiftBy, shiftLeft);

    }

    private static String stringShift(String s, int shiftBy, boolean shiftLeft) {
        shiftBy = shiftBy % s.length();
        String one;
        String two;
        if(shiftLeft) {
            one = s.substring(shiftBy);
            two = s.substring(0, shiftBy);
        } else {
            one = s.substring(s.length() - shiftBy);
            two = s.substring(0, s.length()-shiftBy);
        }
        return one + two;
    }

}
