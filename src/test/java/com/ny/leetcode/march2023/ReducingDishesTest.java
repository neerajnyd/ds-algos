package com.ny.leetcode.march2023;

import com.ny.leetcode.ArrayUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReducingDishesTest {

    private ReducingDishes dishes;

    @BeforeEach
    void setUp() {
        dishes = new ReducingDishes();
    }

    @Test
    void maxSatisfaction_case1() {
        int actual = dishes.maxSatisfaction(ArrayUtil.read("[-1,-8,0,5,-9]"));
        Assertions.assertEquals(14, actual);
    }

    @Test
    void maxSatisfaction_case2() {
        int actual = dishes.maxSatisfaction(ArrayUtil.read("[4,3,2]"));
        Assertions.assertEquals(20, actual);
    }@Test
    void maxSatisfaction_case3() {
        int actual = dishes.maxSatisfaction(ArrayUtil.read("[-1,-4,-5]"));
        Assertions.assertEquals(0, actual);
    }
}