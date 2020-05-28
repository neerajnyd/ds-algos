package com.ny.leetcode.may2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day23_IntervalListIntersections {
    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(intervalIntersection(
                        new int[][]
                                {{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                        new int[][]
                                {{1, 5}, {8, 12}, {15, 24}, {25, 26}}
                ))
        );
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> R = new ArrayList<>();

        int i = 0, j = 0;

        while ((i < A.length && j < B.length)) {

            int[] x = A[i];
            int[] y = B[j];

            //no intersection
            int a = x[0];
            int b = x[1];
            int c = y[0];
            int d = y[1];

            if (b >= c && d >= a) //compare with another working condition -> if (a <= d && a >= c || ((c >= a) && (c <= b))) {
                R.add(new int[]{Math.max(a, c), Math.min(b, d)});

            if (d > b) i++;
            else j++;

        }

        return R.toArray(new int[R.size()][2]);
    }

    public static int[][] intervalIntersection2(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0)
            return new int[0][0];
        if (B.length > A.length)
            return intervalIntersection(B, A);

        List<int[]> R = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int[] x = A[i];
            int[] y = B[j];
            int a = x[0];
            int b = x[1];
            int c = y[0];
            int d = y[1];
            if (a <= d && a >= c || ((c >= a) && (c <= b))) {
                R.add(new int[] { Math.max(a, c), Math.min(b, d) });
            }
            if (d < b) {
                j++;
            } else {
                i++;
            }
        }
        return R.toArray(new int[R.size()][2]);
    }
}
