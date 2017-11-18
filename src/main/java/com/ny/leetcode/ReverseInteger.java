package com.ny.leetcode;

public class ReverseInteger {
	
	public static void main(String[] args) {
		
		int num = 1534236469;
		
		System.out.println(bruteForce(num));
		
	}
	
	private static int bruteForce(int x) {
		
		int xReversed = 0;
		while (x != 0) {
			int remainder = x % 10;
			
			int xReversedCopy = xReversed * 10 + remainder;
			if ((xReversedCopy - remainder) / 10 != xReversed) {
				return 0;
			}
			xReversed = xReversedCopy;
			x = x / 10;
		}
		return xReversed;
		
	}
	
}
