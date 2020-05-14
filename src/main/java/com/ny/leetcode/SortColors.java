package com.ny.leetcode;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int[] A = {3, 8, 14, 0, 2, 5};
        sortColors(A, 5);
        System.out.println(Arrays.toString(A));
    }

    private static void sortColors2(int[] A) {
        if (A.length <= 1) return;
        for (int i = 0, smaller = 0; i < A.length; i++) if (A[i] < 1) swap(A, i, smaller++);
        for (int i = A.length - 1, larger = A.length - 1; i >= 0; i--) if (A[i] > 1) swap(A, i, larger--);

    }

    private static void sortColors(int[] A, int pivotIndex) {
        if (A.length <= 1) return;
        int pivot = A[pivotIndex];
        int smaller = 0, larger = A.length;
        int equal = 0;
        while (equal < larger) {
            if (A[equal] < pivot)
                swap(A, equal++, smaller++);
            else if (A[equal] > pivot)
                swap(A, equal, --larger);
            else equal++;
        }
    }

    private static void swap(int[] A, int i, int j) {
        if (i != j) {
            int t = A[i];
            A[i] = A[j];
            A[j] = t;
        }
    }

}
