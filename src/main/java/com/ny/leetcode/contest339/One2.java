package com.ny.leetcode.contest339;

import com.ny.leetcode.ArrayUtil;

public class One2 {

    public static void main(String[] args) {
        One2 o = new One2();
        int[] arr = ArrayUtil.read("[]");
        int[][] arr2 = ArrayUtil.read2D("[]");

        System.out.println(o.findTheLongestBalancedSubstring("01000111")); //6
        System.out.println(o.findTheLongestBalancedSubstring("0011")); //4
        System.out.println(o.findTheLongestBalancedSubstring("111")); //0
        System.out.println(o.findTheLongestBalancedSubstring("0010")); //2
    }

    public int findTheLongestBalancedSubstring(String s) {

        int max = 0, c0 = 0, c1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                c0 = c1 != 0 ? 1 : c0 + 1;
                if (c1 != 0) {
                    c1 = 0;
                }
            } else if (c0 != 0) {
                c1++;
                max = Math.max(Math.min(c1, c0) * 2, max);
            }
        }
        return max;
    }

    public int findTheLongestBalancedSubstring2(String s) {
        int c0 = 0, c1 = 0, res = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                c0 = c1 != 0 ? 1 : c0 + 1;
                c1 = 0;
            } else {
                c1++;
            }
            res = Math.max(res, 2 * Math.min(c0, c1));
        }
        return res;
    }


}
