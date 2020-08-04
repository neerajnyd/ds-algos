package com.ny.leetcode.june2020;

public class Day10_SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(
                new int[]{
                        1, 3, 5, 6
                },
                0
        ));
    }

    public static int searchInsert(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midValue = nums[mid];

            if (target < midValue) { //we look to the left of mid element
                hi = mid - 1;
            } else if (target > midValue) { //we look to the right of mid element
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

}
