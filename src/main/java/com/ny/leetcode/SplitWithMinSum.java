package com.ny.leetcode;

import java.util.Arrays;

public class SplitWithMinSum {

    public static void main(String[] args) {

       /* System.out.println(splitNum(432500000)); //24   35
        System.out.println(splitNum(687)); //68   7*/

        System.out.println(coloredCells(69675));

    }

    public static int splitNum(int num) {

        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();

        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i < chars.length; i++) {

            one.append(Character.getNumericValue(chars[i++]));
            if (i < chars.length) {
                two.append(Character.getNumericValue(chars[i]));
            }
        }

        return Integer.parseInt(one.toString()) + Integer.parseInt(two.toString());
    }

    public static long coloredCells(int n) {

        //sum of first n odd numbers = n^2
        /*sequences here are

         */

        return (2L * n * n) - (2L * n) + 1 ; //2n^2 - 2n + 1



    }

}
