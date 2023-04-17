package com.ny.leetcode.march2023;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrambleStringTest {

    private ScrambleString scrambleString = new ScrambleString();

    @Test
    void isScramble_case1() {
        boolean actual = scrambleString.isScramble("great", "rgeat");
        Assertions.assertTrue(actual);
    }

    @Test
    void isScramble_case2() {
        boolean actual = scrambleString.isScramble("abcde", "caebd");
        Assertions.assertFalse(actual);
    }

    @Test
    void isScramble_case3() {
        boolean actual = scrambleString.isScramble("a", "a");
        Assertions.assertTrue(actual);
    }
}