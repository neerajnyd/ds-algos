package com.ny.leetcode;

public class TwiceAsBig {

    public static void main(String[] args) {
        int[] nums = {0,0,3,2};
        System.out.println(dominantIndex(nums));
    }

    private static int dominantIndex(int[] nums) {
        /*if(nums.length < 2) {
            return -1;
        }*/
        int largest = -1, large = -1;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                large = largest;
                largest = nums[i];
                index = i;
            } else if(nums[i] > large) {
                large = nums[i];
            }
        }
        if(largest >= large*2) {
            return index;
        } else {
            return -1;
        }
    }

}
