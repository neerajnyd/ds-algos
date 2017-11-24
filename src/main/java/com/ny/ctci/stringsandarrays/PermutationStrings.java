package com.ny.ctci.stringsandarrays;

public class PermutationStrings {
	
	public static void main(String[] args) {
		System.out.println(ifStringsArePermutations("Neeraj", "jareen"));
	}
	
	private static boolean ifStringsArePermutations(String str1, String str2) {
		
		if (str1.length() == str2.length()) {
			char[] c1 = str1.toCharArray();
			char[] c2 = str2.toCharArray();
			
			int sum1 = 0;
			int sum2 = 0;
			for (char c : c1) {
				sum1 += c;
			}
			for (char c : c2) {
				sum2 += c;
			}
			if (sum1 == sum2) {
				return true;
			}
		}
		
		return false;
	}
	
}
