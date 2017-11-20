package com.ny.leetcode;

public class RemoveElement {
	
	public static void main(String[] args) {
		
		int[] nums = {3, 2, 2, 3, 3, 2, 2, 3};
		
		System.out.println(removeElement(nums, 3));
		for (int n : nums) {
			System.out.print(n + " ");
		}
		
	}
	
	private static int removeElement(int[] nums, int val) {
		if (nums.length == 0) {
			return 0;
		}
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}
	
	/*
	Since the order of elements could be changed.
	When we encounter nums[i] = valnums[i]=val,
	we can swap the current element out with the last element and dispose the last one.
	This essentially reduces the array's size by 1.
	 */
	public int removeElementWhereValIsRare(int[] nums, int val) {
		int i = 0;
		int n = nums.length;
		while (i < n) {
			if (nums[i] == val) {
				nums[i] = nums[n - 1];
				// reduce array size by one
				n--;
			} else {
				i++;
			}
		}
		return n;
	}
	
}
