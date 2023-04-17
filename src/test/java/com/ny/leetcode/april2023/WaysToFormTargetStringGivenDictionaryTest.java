package com.ny.leetcode.april2023;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WaysToFormTargetStringGivenDictionaryTest {

    private final WaysToFormTargetStringGivenDictionary d = new WaysToFormTargetStringGivenDictionary();

    @Test
    void numWays_case1() {
        int actual = d.numWays(new String[]{"acca", "bbbb", "caca"}, "abc");
        Assertions.assertEquals(6, actual);
    }

    @Test
    void numWays_case2() {
        int actual = d.numWays(new String[]{"abba", "baab"}, "bab");
        Assertions.assertEquals(4, actual);
    }
}