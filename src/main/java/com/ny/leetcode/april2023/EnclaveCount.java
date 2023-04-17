package com.ny.leetcode.april2023;

public class EnclaveCount {

    int rows = -1;
    int cols = -1;

    public int numEnclaves(int[][] grid) {

        //1 is land, 0 is water
        this.rows = grid.length;
        this.cols = grid[0].length;

        //can we NOT go from a land cell to off grid?

        /*
        |0|0|0|0|
        |1|0|1|0|  <---this row has a 1 on the left that is connected to the outside world
        |0|1|1|0|  <--- these 1s are not connected to the outside world so counted as an enclave
        |0|0|0|0|

        |0|1|1|0| these 1s are connected to the outside world, so we can't consider it an enclave
        |0|0|1|0|
        |0|0|1|0|
        |0|0|0|0|
         */

        int count = 0;

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (x * y == 0 || x == rows - 1 || y == cols - 1) { //boundaries of grid
                    floodFill_dfs(grid, x, y);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        return count;
    }

    private void floodFill_dfs(int[][] grid, int x, int y) {

        if (x < 0 || x == rows || y < 0 || y == cols || grid[x][y] != 1) return;

        grid[x][y] = 0; //whatever we are able to reach from the 1s at boundaries we mark as water

        int[] dirX = {0, 0, 1, -1};
        int[] dirY = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            floodFill_dfs(grid, x + dirX[i], y + dirY[i]);
        }

    }

}
