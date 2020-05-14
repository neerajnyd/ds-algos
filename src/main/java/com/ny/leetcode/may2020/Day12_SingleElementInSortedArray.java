package com.ny.leetcode.may2020;

/*
https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class Day12_SingleElementInSortedArray {

    public int singleNonDuplicate(int[] N) {
        int n = N.length;
        if (n == 1) return N[0];
        int lo = 0, hi = n - 1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;
            int midValue = N[mid];

            if (mid > 0 && midValue == N[mid - 1]) { //meet left
                if ((mid + 1) % 2 == 0) {//if elements on the left are even
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            } else if (mid < N.length - 1 && midValue == N[mid + 1]) { //meet right
                if ((n - mid) % 2 == 0) {//if elements on the right are even
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
            } else {
                return midValue;
            }
        }
        return -1;
    }

}
