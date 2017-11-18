package com.ny.algorithms;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
	
	public static void main(String[] args) {
		
		String digits = "1234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321123443211234432112344321321";
		System.out.println(findLongestSubArray(digits));
		System.out.println(digits.length());
		
	}
	
	private static int findLongestSubArray(String digits) {
		int subArrayLength = 0;
		char[] a = digits.toCharArray();
		int size = a.length;
		
		for (int i = size; i >= 0; i--) {
			if (i % 2 != 0) { // make sure i is even
				i--;
			}
			
			for (int j = 0; j <= (size - i); j++) {
				Map<Character, Integer> map = putCharsIntoMap(a, j, i + j);
				if (checkIfPalindrome(map)) {
					return i;
				}
			}
		}
		return subArrayLength;
		
	}
	
	/*
		if all values occur in pairs then they can be rearranged to form a palindrome
	 */
	private static boolean checkIfPalindrome(Map<Character, Integer> map) {
		
		for (Integer i : map.values()) {
			if (i % 2 != 0) {
				return false;
			}
		}
		return true;
	}
	
	private static Map<Character, Integer> putCharsIntoMap(char[] array, int lowerBound, int upperBound) {
		Map<Character, Integer> map = new HashMap<>();
		
		for (int k = lowerBound; k < upperBound; k++) {
			if (map.containsKey(array[k])) {
				Integer value = map.get(array[k]) + 1;
				map.put(array[k], value);
			} else {
				map.put(array[k], 1);
			}
		}
		
		return map;
	}
}
