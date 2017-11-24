package com.ny.leetcode;

public class PalindromeNumber {
	
	public static void main(String[] args) {
		int num = 121;
		
		System.out.println(isPalindrome(num));
	}
	
	/*
	Check out: https://leetcode.com/problems/palindrome-number/solution/ for details
	 */
	public static boolean isPalindrome(int x) {
		
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		
		int reverse = 0;
		
		//reverse only half the digits
		
		while (x > reverse) {
			
			reverse = reverse * 10 + x % 10;
			x = x / 10;
		}
		//discard the middle digit, i.e., the last digit of reverse
		return x == reverse || x == reverse/10;
	}
	
}
