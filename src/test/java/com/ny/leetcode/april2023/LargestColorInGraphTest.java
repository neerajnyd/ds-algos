package com.ny.leetcode.april2023;

import com.ny.leetcode.ArrayUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestColorInGraphTest {

    private final LargestColorInGraph g = new LargestColorInGraph();

    @Test
    void largestPathValue_case1() {
        int actual = g.largestPathValue("abaca", ArrayUtil.read2D("[[0,1],[0,2],[2,3],[3,4]]"));
        Assertions.assertEquals(3, actual);
    }

    @Test
    void largestPathValue_case2() {
        int actual = g.largestPathValue("a", ArrayUtil.read2D("[[0,0]]"));
        Assertions.assertEquals(-1, actual);
    }
}