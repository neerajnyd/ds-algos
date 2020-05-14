package com.ny.leetcode.curatedlistchallenge.day1;

/*
https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {
    public void rotate(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return;
        int rows = M.length;
        int cols = M[0].length;

        for (int lo = 0, hi = rows - 1; lo < hi; lo++, hi--) {
            int[] tmp = M[lo];
            M[lo] = M[hi];
            M[hi] = tmp;
        }

        for (int i = 0; i < rows; i++)
            for (int j = i + 1; j < cols; j++) {
                int tmp = M[i][j];
                M[i][j] = M[j][i];
                M[j][i] = tmp;
            }
    }

    /* Counter-clockwise Rotate */
    public void antiRotate(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return;
        int rows = M.length;
        int cols = M[0].length;

        for (int lo = 0, hi = cols - 1; lo < hi; lo++, hi--)
            for (int i = 0; i < rows; i++) {
                int tmp = M[i][lo];
                M[i][lo] = M[i][hi];
                M[i][hi] = tmp;
            }

        for (int i = 0; i < rows; i++)
            for (int j = i + 1; j < cols; j++) {
                int tmp = M[i][j];
                M[i][j] = M[j][i];
                M[j][i] = tmp;
            }
    }
}
