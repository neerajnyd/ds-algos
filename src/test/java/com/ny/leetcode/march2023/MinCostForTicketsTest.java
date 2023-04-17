package com.ny.leetcode.march2023;

import com.ny.leetcode.ArrayUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinCostForTicketsTest {

    MinCostForTickets cost = new MinCostForTickets();

    @Test
    void minCostTicketsTest() {

        int[] days = ArrayUtil.read("[1,4,6,7,8,20]");
        int[] costs = ArrayUtil.read("[2,7,15]");
        int actual = cost.mincostTickets(days, costs);
        Assertions.assertEquals(11, actual);

    }
}