package com.ny.leetcode;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";

        int result = lcs.lcsDynamic(str1.toCharArray(), str2.toCharArray());
        System.out.print(result);
    }

    private int lcs(char[] str1, char[] str2, int len1, int len2) {

        if (len1 == str1.length || len2 == str2.length) {
            return 0;
        }
        if (str1[len1] == str2[len2]) {
            return 1 + lcs(str1, str2, len1 + 1, len2 + 1);
        } else {
            return Math.max(lcs(str1, str2, len1 + 1, len2), lcs(str1, str2, len1, len2 + 1));
        }
    }

    private int lcsDynamic(char[] str1, char[] str2) {

        final int m = str1.length;
        final int n = str2.length;

        int[][] M = new int[m + 1][n + 1];
        int max = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                final char c1 = str1[i - 1];
                final char c2 = str2[j - 1];
                if (c1 == c2) {
                    M[i][j] = M[i - 1][j - 1] + 1;
                } else {
                    M[i][j] = Math.max(M[i][j - 1], M[i - 1][j]);
                }

                if (M[i][j] > max) {
                    max = M[i][j];
                }

            }
        }
        return max;

    }


}