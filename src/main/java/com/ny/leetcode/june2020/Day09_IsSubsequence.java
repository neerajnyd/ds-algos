package com.ny.leetcode.june2020;

public class Day09_IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }

    public static boolean isSubsequence(String S, String T) {

        int i=0, j=0;

        while (i<S.length() && j<T.length()) {

            char s = S.charAt(i);
            char t = T.charAt(j);

            if(s == t){
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i == S.length();

    }

}
