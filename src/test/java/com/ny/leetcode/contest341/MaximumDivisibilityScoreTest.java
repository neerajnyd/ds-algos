package com.ny.leetcode.contest341;

import com.ny.leetcode.ArrayUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumDivisibilityScoreTest {

    @Test
    void maxDivScore() {

        int actual = new MaximumDivisibilityScore().maxDivScore(ArrayUtil.read("[4,7,9,3,9]"), ArrayUtil.read("[5,2,3]"));
        assertEquals(3, actual);
    }

    @Test
    void maxDivScore_case2() {

        int actual = new MaximumDivisibilityScore().maxDivScore(ArrayUtil.read("[20,14,21,10]"), ArrayUtil.read("[5,7,5]"));
        assertEquals(5, actual);
    }

    @Test
    void maxDivScore_case3() {

        int actual = new MaximumDivisibilityScore().maxDivScore(ArrayUtil.read("[12]"), ArrayUtil.read("[10,16]"));
        assertEquals(10, actual);
    }

    @Test
    void maxDivScore_case4() {

        int actual = new MaximumDivisibilityScore().maxDivScore(
                ArrayUtil.read("[69,3,92,14,67,90,31,40,54,63,99,88,28,100,5,72,89,60,90,71]"),
                ArrayUtil.read("[97,16,7,60,6,57,73,84,17,8,77,60,7,74,74,24,52,43,94,48,9,99]"));
        assertEquals(9, actual);
    }

    @Test
    void maxDivScore_case5() {

        int actual = new MaximumDivisibilityScore().maxDivScore(
                ArrayUtil.read("[73,13,20,6]"),
                ArrayUtil.read("[56,75,83,26,24,53,56,61]"));
        assertEquals(24, actual);
    }
}