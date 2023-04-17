package com.ny.leetcode.april2023;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestPalindromicSubsequenceTest {

    private final LongestPalindromicSubsequence s = new LongestPalindromicSubsequence();

    @Test
    void longestPalindromeSubseq_case1() {
        int actual = s.longestPalindromeSubseq_Recursive("bbbab");
        Assertions.assertEquals(4, actual);
    }

    @Test
    void longestPalindromeSubseq_case2() {
        int actual = s.longestPalindromeSubseq_Iterative("cbbd");
        Assertions.assertEquals(2, actual);
    }
}