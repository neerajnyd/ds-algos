package com.ny.algorithms.dynamicprogramming;

import java.util.Arrays;

public class ArraySum {

    private static void arraySum(int[] A) {

        int i = A.length - 1;
        A[i] = arraySum(A, i);
    }

    private static int arraySum(int[] A, int i) {
        System.out.println("for i = " + i);
        int val = i == 0 ? A[0] : A[i] + arraySum(A, i - 1);
        A[i] = val;
        return val;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(A));
        arraySum(A);
        System.out.println(Arrays.toString(A));
        System.out.println(A[A.length-1]);
    }

}
