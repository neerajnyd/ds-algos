package com.ny.leetcode.contestbiweekly102;

public class WidthOfColsOfGrid {

    public int[] findColumnWidth(int[][] grid) {

        int[] result = new int[grid[0].length];

        /*
        for each row, find the max length of each column
         */
        for (int[] ints : grid) {
            for (int j = 0; j < ints.length; j++) {
                result[j] = Math.max(result[j], String.valueOf(ints[j]).length());
            }
        }

        return result;
    }

}
