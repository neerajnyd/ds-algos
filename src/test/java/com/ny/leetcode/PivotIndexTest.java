package com.ny.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class PivotIndexTest {

    private PivotIndex pivotIndex = new PivotIndex();

    @Test
    public void testCase1() {
        int[] nums = {1,2,3};
        final int result = pivotIndex.pivotElementIndex2(nums);

        Assert.assertEquals("", -1, result);
    }

    @Test
    public void testCase2() {
        int[] nums = {1, 7, 3, 6, 5, 6};
        final int result = pivotIndex.pivotElementIndex2(nums);

        Assert.assertEquals("", 3, result);
    }

    @Test
    public void negativeNumsTest() {
        int[] nums = {-1,-1,-1,-1,-1,0};
        final int result = pivotIndex.pivotElementIndex2(nums);

        Assert.assertEquals("", 2, result);
    }

    @Test
    public void negativeNumsTwoTest2() {
        int[] nums = {-1,-1,-1,0,1,1};
        final int result = pivotIndex.pivotElementIndex2(nums);

        Assert.assertEquals("", 0, result);
    }

}
