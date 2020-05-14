package com.ny.leetcode;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] A = {{3, 8, 6, 0, 5, 9, 9, 6, 3, 4, 0, 5, 7, 3, 9, 3},
                {0, 9, 2, 5, 5, 4, 9, 1, 4, 6, 9, 5, 6, 7, 3, 2},
                {8, 2, 2, 3, 3, 3, 1, 6, 9, 1, 1, 6, 6, 2, 1, 9},
                {1, 3, 6, 9, 9, 5, 0, 3, 4, 9, 1, 0, 9, 6, 2, 7},
                {8, 6, 2, 2, 1, 3, 0, 0, 7, 2, 7, 5, 4, 8, 4, 8},
                {4, 1, 9, 5, 8, 9, 9, 2, 0, 2, 5, 1, 8, 7, 0, 9},
                {6, 2, 1, 7, 8, 1, 8, 5, 5, 7, 0, 2, 5, 7, 2, 1},
                {8, 1, 7, 6, 2, 8, 1, 2, 2, 6, 4, 0, 5, 4, 1, 3},
                {9, 2, 1, 7, 6, 1, 4, 3, 8, 6, 5, 5, 3, 9, 7, 3},
                {0, 6, 0, 2, 4, 3, 7, 6, 1, 3, 8, 6, 9, 0, 0, 8},
                {4, 3, 7, 2, 4, 3, 6, 4, 0, 3, 9, 5, 3, 6, 9, 3},
                {2, 1, 8, 8, 4, 5, 6, 5, 8, 7, 3, 7, 7, 5, 8, 3},
                {0, 7, 6, 6, 1, 2, 0, 3, 5, 0, 8, 0, 8, 7, 4, 3},
                {0, 4, 3, 4, 9, 0, 1, 9, 7, 7, 8, 6, 4, 6, 9, 5},
                {6, 5, 1, 9, 9, 2, 2, 7, 4, 2, 7, 2, 2, 3, 7, 2},
                {7, 1, 9, 6, 1, 2, 7, 0, 9, 6, 6, 4, 4, 5, 1, 0},
                {3, 4, 9, 2, 8, 3, 1, 2, 6, 9, 7, 0, 2, 4, 2, 0},
                {5, 1, 8, 8, 4, 6, 8, 5, 2, 4, 1, 6, 2, 2, 9, 7}};

        System.out.println(minPathSum(A));
    }

    public static int minPathSum(int[][] A) {
        final LocalTime start = LocalTime.now();
        int answer;
        if (A == null || A.length == 0 || A[0].length == 0) answer = 0;
        else answer = helper(A, 0, 0, new int[A.length][A[0].length]);
        final LocalTime end = LocalTime.now();
        final Duration duration = Duration.between(start, end);
        System.out.println(duration.get(ChronoUnit.NANOS));
        return answer;
    }

    private static int helper(int[][] A, int row, int col, int[][] sums) {
        int sum = A[row][col], nextRowSum = -1, nextColSum = -1;

        if (row < A.length - 1)
            nextRowSum = sums[row + 1][col] != 0 ?
                    sums[row + 1][col] :
                    helper(A, row + 1, col, sums);

        if (col < A[0].length - 1)
            nextColSum = sums[row][col + 1] != 0 ?
                    sums[row][col + 1] :
                    helper(A, row, col + 1, sums);

        int sumAtPosition;
        if (nextRowSum == -1 && nextColSum != -1)
            sumAtPosition = sum + nextColSum;
        else if (nextRowSum != -1 && nextColSum == -1)
            sumAtPosition = sum + nextRowSum;
        else if (nextRowSum == -1 /* && nextColSum == -1 */)
            sumAtPosition = sum;
        else
            sumAtPosition = sum + Math.min(nextRowSum, nextColSum);

        sums[row][col] = sumAtPosition;

        return sumAtPosition;
    }

}
