package com.ny.leetcode.contestbiweekly101;

public class MaxDiffByRemappingDigit {

    public static void main(String[] args) {

        int num = 11891;
        System.out.println(minMaxDifference(num));

    }

    public static int minMaxDifference(int num) {

        int max = getMaxNumber(num);
        System.out.println(max);
        int min = getMinNumber(num);
        System.out.println(min);
        return max - min;
    }

    private static int getMinNumber(int num) {

        String s = String.valueOf(num);
        for (char c : s.toCharArray()) {

            int digit = Character.getNumericValue(c);
            if (digit > 0) {
                String minIntStr = s.replace(String.valueOf(digit), "0");
                return Integer.parseInt(minIntStr);
            }

        }
        return num;

    }

    private static int getMaxNumber(int num) {

        String s = String.valueOf(num);
        for (char c : s.toCharArray()) {

            int digit = Character.getNumericValue(c);
            if (digit < 9) {
                String maxIntStr = s.replace(String.valueOf(digit), "9");
                return Integer.parseInt(maxIntStr);
            }

        }
        return num;

    }

}
