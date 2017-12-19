package com.ny.leetcode;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        System.out.println(longestPalindrome("bbaaaabb"));

    }

    public static String bruteLongestPalindrome(String s) {

        if(s.length() < 2){
            return s;
        }

        int max = 0;
        String palin = null;
        for(int i=0; i<s.length()-1; i++){
            for(int j=i; j<=s.length(); j++){
                int length = 0;
                String sub = s.substring(i, j);
                String rev = new StringBuilder(sub).reverse().toString();
                if(sub.equals(rev)){
                    length = sub.length();
                }
                if(length > max){
                    max = length;
                    palin = sub;
                }

            }
        }


        return palin;
    }

    /**
     * https://leetcode.com/problems/longest-palindromic-substring/solution/
     *
     *
     */
    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
