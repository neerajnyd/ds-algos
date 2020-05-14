package com.ny.gfg.recursion;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Recursion_01_FloodFillAlgorithm {

    public static void main(String[] args) throws Exception {

        final Scanner in = new Scanner(new File("C:\\Users\\NY\\Desktop\\tc.txt"));
//      Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int i = in.nextInt();
            int j = in.nextInt();
            int[][] A = new int[i][j];
            for (int p = 0; p < i; p++) {
                for (int q = 0; q < j; q++) {
                    A[p][q] = in.nextInt();
                }
            }
            int x = in.nextInt();
            int y = in.nextInt();
            int oldValue = A[x][y];
            int newValue = in.nextInt();
            if (oldValue != newValue)
                dfs(A, x, y, oldValue, newValue);
            for (int k = 0; k < i; k++) {
                for (int l = 0; l < j; l++) {
                    System.out.print(A[k][l] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void dfs(int[][] A, int x, int y, int oldValue, int newValue) {
        if (oldValue == newValue) return;
        if (x < 0 || x == A.length || y < 0 || y == A[0].length) return;
        if (A[x][y] != oldValue) return;

        A[x][y] = newValue;

        if (x > 0 && A[x - 1][y] == oldValue) dfs(A, x - 1, y, oldValue, newValue);
        if (x < A.length - 1 && A[x + 1][y] == oldValue) dfs(A, x + 1, y, oldValue, newValue);
        if (y > 0 && A[x][y - 1] == oldValue) dfs(A, x, y - 1, oldValue, newValue);
        if (y < A[0].length - 1 && A[x][y + 1] == oldValue) dfs(A, x, y + 1, oldValue, newValue);
    }

    private void dfs_leetcode(int[][] A, int x, int y, int oldValue, int newValue) {
        /* base case */
        if (x < 0 || x >= A.length || y < 0 || y >= A[0].length || A[x][y] != oldValue) return;
        A[x][y] = newValue;
        /* Initiate a directions array */
        int[][] directions = new int[][]{
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        for (int[] eachDirection : directions) {
            int i = x + eachDirection[0];/* x+0 |x+1  |x-1    |x+0 */
            int j = y + eachDirection[1];/* y+1 |y+0  |y+0    |x-1 */
            /* recurse on all neigbors. */
            dfs_leetcode(A, i, j, oldValue, newValue);
        }
    }

    private void bfs_leetcode(int[][] A, int x, int y, int oldValue, int newValue) {
        if (oldValue == newValue) return;
        final boolean[][] visited = new boolean[A.length][A[0].length];
        final Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        final int[][] directions = new int[][]{
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        while (!queue.isEmpty()) {
            final int[] curr = queue.poll();
            A[curr[0]][curr[1]] = newValue;
            for (int[] eachDirection : directions) {
                int i = eachDirection[0] + curr[0];
                int j = eachDirection[1] + curr[1];
                if (i >= 0 && i < A.length &&
                        j >= 0 && j < A[0].length &&
                        A[i][j] == oldValue && !visited[i][j]) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
    }

}
