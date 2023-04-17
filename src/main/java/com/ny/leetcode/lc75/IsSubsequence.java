package com.ny.leetcode.lc75;

public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {


        //s -> ace
        //t -> ahbgdc

        if (s.length() == 0) return true;
        if (s.length() > t.length()) return false;

        int j = 0;
        for (int i = 0; i < t.length(); i++) {

            char a = s.charAt(j);
            char b = t.charAt(i);

            if (a == b &&
                    ++j == s.length()) { //we have matched and exhausted string s
                return true;
            }
        }
        return false;
    }
}
