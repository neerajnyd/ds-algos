package com.ny.leetcode;

import java.util.Objects;

public class PivotIndex {

    int pivotElementIndex(int[] nums) {
        if(Objects.isNull(nums) || nums.length==0) {
            return -1;
        }
        if(nums.length==1) {
            return 0;
        }
        int left = 0, right = nums.length-1;
        int leftSum = 0, rightSum = 0;
        int total = 0;
        while(left != right) {
            final int leftNum = nums[left];
            final int rightNum = nums[right];
            total = total + leftNum + rightNum;
            if(total >=0) {
                if (leftSum >= rightSum) {
                    rightSum += rightNum;
                    right -= 1;
                } else { //if(rightSum > leftSum) {
                    leftSum += leftNum;
                    left += 1;
                }
            } else {
                if (leftSum <= rightSum) {
                    rightSum += rightNum;
                    right -= 1;
                } else { //if(rightSum > leftSum) {
                    leftSum += leftNum;
                    left += 1;
                }
            }
        }
        if(leftSum == rightSum) {
            return left; //or right
        } else {
            return -1;
        }
    }


    /*
    Pivot index is the index at which the left and the right subarray have the same sum
     */
    int pivotElementIndex2(int[] nums) {
        if(nums.length==0) {
            return -1;
        }
        int rightSum = 0;
        for (int n : nums) {
            rightSum += n;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i]; //decrement rightSum with each encountered number in the array
            if(leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

}
