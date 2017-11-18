package com.ny.algorithms.dynamicprogramming;

import java.util.Arrays;

public class DynamicFibonacci {
	
	public static void main(String[] args) {
		
		int number = 5;
		
		int fib = fibonacci(number);
		
		System.out.println(fib);
		
	}
	
	private static int fibonacci(int n) {
		
		int[] memoizationArray = new int[n + 1];
		Arrays.fill(memoizationArray, -1);
		
		int fib = fibonacci(n, memoizationArray);
		return fib;
	}
	
	private static int fibonacci(int n, int[] a) {
		
		if (n <= 2) {
			return 1;
		} else if (a[n] != -1) {
			return a[n];
		} else {
			a[n] = fibonacci(n - 1, a) + (fibonacci(n - 2, a));
		}
		return a[n];
	}
	
}
