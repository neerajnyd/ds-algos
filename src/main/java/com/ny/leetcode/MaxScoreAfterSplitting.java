package com.ny.leetcode;

public class MaxScoreAfterSplitting {
    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
        System.out.println(maxScore("00111"));
        System.out.println(maxScore("1111"));
        System.out.println(maxScore("00"));
    }
    public static int maxScore(String str) {
        int n = str.length();
        int t = 0;
        for(int s=1; s<=n-1; s++) {
            int s1 = 0, s2 = 0;
            for(int i=0; i<s; i++) {
                if(str.charAt(i)=='0') {
                    s1++;
                }
            }
            for(int i=s; i<n; i++) {
                if(str.charAt(i)=='1') {
                    s2++;
                }
            }
            t = Math.max(t, s1+s2);
        }
        return t;
    }
}
