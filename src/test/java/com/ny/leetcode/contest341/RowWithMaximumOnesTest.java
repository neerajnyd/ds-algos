package com.ny.leetcode.contest341;

import com.ny.leetcode.ArrayUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowWithMaximumOnesTest {

    private final RowWithMaximumOnes o = new RowWithMaximumOnes();

    @Test
    void rowAndMaximumOnes() {

        int[] actual = o.rowAndMaximumOnes(ArrayUtil.read2D("[[0,1],[1,0]]"));
        Assertions.assertArrayEquals(ArrayUtil.read("[0,1]"), actual);

        int[] actual2 = o.rowAndMaximumOnes(ArrayUtil.read2D("[[0,0,0],[0,1,1]]"));
        Assertions.assertArrayEquals(ArrayUtil.read("[1,2]"), actual2);

        int[] actual3 = o.rowAndMaximumOnes(ArrayUtil.read2D("[[0,0],[1,1],[0,0]]"));
        Assertions.assertArrayEquals(ArrayUtil.read("[1,2]"), actual3);
    }
}