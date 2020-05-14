package com.ny.leetcode.may2020;

public class Day05_FirstUniqueCharInString {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("z"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        if(s == null || s.isEmpty()) return -1;
        if(s.length() == 1) return 0;

        int[] A = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            A[index]++;
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if(A[index] == 1) return i;
        }
        return -1;

    }
}
