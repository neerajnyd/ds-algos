package com.ny.leetcode;

public class ExcelColumnToNumber {

    public static void main(String[] args) {

        System.out.println(titleToNumber("AA"));

    }

    public static int titleToNumber(String s) {
        int total = 0;
        char[] C = s.toCharArray();
        for(char c : C) {
            total = total * 26 + c - 'A' + 1;
        }
        return total;
    }


}
