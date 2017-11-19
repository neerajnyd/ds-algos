package com.ny.leetcode;

public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		String[] str = {"abababab", "acacacaca", "adadadad"};
		System.out.println("Answer: " + longestCommonPrefix2(str));
	}
	
	private static String longestCommonPrefix(String[] strs) {
		
		if (strs.length == 0) {
			return "";
		} else if (strs.length == 1) {
			return strs[0];
		}
		
		String common = strs[0];
		
		for (int i = 1; i < strs.length; i++) {
			
			char c1[] = common.toCharArray();
			char c2[] = strs[i].toCharArray();
			
			int minLength = c1.length < c2.length ? c1.length : c2.length;
			
			StringBuilder commonBuilder = new StringBuilder();
			
			for (int j = 0; j < minLength; j++) {
				if (c1[j] == c2[j]) {
					commonBuilder.append(c1[j]);
				} else {
					break;
				}
			}
			common = commonBuilder.toString();
			
		}
		
		return common;
	}
	
	private static String longestCommonPrefix2(String[] strs) {
		
		if (strs.length == 0 || strs == null) {
			return "";
		}
		
		String common = strs[0];
		
		int i = 1;
		
		while (i < strs.length) {
			
			/*
			while we dont find the common in str[i] at index 0,
			continue shortening the length of common to find
            the new common
			 */
			while (strs[i].indexOf(common) != 0) {
				
				common = common.substring(0, common.length() - 1);
				
			}
			
			i++;
		}
		return common;
	}
	
}
