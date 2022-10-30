package com.ny.leetcode.curated.array;

public class SearchRotatedSortedArray {

    public static void main(String[] args) {

        int[] nums = {10, 12, 14, 16, 18, 20, 22, 24, 26, 27, 30, 2, 4, 5, 8};
        int target = 14;
        final int search = search(nums, target);
        System.out.println(search);
    }

    public static int search(int[] A, int target) {

        int n = A.length;

        //the min position is also the number of rotations
        int ro = getMinPosition(A);
        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            int realMid = (mid + ro) % n;
            //usual binary search
            if (A[realMid] < target) {
                lo = mid + 1;
            } else if (A[realMid] > target) {
                hi = mid - 1;
            } else {
                return realMid;
            }
        }
        return -1;
    }

    private static int getMinPosition(int[] A) {
        int lo = 0, hi = A.length - 1;

        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;

            if (A[mid] > A[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static int search2(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            int num = (nums[mid] < nums[0]) == (target < nums[0])
                    ? nums[mid]
                    : target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            if (num < target) {
                lo = mid + 1;
            } else if (num > target) {
                hi = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
