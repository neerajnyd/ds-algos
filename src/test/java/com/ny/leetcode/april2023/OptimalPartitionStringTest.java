package com.ny.leetcode.april2023;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptimalPartitionStringTest {

    private final OptimalPartitionString s = new OptimalPartitionString();

    @Test
    void partitionString_case1() {
        int actual = s.partitionString("abacaba");
        Assertions.assertEquals(4, actual);
    }

    @Test
    void partitionString_case2() {
        int actual = s.partitionString("ssssss");
        Assertions.assertEquals(6, actual);
    }


}