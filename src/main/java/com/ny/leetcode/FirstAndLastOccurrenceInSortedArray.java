package com.ny.leetcode;

public class FirstAndLastOccurrenceInSortedArray {

    public static void main(String[] args) {

        int[] nums = {-14,-10,2,108,108,243,285,285,285,401};
        final int[] range = searchRange(nums, 285);
        System.out.print(range[0] + " " + range[1]);

    }

    public static int[] searchRange(int[] nums, int target) {

        int left = getLeftOrRight(nums, target, true);
        int right = getLeftOrRight(nums, target, false);
        return new int[]{left, right};

    }

    private static int getLeftOrRight(int[] nums, int target, boolean left) {
        int lo = 0, hi = nums.length - 1;
        int result = -1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;

            if (target > nums[mid]) lo = mid + 1;
            else if (target < nums[mid]) hi = mid - 1;
            else {
                result = mid;
                if(left) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return result;
    }
}