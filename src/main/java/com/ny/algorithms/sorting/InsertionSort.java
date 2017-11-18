package com.ny.algorithms.sorting;

import com.ny.util.Util;

import java.util.Arrays;

/**
 * starts with a single element (thus forming a trivially sorted list) and then
 * incrementally inserts the remaining elements so that the list stays sorted.
 *
 * @author Neeraj
 */
public class InsertionSort {
	
	private static void insertionSort(int[] s, int n) {
		
		for (int i = 1; i < n; i++) {
			int j = i;
			while (j > 0 && s[j] < s[j - 1]) {
				
				System.out.println(Arrays.toString(s));
				System.out.println("Swapping " + s[j] + " and " + s[j - 1]);
				
				//--------THE MEAT--------//
				int temp = s[j];
				s[j] = s[j - 1];
				s[j - 1] = temp;
				j--;
				//--------THE MEAT--------//
				
				System.out.println(Arrays.toString(s));
				System.out.println();
			}
			
		}
	}
	
	public static void main(String[] args) {
		int[] s = Util.getRandomNumberArray();
		System.out.println("ArrayLength: " + s.length);
		insertionSort(s, s.length);
		
	}
	
}
