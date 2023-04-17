package com.ny.leetcode.march2023;

import com.ny.leetcode.ArrayUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinPathSumTest {


    private final MinPathSum minPathSum = new MinPathSum();

    @Test
    void minPathSumTest() {

        int[][] grid = ArrayUtil.read2D("[[1,3,1],[1,5,1],[4,2,1]]");
        int actual = minPathSum.minPathSum(grid);
        Assertions.assertEquals(7, actual);

        grid = ArrayUtil.read2D("[[1,2,3],[4,5,6]]");
        actual = minPathSum.minPathSum(grid);
        Assertions.assertEquals(12, actual);
    }
}