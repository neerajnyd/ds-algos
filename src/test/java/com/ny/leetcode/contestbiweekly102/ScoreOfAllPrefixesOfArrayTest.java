package com.ny.leetcode.contestbiweekly102;

import com.ny.leetcode.ArrayUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreOfAllPrefixesOfArrayTest {

    private final ScoreOfAllPrefixesOfArray a = new ScoreOfAllPrefixesOfArray();

    @Test
    void findPrefixScore() {

        long[] actual = a.findPrefixScore(ArrayUtil.read("[2,3,7,5,10]"));
        long[] expected = {4, 10, 24, 36, 56};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void findPrefixScore_case2() {

        long[] actual = a.findPrefixScore(ArrayUtil.read("[1,1,2,4,8,16]"));
        long[] expected = {2, 4, 8, 16, 32, 64};
        Assertions.assertArrayEquals(expected, actual);

    }
}