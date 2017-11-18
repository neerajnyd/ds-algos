package com.ny.algorithms.sorting;

import com.ny.util.Util;

import java.util.Arrays;

/**
 * repeatedly identifies the smallest remaining unsorted element and
 * puts it at the end of the sorted portion of the array.
 *
 * @author Neeraj
 */
public class SelectionSort {
	
	private static void selectionSort(int[] s, int n) {
		
		for (int i = 0; i < n - 1; i++) {
			
			// find min element index operation
			int minElementIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (s[j] < s[minElementIndex]) {
					minElementIndex = j;
				}
			}
			System.out.println(Arrays.toString(s));
			System.out.println("Swapping " + s[i] + " and " + s[minElementIndex]);
			//swap operation
			int temp = s[i];
			s[i] = s[minElementIndex];
			s[minElementIndex] = temp;
			System.out.println(Arrays.toString(s));
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[] s = Util.getRandomNumberArray();
		System.out.println("ArrayLength: " + s.length);
		selectionSort(s, s.length);
		
	}
	
}
