package com.ny.leetcode.contest337;

public class KnightTourConfig {

    public static void main(String[] args) {

        KnightTourConfig c = new KnightTourConfig();

        int[][] grid = {
                {0, 11, 16, 5, 20},
                {17, 4, 19, 10, 15},
                {12, 1, 8, 21, 6},
                {3, 18, 23, 14, 9},
                {24, 13, 2, 7, 22}
        };

        int[][] grid2 = {
                {0, 3, 6},
                {5, 8, 1},
                {2, 7, 4}

        };

        System.out.println(c.checkValidGrid(grid2));

    }

    private int n = 0;

    public boolean checkValidGrid(int[][] grid) {
        this.n = grid.length;
        if (n == 3 && grid[1][1] != 8) return false;
        int i = 0, j = 0;
        int move = 1;
        int count = n * n;

        while (move < count) {
            boolean moveFound = false;
            int r;
            int c;
            r = i - 2;
            c = j - 1;
            if (inRange(r, c)) {
                if (grid[r][c] == move) {
                    i = r;
                    j = c;
                    moveFound = true;
                }
            }
            r = i - 2;
            c = j + 1;
            if (inRange(r, c)) {
                if (grid[r][c] == move) {
                    i = r;
                    j = c;
                    moveFound = true;
                }
            }
            r = i - 1;
            c = j - 2;
            if (inRange(r, c)) {
                if (grid[r][c] == move) {
                    i = r;
                    j = c;
                    moveFound = true;
                }
            }
            r = i - 1;
            c = j + 2;
            if (inRange(r, c)) {
                if (grid[r][c] == move) {
                    i = r;
                    j = c;
                    moveFound = true;
                }
            }

            r = i + 1;
            c = j - 2;
            if (inRange(r, c)) {
                if (grid[r][c] == move) {
                    i = r;
                    j = c;
                    moveFound = true;
                }
            }
            r = i + 1;
            c = j + 2;
            if (inRange(r, c)) {
                if (grid[r][c] == move) {
                    i = r;
                    j = c;
                    moveFound = true;
                }
            }
            r = i + 2;
            c = j - 1;
            if (inRange(r, c)) {
                if (grid[r][c] == move) {
                    i = r;
                    j = c;
                    moveFound = true;
                }
            }
            r = i + 2;
            c = j + 1;
            if (inRange(r, c)) {
                if (grid[r][c] == move) {
                    i = r;
                    j = c;
                    moveFound = true;
                }
            }


            if (moveFound) {
                move++;
            } else {
                return false;
            }

        }
        return true;
    }

    private boolean inRange(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }

}
