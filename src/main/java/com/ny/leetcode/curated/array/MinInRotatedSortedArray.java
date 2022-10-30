package com.ny.leetcode.curated.array;

public class MinInRotatedSortedArray {

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 1, 2};

        System.out.println(
                findMin(nums)
        );

    }

    private static int findMin(int[] A) {

        int lo = 0, hi = A.length - 1;

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;

            if (A[mid] > A[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return A[lo];
    }

    private static int findMin2(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        int lo = 0, hi = A.length - 1;
        if (A[lo] < A[hi]) {
            return A[0];
        }

        while (hi >= lo) {

            int mid = lo + (hi - lo) / 2;

            if (A[mid] > A[mid + 1]) {
                return A[mid + 1];
            }

            if (A[mid - 1] > A[mid]) {
                return A[mid];
            }

            if (A[mid] > A[0]) //the usual case where A[mid] is greater than A[0] so we keep looking right for the abnormality
            {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

        }

        return Integer.MAX_VALUE;
    }

}
