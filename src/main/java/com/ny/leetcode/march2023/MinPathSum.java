package com.ny.leetcode.march2023;

import java.util.Map;

public class MinPathSum {

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                if (row == 0 && col == 0) continue;

                int val = grid[row][col];
                if (row == 0) grid[row][col] = val + grid[row][col - 1];
                else if (col == 0) grid[row][col] = val + grid[row - 1][col];
                else grid[row][col] = val + Math.min(grid[row - 1][col], grid[row][col - 1]);
            }
        }

        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        Map<String, String> map = Map.of();
        System.out.println(map);
    }


}
