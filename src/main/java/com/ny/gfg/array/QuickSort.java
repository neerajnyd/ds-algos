package com.ny.gfg.array;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {9, 5, 6, 4, 8, 0, 2, 3};
        System.out.println(" INPUT: " + Arrays.toString(arr));
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.quicksort(arr, 0, n - 1);
        System.out.println("OUTPUT: " + Arrays.toString(arr));
    }

    private void quicksort(int[] A, int lo, int hi) {
        if (lo < hi) {
            int pi = partition2(A, lo, hi);
            quicksort(A, lo, pi - 1);
            quicksort(A, pi + 1, hi);
        }
    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in (future) sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    private int partition2(int[] A, int lo, int hi) {
        int pivot = A[hi];
        int i = (lo - 1); int j = lo;
        while (j < hi) {
            if (A[j] < pivot) swap(A, ++i, j); // If current element is smaller than the pivot
            j++;
        }
        // swap A[i+1] and A[hi] (or pivot)
        swap(A, i+1, hi);
        return i + 1;
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

}
