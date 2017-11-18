package com.ny.leetcode;

/**
 * Given a sorted array consisting of only integers where every element appears
 * twice except for one element which appears once. Find this single element that
 * appears only once.
 */
public class SingleElementSortedArray {
	
	public static void main(String[] args) {
		
		int a[] = {2, 2, 3, 3, 4, 4, 8, 8, 9};
		System.out.println(singleNonDuplicate(a));
		
	}
	
	public static int singleNonDuplicate(int[] nums) {
		
		for (int i = 0; i < nums.length - 1; i += 2) {
			if (nums[i] != nums[i + 1]) {
				return nums[i];
			}
		}
		
		return nums[nums.length - 1];
	}
	
	public static int singleNonDuplicate2(int[] nums) {
		int start = 0, end = nums.length - 1;
		
		while (start < end) {
			// We want the first element of the middle pair,
			// which should be at an even index if the left part is sorted.
			// Example:
			// Index: 0 1 2 3 4 5 6
			// Array: 1 1 3 3 4 8 8
			//            ^
			int mid = (start + end) / 2;
			if (mid % 2 == 1) mid--;
			
			// We didn't find a pair. The single element must be on the left.
			// (pipes mean start & end)
			// Example: |0 1 1 3 3 6 6|
			//               ^ ^
			// Next:    |0 1 1|3 3 6 6
			if (nums[mid] != nums[mid + 1]) end = mid;
				
				// We found a pair. The single element must be on the right.
				// Example: |1 1 3 3 5 6 6|
				//               ^ ^
				// Next:     1 1 3 3|5 6 6|
			else start = mid + 2;
		}
		
		// 'start' should always be at the beginning of a pair.
		// When 'start > end', start must be the single element.
		return nums[start];
	}
	
	
}
