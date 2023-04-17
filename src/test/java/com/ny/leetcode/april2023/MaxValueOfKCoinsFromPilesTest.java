package com.ny.leetcode.april2023;

import com.ny.leetcode.ArrayUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxValueOfKCoinsFromPilesTest {

    private final MaxValueOfKCoinsFromPiles m = new MaxValueOfKCoinsFromPiles();

    @Test
    void maxValueOfCoins() {

        assertEquals(101, m.maxValueOfCoins(from(ArrayUtil.read2D("[[1,100,3],[7,8,9]]")), 2));
        assertEquals(706, m.maxValueOfCoins(from(ArrayUtil.read2D("[[100],[100],[100],[100],[100],[100],[1,1,1,1,1,1,700]]")), 7));
    }

    private static List<List<Integer>> from(int[][] input) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] ints : input) {
            List<Integer> inner = new ArrayList<>();
            for (int anInt : ints) {
                inner.add(anInt);
            }
            list.add(inner);
        }
        return list;
    }
}