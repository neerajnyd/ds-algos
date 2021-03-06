package com.ny.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted array, remove the duplicates in-place such that each element appear
 * only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory
 */
public class RemoveDuplicates {
	
	public static void main(String[] args) {
		
		int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 5, 5, 6, 7, 8, 9, 10, 10, 11};
		System.out.println(removeDuplicatesOfficial(nums));
		
	}
	
	/*
	ii is the slow-runner while jj is the fast-runner.
	As long as A[i] = A[j], we increment j to skip the duplicate.
	When we encounter A[j]≠ A[i], the duplicate run has ended
	so we must copy its val to A[i + 1].
	ii is then incremented and we repeat the same process again
	until jj reaches the end of array.
	 */
	public static int removeDuplicatesOfficial(int[] nums) {
		if(nums.length == 0) return 0;
		int ii = 0;
		for(int jj = 1; jj < nums.length; jj++) {
			if(nums[ii] != nums[jj]) {
				ii++;
				nums[ii] = nums[jj];
			}
		}
		return ii+1;
	}
	
	private static int removeDuplicates(int[] nums) {
		int totalCount = 0;
		int t = nums.length;
		for (int i = 0; i < t - 1; i++) {
			int el = nums[i];
			int localCount = 0;
			int j = i + 1;
			while (j < t && nums[j] == el) {
				totalCount++;
				localCount++;
				j++;
			}
			for (int k = j; k < t; k++) {
				nums[k - localCount] = nums[k];
			}
			t -= localCount;
		}
		return nums.length - totalCount;
	}
}
