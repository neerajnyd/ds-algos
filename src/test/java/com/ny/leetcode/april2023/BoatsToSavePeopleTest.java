package com.ny.leetcode.april2023;

import com.ny.leetcode.ArrayUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoatsToSavePeopleTest {

    private final BoatsToSavePeople b = new BoatsToSavePeople();

    @Test
    void numRescueBoats_case1() {
        int actual = b.numRescueBoats(ArrayUtil.read("[1,2]"), 3);
        Assertions.assertEquals(1, actual);
    }

    @Test
    void numRescueBoats_case2() {
        int actual = b.numRescueBoats(ArrayUtil.read("[3,2,2,1]"), 3);
        Assertions.assertEquals(3, actual);
    }

    @Test
    void numRescueBoats_case3() {
        int actual = b.numRescueBoats(ArrayUtil.read("[3,5,3,4]"), 5);
        Assertions.assertEquals(4, actual);
    }


}