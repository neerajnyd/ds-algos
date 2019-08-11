package com.ny.leetcode;

public class RomanToInteger {
	
	public static void main(String[] args) {
		
		String romanNumber = "MCMXCVI";
		
		System.out.println(romanToIntegerBestTime(romanNumber));
		
	}
	
	private static int romanToInteger(String romanNumber) {
		
		int sum = 0;
		
		if (romanNumber.contains("IV")) sum -= 2;
		if (romanNumber.contains("IX")) sum -= 2;
		if (romanNumber.contains("XL")) sum -= 20;
		if (romanNumber.contains("XC")) sum -= 20;
		if (romanNumber.contains("CD")) sum -= 200;
		if (romanNumber.contains("CM")) sum -= 200;
		
		char[] arr = romanNumber.toCharArray();
		
		for (char c : arr) {
			if (c == 'I') sum += 1;
			if (c == 'V') sum += 5;
			if (c == 'X') sum += 10;
			if (c == 'L') sum += 50;
			if (c == 'C') sum += 100;
			if (c == 'D') sum += 500;
			if (c == 'M') sum += 1000;
		}
		
		return sum;
	}
	
	private static int romanToIntegerOnePass(String s) {
		
		int sum = 0;
		
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			
			switch (c) {
				case 'I':
					sum = sum + (sum >= 5 ? -1 : 1); //subtract 1 if sum > 5 else add 1
					break;
				case 'V':
					sum += 5;
					break;
				case 'X':
					sum = sum + (sum >= 50 ? -10 : 10); //subtract 10 if sum > 50 else add 10
					break;
				case 'L':
					sum += 50;
					break;
				case 'C':
					sum = sum + (sum >= 500 ? -100 : 100);
					break;
				case 'D':
					sum += 500;
					break;
				case 'M':
					sum += 1000;
					break;
			}
			
			
		}
		
		return sum;
	}
	
	private static int romanToIntegerBestTime(String s) {
		int[] nums = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
				case 'M':
					nums[i] = 1000;
					break;
				case 'D':
					nums[i] = 500;
					break;
				case 'C':
					nums[i] = 100;
					break;
				case 'L':
					nums[i] = 50;
					break;
				case 'X':
					nums[i] = 10;
					break;
				case 'V':
					nums[i] = 5;
					break;
				case 'I':
					nums[i] = 1;
					break;
			}
		}
		int sum = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1]) {
				sum -= nums[i];
			}
			else {
				sum += nums[i];
			}
		}
		return sum + nums[nums.length - 1];
	}
}
