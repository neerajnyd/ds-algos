package com.ny.leetcode.curated.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {

        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        int[][] result = insert(intervals, newInterval);
        for (int[] r : result)  {
            System.out.print(Arrays.toString(r) + ", ");
        }
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        int i = 0;
        //add all intervals before the overlap
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        //merge all overlapping intervals into new interval, add that new interval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i++][1], newInterval[1]);
        }
        result.add(newInterval);
        //add all intervals after the overlap
        while (i < intervals.length) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[0][0]);
    }

}
