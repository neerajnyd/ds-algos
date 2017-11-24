package com.ny.leetcode;

public class SearchInsertPosition {
	
	public static void main(String[] args) {
		
		int nums[] = {1, 3, 5, 6};
		
		System.out.println(searcInsertPositionMinTime(nums, 7));
		
	}
	
	private static int searcInsertPositionMinTime(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		if (nums[start] >= target) {
			return start;
		}
		if (nums[end] >= target) {
			return end;
		}
		return nums.length;
	}
	
	private static int searchInsertPositionInN(int[] nums, int target) {
		int i = 0;
		while (i < nums.length && nums[i] < target) {
			i++;
		}
		
		return i;
	}
	
	private static int searchInsertPositionInLogN(int[] nums, int target) {
		
		return search(nums, 0, nums.length - 1, target);
	}
	
	private static int search(int[] nums, int start, int end, int target) {
		
		if (target > nums[end]) {
			return end + 1;
		} else if (target < nums[start]) {
			return start;
		} else {
			
			int mid = (start + end) / 2;
			
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				return search(nums, 0, mid, target);
			} else {
				return search(nums, mid + 1, end, target);
			}
		}
	}
	
}
