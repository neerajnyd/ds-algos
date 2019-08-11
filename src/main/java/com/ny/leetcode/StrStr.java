package com.ny.leetcode;

public class StrStr {

    public static void main(String[] args) {

        String S = "mississippi";
        String s = "issip";
        System.out.println(strStr(S, s));

    }

    private static int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if(j == needle.length()) return i;
                if(i+j == haystack.length()) return -1;
                if(haystack.charAt(i+j) != needle.charAt(j)) break;
            }
        }
    }


    private static int strStr2(String S, String s) {
        if(s.length()==0) return 0;
        int i=0;
        while (i < S.length()) {
            int ans = i;
            int j = 0;
            boolean match = true;
            while (j < s.length() && i < S.length()) {
                char C = S.charAt(i++);
                char c = s.charAt(j++);
                if(C!=c) {
                    match = false;
                    break;
                }
            }
            if(match && j==s.length()) return ans;
            i = ans+1;
        }
        return -1;
    }
}
