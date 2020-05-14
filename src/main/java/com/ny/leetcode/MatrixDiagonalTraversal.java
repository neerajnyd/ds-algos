package com.ny.leetcode;

public class MatrixDiagonalTraversal {

    public static void main(String[] args) {
        int[][] M = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        int[] R = findDiagonalOrder(M);
        for (int value : R) {
            System.out.print(value + " ");
        }
    }

    @SuppressWarnings("ConstantConditions")
    private static int[] findDiagonalOrder(int[][] M) {

        if (M.length == 0 || M[0].length == 0) return new int[]{};

        int m = M.length;
        int n = M[0].length;
        int[] A = new int[m * n]; //result array
        for (int k = 0, r = 0, c = 0; k < A.length; k++) {
            A[k] = M[r][c];
            if ((r + c) % 2 == 0) {//going up
                boolean lastCol = c == n - 1;
                if (lastCol) {
                    r++;
                } else {
                    if (r != 0) {
                        r--;
                    }
                    c++;
                }
            } else {//going down
                boolean lastRow = r == m - 1;
                if (lastRow) {
                    c++;
                } else {
                    if (c != 0) {
                        c--;
                    }
                    r++;
                }
            }

        }
        return A;
    }

    public int[] findDiagonalOrder2(int[][] M) {
        if (M.length == 0) return new int[0];
        int row = 0;
        int col = 0;
        int R = M.length;
        int C = M[0].length;
        int[] A = new int[R * C];
        for (int i = 0; i < A.length; i++) {
            A[i] = M[row][col];
            if ((row + col) % 2 == 0) { // moving up
                if (col == C - 1) {
                    row++;
                } else if (row == 0) {
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else {                // moving down
                if (row == R - 1) {
                    col++;
                } else if (col == 0) {
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return A;
    }

}
