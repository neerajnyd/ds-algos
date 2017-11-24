package com.ny.ctci.stringsandarrays;

public class OneAway {
	
	public static void main(String[] args) {
		
		System.out.println(oneAway("pale", "paless"));
	}
	
	private static boolean oneAway(String str1, String str2) {
		if (str1.length() + 1 == str2.length()) {
			return oneEditInsert(str1, str2);
		} else if (str1.length() == str2.length() + 1) {
			return oneEditInsert(str2, str1);
		} else if (str1.length() == str2.length()) {
			return oneEditReplace(str1, str2);
		}
		return false;
	}
	
	private static boolean oneEditReplace(String str1, String str2) {
		boolean diff = false;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				if (diff) {
					return false;
				}
				diff = true;
			}
		}
		return true;
	}
	
	private static boolean oneEditInsert(String s1, String s2) {
		
		int index1 = 0;
		int index2 = 0;
		
		while (index1 < s1.length() && index2 < s2.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1 += 1;
				index2 += 1;
			}
		}
		return true;
	}
	
}
