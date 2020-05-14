package com.ny.leetcode.may2020;

/*
https://leetcode.com/problems/first-bad-version/
 */
public class Day01_FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        int lo = 1, hi = n;
        int ans = -1;
        while (hi >= lo) {
            int mid = lo + ((hi - lo) / 2);
            if (isBadVersion(mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;

    }

    private static boolean isBadVersion(int mid) {
        return mid==4;
    }
}
