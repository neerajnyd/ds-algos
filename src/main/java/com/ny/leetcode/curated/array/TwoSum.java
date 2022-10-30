package com.ny.leetcode.curated.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {
	
	public static void main(String[] args) {
		
		int[] nums = {-1, -2, -3, -4, -5};
		int target = -8;
		int[] result = onePassHashTable(nums, target);
		Arrays.stream(result).forEach((n) -> System.out.print(n + " "));
		
	}
	
	private static int[] onePassHashTable(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			
			if (map.containsKey(complement)) {
				return new int[]{i, map.get(complement)};
			}
			
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	private static int[] twoPassHashTable(int[] nums, int target) {
		//map of number and its index
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			//check if map contains the complement and if does check if the complement's index is not the same as this number
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[]{i, map.get(complement)};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	private static int[] bruteForce(int[] nums, int target) {
		
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					
					return new int[]{i, j};
					
				}
			}
			
		}
		
		throw new IllegalArgumentException("No two sum solution");
	}
	
}
