package com.ny.leetcode.curatedlistchallenge.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length < 2) return intervals;

        // [[1,3],[2,6],[8,10],[15,18]]
        //is this guaranteed to be sorted? question doesn't say so,
        //so let's sort ourselves first

        Arrays.sort(intervals, (i1, i2) -> {
            int val = Integer.compare(i1[0], i2[0]);
            if(val == 0) return Integer.compare(i1[1], i2[1]);
            else return val;
        });

        List<int[]> R = new ArrayList<>();

        //[[1,3],[2,6],[8,10],[15,18]]

        int[] a = intervals[0];

        for(int i=1; i<intervals.length;i++) {

            int[] b = intervals[i];
            if(a[1] >= b[0]) {//they overlap?
                a[1] = Math.max(a[1], b[1]); //a is updated to consume b
            } else { //they dont overlap
                R.add(new int[]{a[0], a[1]}); //a is added to result
                a = b; //a is updated to b
            }
            if(i == intervals.length-1)
                R.add(new int[]{a[0], a[1]});
        }

        int[][] result = new int[R.size()][2];
        for(int i=0; i<R.size(); i++) {
            result[i] = R.get(i);
        }
        return result;
    }

}
