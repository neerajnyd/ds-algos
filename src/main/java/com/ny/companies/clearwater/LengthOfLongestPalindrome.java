package com.ny.companies.clearwater;

public class LengthOfLongestPalindrome {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestPalindrome("ABCDEEAB"));
    }

    //TODO:
    private static int lengthOfLongestPalindrome(String str) {
        int n = str.length();

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1; //when n is 1, it is palindrome
        }
        char[] s = str.toCharArray();
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (s[i] == s[j] && k == 2) {
                    dp[i][j] = 2;
                } else if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }


}
