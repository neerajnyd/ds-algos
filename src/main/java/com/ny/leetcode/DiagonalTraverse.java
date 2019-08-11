package com.ny.leetcode;

public class DiagonalTraverse {

    public static void main(String[] args) {

        int[][] A = {
                        {1, 2, 3, 4},
                        {4, 5, 6, 10},
                        {7, 8, 9, 11}
                };

        int[] result = traverseTwoDimensioanlArrayDiagonally(A);

        for(int n : result) {
            System.out.print(n + " ");
        }

    }

    private static int[] traverseTwoDimensioanlArrayDiagonally(int[][] A) {
        int[] R = new int[A.length*A[0].length];
        int i=0, j=0, k=0;
        while (i < A.length && j < A[0].length) {

            R[k] = A[i][j];
            i++;
        }


        return R;
    }

}
