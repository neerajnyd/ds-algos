package com.ny.leetcode.april2023;

import com.ny.leetcode.ArrayUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimizeMaxInArrayTest {

    MinimizeMaxInArray a = new MinimizeMaxInArray();

    @Test
    void minimizeArrayValue_case1() {
        int actual = a.minimizeArrayValue(ArrayUtil.read("[3,7,1,6]"));
        Assertions.assertEquals(5, actual);
    }

    @Test
    void minimizeArrayValue_case2() {
        int actual = a.minimizeArrayValue(ArrayUtil.read("[10,1]"));
        Assertions.assertEquals(10, actual);
    }

    @Test
    void minimizeArrayValue_case14() {
        int actual = a.minimizeArrayValue(ArrayUtil.read("[6,9,3,8,14]"));
        Assertions.assertEquals(8, actual);
    }

    @Test
    void minimizeArrayValue_case12() {
        int actual = a.minimizeArrayValue(ArrayUtil.read("[13,13,20,0,8,9,9]"));
        Assertions.assertEquals(16, actual);
    }


}