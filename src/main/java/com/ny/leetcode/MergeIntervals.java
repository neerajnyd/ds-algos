package com.ny.leetcode;

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        final int[][] mergedIntervals = merge(intervals);

        for(int[] interval : mergedIntervals) {
            System.out.println(interval[0] + " " + interval[1]);
        }

    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        final List<int[]> result = new ArrayList<>();

        int[] newInterval  = intervals[0];
        result.add(newInterval);
        for(int[] interval : intervals) {
            if(interval[0] <= newInterval [1]) { //overlapping interval
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval  = interval;
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}
