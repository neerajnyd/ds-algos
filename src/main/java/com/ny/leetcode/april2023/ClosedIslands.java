package com.ny.leetcode.april2023;

import java.util.LinkedList;
import java.util.Queue;

public class ClosedIslands {


    public int closedIsland(int[][] grid) {

        int count = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == 0 && !visited[i][j] &&
//                        dfs(grid, visited, i, j)
                        bfs(grid, visited, i, j)
                ) {
                    count++;
                }

        return count;
    }

    private boolean bfs(int[][] grid, boolean[][] visited, int x, int y) {

        boolean isClosed = true;
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{x, y});
        visited[x][y] = true;

        int[] dirX = {0, 0, -1, 1};
        int[] dirY = {-1, 1, 0, 0};

        while (!Q.isEmpty()) {
            int[] temp = Q.poll();
            x = temp[0];
            y = temp[1];

            for (int i = 0; i < 4; i++) {
                int r = x + dirX[i];
                int c = y + dirY[i];

                if (r < 0 || r == grid.length || c < 0 || c == grid[0].length) {
                    isClosed = false;
                } else if (grid[r][c] == 0 && !visited[r][c]) {
                    Q.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return isClosed;
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int x, int y) {

        if (x < 0 || y < 0 || x == grid.length || y == grid[0].length) return false;

        if (visited[x][y] || grid[x][y] == 1) return true;

        visited[x][y] = true;

        boolean isClosed = true;

        int[] dirX = {0, 0, -1, 1};
        int[] dirY = {-1, 1, 0, 0};

        for (int k = 0; k < 4; k++)
            if (!dfs(grid, visited, x + dirX[k], y + dirY[k]))
                isClosed = false;

        return isClosed;
    }

}
