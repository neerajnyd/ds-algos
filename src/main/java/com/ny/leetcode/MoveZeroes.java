package com.ny.leetcode;

public class MoveZeroes {

    public static void main(String[] args) {

        int[] A = {0,1,0,3,12};

        moveZeroes(A);

        for (int i : A) System.out.print(i + " ");

    }

    private static void moveZeroes(int[] A) {
        int j = 0;
        for (int i = 0; i < A.length; i++) if (A[i] != 0) A[j++] = A[i];
        for (; j < A.length; j++) A[j] = 0;

    }

}
