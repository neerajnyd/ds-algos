package com.ny.dynamicprogramming;

import com.ny.util.Util;

/*
Find length of longest substring of a given string of digits,
such that sum of digigts in the first and second halves of the substring is same.

Example 1: Input: "142124"
           Output: 6
       Explanation: Whole string is the answer as 1+4+2 = 1+2+4

Example 2: Input: "9430723"
           Output: 4
       Explanation: "4307" has 4+3 = 0+7
 */
public class LongestSubstringWithEqualSumHalves {


    public static void main(String[] args) {
        System.out.println(bruteForce("142124"));
        System.out.println(dynamic("142124"));
        System.out.println(bruteForce("9430723"));
        System.out.println(dynamic("9430723"));
    }

    private static int dynamic(String s) {
        int n = s.length();
        int maxLen = 0;
        int[][] sum = new int[n][n];
        for (int i = 0; i < n; i++) {
            sum[i][i] = s.charAt(i) - '0';
        }
        Util.print2DArray(sum);
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                int k = len / 2;
                sum[i][j] = sum[i][j - k] + sum[j - k + 1][j];
                Util.print2DArray(sum);
                if (len % 2 == 0 && sum[i][j - k] == sum[j - k + 1][j] && len > maxLen) {
                    maxLen = len;
                    break;
                }
            }
        }

        return maxLen;
    }

    private static int bruteForce(String s) {
        int n = s.length();
        int max = 0;

        //we consider each substring
        for (int i = 0; i < n; i++) {
            //j denotes the end of each substring
            for (int j = i + 1; j < n; j += 2) {

                int len = j - i + 1; //length of the substring under consideration

                if (max >= len) continue; //this substring is not worth considering

                int leftSum = 0, rightSum = 0;
                int halfLength = len / 2;
                for (int k = 0; k < halfLength; k++) {
                    leftSum += Character.getNumericValue(s.charAt(i + k));
                    rightSum += Character.getNumericValue(s.charAt(i + k + halfLength));
                }
                if (leftSum == rightSum) max = len;
            }
        }
        return max;
    }

}
