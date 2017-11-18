package com.ny.algorithms.sorting;

import com.ny.FunctionalUtil;
import com.ny.util.Util;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] s = Util.getRandomNumberArray();
		System.out.println("ArrayLength: " + s.length);
		Arrays.stream(s).forEach(x -> System.out.print(x + " "));
		System.out.println();
		FunctionalUtil.timed("Merge sort", () -> mergeSort(s, 0, s.length - 1));
		Arrays.stream(s).forEach(x -> System.out.print(x + " "));
		
	}
	
	private static int[] mergeSort(int[] s, int low, int high) {
		
		int mid;
		
		if (low < high) {
			mid = (low + high) / 2;
			mergeSort(s, low, mid);
			mergeSort(s, mid + 1, high);
			merge(s, low, mid, high);
		}
		return s;
	}
	
	private static void merge(int[] arr, int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

        /* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

        /*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i) {
			L[i] = arr[l + i];
		}
		for (int j = 0; j < n2; ++j) {
			R[j] = arr[m + 1 + j];
		}


        /* Merge the temp arrays */
		
		// Initial indexes of first and second subarrays
		int i = 0, j = 0;
		
		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

        /* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

        /* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
}
