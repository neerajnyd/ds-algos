package com.ny.leetcode;

public class ReverseInteger {
	
	public static void main(String[] args) {
		
		int num = Integer.MAX_VALUE;
		
		System.out.println(noOverFlowSupport(num));
		
	}

	private static int noOverFlowSupport(int x) {

		int num = 0;

		while (x != 0) {

			int tail = x % 10;
			int newNum = num * 10 + tail;
			if((newNum - tail)/10 != num) {
				return 0;
			}
			num = newNum;
			x /= 10;
		}
		return num;
	}
	
}
