package com.ny.leetcode;

import java.math.BigInteger;
import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = {{1,5}};

        System.out.println(countWays(intervals));
        /*
        final int[][] mergedIntervals = merge(intervals);

        for (int[] interval : mergedIntervals) {
            System.out.println(interval[0] + " " + interval[1]);
        }*/

    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        final List<int[]> result = new ArrayList<>();

        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) { //overlapping interval
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static int countWays(int[][] ranges) {

        int[][] merged = merge(ranges);

        BigInteger m = BigInteger.valueOf(2);
        BigInteger pow = m.modPow(BigInteger.valueOf(merged.length), BigInteger.valueOf(1000000007));
        return pow.intValue();

    }

}
