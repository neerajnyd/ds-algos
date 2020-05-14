package com.ny.leetcode.curatedlistchallenge.day4;

import java.util.Arrays;

/*
https://leetcode.com/problems/non-overlapping-intervals/
 */
public class NonOverlappingIntervals {

    public static void main(String[] args) {
        System.out.println(
                eraseOverlapIntervals(
                        new int[][] {{1,2},{2,3},{3,4},{1,3}}
                )
        );
    }

    public static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (i1, i2) -> {
            int c = Integer.compare(i1[0], i2[0]);
            if (c != 0) return c;
            else return Integer.compare(i1[1], i2[1]);
        });
        //[[1,2],[1,3],[2,3],[3,4]]
        //[[1,5],[2,3],[3,4],[4,5]]
        //so if two intervals overlap, we remove the one with the bigger interval?
        //1,5
        //2,3
        int count = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] a = intervals[i];
            int[] b = intervals[i + 1];

            if (b[0] < a[1]) { //overlap
                count++;
                if (b[1] > a[1]) {
                    intervals[i + 1] = intervals[i];
                }
            }
        }

        return count;
    }

}
