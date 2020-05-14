package com.ny.leetcode;


import java.util.Stack;

public class NumberOfIslands {
    public static void main(String[] args) {
        /*char[][] A = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };*/
        char[][] A = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(A));
    }

    public static int numIslands2(char[][] A) {
        if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {
            return 0;
        }

        int m = A.length;
        int n = A[0].length;
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == '1') {
                    visit(A, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private static void visit(char[][] A, int row, int col) {
        int rows = A.length;
        int cols = A[0].length;
        A[row][col] = '0';
        if (col < cols - 1 && A[row][col + 1] == '1') {
            visit(A, row, col + 1);
        }
        if (row < rows - 1 && A[row + 1][col] == '1') {
            visit(A, row + 1, col);
        }
        if (col > 0 && A[row][col - 1] == '1') {
            visit(A, row, col - 1);
        }
        if (row > 0 && A[row - 1][col] == '1') {
            visit(A, row - 1, col);
        }
    }

    public static int numIslands(char[][] A) {
        int islands = 0;
        final int m = A.length;
        final int n = A[0].length;
        boolean[][] V = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(A[i][j] == '1' && !V[i][j]) {
                    markIslandVisited(A, V, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void markIslandVisited(char[][] A, boolean[][] V, int i, int j) {
        final int m = A.length;
        final int n = A[0].length;
        Stack<CharPosition> S = new Stack<>();
        S.push(new CharPosition(i, j));

        while (!S.isEmpty()) {
            final CharPosition position = S.pop();
            final int x = position.i;
            final int y = position.j;
            V[x][y] = true;
            if(x > 0 && A[x-1][y] == '1' && !V[x-1][y]) S.push(new CharPosition(x-1, y));
            if(x < m-1 && A[x+1][y] == '1' && !V[x+1][y]) S.push(new CharPosition(x+1, y));
            if(y > 0 && A[x][y-1] == '1' && !V[x][y-1]) S.push(new CharPosition(x, y-1));
            if(y < n-1 && A[x][y+1] == '1' && !V[x][y+1]) S.push(new CharPosition(x, y+1));
        }

    }

    private static class CharPosition {
        private final int i;
        private final int j;

        private CharPosition(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
