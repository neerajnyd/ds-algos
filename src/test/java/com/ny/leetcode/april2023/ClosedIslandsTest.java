package com.ny.leetcode.april2023;

import com.ny.leetcode.ArrayUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClosedIslandsTest {

    private final ClosedIslands islands = new ClosedIslands();

    @Test
    void closedIsland_case1() {
        int actual = islands.closedIsland(ArrayUtil.read2D("[[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]"));
        Assertions.assertEquals(2, actual);
    }

    @Test
    void closedIsland_case2() {
        int actual = islands.closedIsland(ArrayUtil.read2D("[[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]"));
        Assertions.assertEquals(1, actual);
    }
}