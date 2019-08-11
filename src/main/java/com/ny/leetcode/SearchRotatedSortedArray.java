package com.ny.leetcode;

public class SearchRotatedSortedArray {

    public static void main(String[] args) {

        int[] nums = {10, 12, 14, 16, 18, 20, 22, 24, 26, 27, 30, 2, 4, 5, 8};
        int target = 14;
        final int search = search2(nums, target);
        System.out.println(search);
    }

    public static int search2(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            int num = (nums[mid] < nums[0]) == (target < nums[0])
                    ? nums[mid]
                    : target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            if (num < target)
                lo = mid + 1;
            else if (num > target)
                hi = mid;
            else
                return mid;
        }
        return -1;
    }

    public static int search(int[] nums, int target) {

        int n = nums.length;
        if (n == 0) return -1;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        //left now contains the smallest element
        //left == right is the number of rotations
        int ro = left;
        left = 0;
        right = n - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int realMid = (mid + ro) % n;
            if (nums[realMid] < target) left = mid + 1;
            else if (nums[realMid] > target) right = mid - 1;
            else return realMid;
        }
        return -1;
    }

}
