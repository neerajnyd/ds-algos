package com.ny.leetcode;

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
	As long as nums[i] = nums[j], we increment j to skip the duplicate.
	When we encounter nums[j]≠ nums[i], the duplicate run has ended
	so we must copy its value to nums[i + 1].
	ii is then incremented and we repeat the same process again
	until jj reaches the end of array.
	 */
	public static int removeDuplicatesOfficial(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
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
