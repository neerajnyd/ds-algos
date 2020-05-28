package com.ny.leetcode.may2020;

public class Day18_PermutationOfS1InS2 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }

    private static boolean checkInclusion(String s1, String s2) {
        int[] A = new int[26];
        for (char c : s1.toCharArray())
            A[c - 'a'] += 1;

        int left = 0;
        int[] B = new int[26];
        for (int right = 0; right < s2.length(); right++) {
            char newChar = s2.charAt(right);
            B[newChar - 'a'] += 1;
            if (right - left == s1.length() - 1) {
                if (arraysMatch(A, B)) {
                    return true;
                } else {
                    char oldChar = s2.charAt(left);
                    B[oldChar - 'a'] -= 1;
                    left++;
                }
            }
        }
        return false;
    }

    private static boolean arraysMatch(int[] A, int[] B) {
        for (int i = 0; i < A.length; i++)
            if (A[i] != B[i])
                return false;
        return true;
    }

}
