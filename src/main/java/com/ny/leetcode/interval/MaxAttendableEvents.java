package com.ny.leetcode.interval;
/*
https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
 */

import java.util.Arrays;

public class MaxAttendableEvents {

    public static void main(String[] args) {
        System.out.println(
                maxEvents(
                        new int[][]
                                {{1,2},{1,2},{3,3},{1,5},{1,5}}
                )
        );
    }

    public static int maxEvents(int[][] events) {

        Arrays.sort(events, (e1, e2) -> {
            int x = Integer.compare(e1[1], e2[1]);
            if (x != 0) return x;
            else return Integer.compare(e1[0], e2[0]);
        });
        int lastDay = events[events.length - 1][1];
        if(lastDay == events.length && lastDay > 99999)
            return lastDay;
        boolean[] days = new boolean[lastDay + 1];
        int d = 0;
        for (int[] event : events) {

            int start = event[0];
            int end = event[1];

            while (start <= end) {
                if (!days[start]) {
                    days[start] = true;
                    d++;
                    break;
                } else {
                    start++;
                }
            }

        }
        return d;

    }
}
