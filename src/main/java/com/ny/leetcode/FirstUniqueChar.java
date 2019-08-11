package com.ny.leetcode;

public class FirstUniqueChar {

    public static void main(String[] args) {
        String s = "loveleetcode";

        System.out.println(firstUniqueCharIndex(s));

    }

    private static int firstUniqueCharIndex(String s) {
        int[] A = new int[26];
        char[] charArray = s.toCharArray();
        for (char c : charArray) A[c - 'a']++;
        for (int i = 0; i < s.length(); i++) if(A[s.charAt(i) - 'a']==1) return i;
        return -1;
    }

    private static int firstUnique1CharIndex(String s) {
        int[] a = new int[27];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = c - 'a' + 1;
            if(a[index] != 0) {
                a[index] = 0;
            } else {
                a[index] = i+1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int x : a) {
            if(x == 0) continue;
            min = Math.min(x, min);
        }
        return min-1;
    }

}
