package com.ny.leetcode.contest338;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KItemsWithMaxSumTest {

    private KItemsWithMaxSum sum = new KItemsWithMaxSum();

    @Test
    void kItemsWithMaximumSum() {

        int result = sum.kItemsWithMaximumSum(2, 0, 1, 3);
        Assertions.assertEquals(1, result);



    }
}