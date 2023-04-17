package com.ny.leetcode.april2023;

import com.ny.leetcode.ArrayUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SpellsAndPotionsTest {

    private final SpellsAndPotions o = new SpellsAndPotions();

    @Test
    void successfulPairs_case1() {
        int[] actual = o.successfulPairs(ArrayUtil.read("[5,1,3]"), ArrayUtil.read("[1,2,3,4,5]"), 7);
        Assertions.assertEquals(Arrays.toString(actual), Arrays.toString(ArrayUtil.read("[4,0,3]")));
    }

    @Test
    void successfulPairs_case2() {
        int[] actual = o.successfulPairs(ArrayUtil.read("[3,1,2]"), ArrayUtil.read("[8,5,8]"), 16);
        Assertions.assertEquals(Arrays.toString(actual), Arrays.toString(ArrayUtil.read("[2, 0, 2]")));
    }
}