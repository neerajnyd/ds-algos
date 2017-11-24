package com.ny.ctci.stringsandarrays;

public class UniqueStrings {
	
	public static void main(String[] args) {
		
		System.out.println(isUniqueChars("Niraj"));
		
	}
	
	/*
	assuming ASSCI string and not unicode
	 */
	private static boolean ifUnique(String str) {
		if (str.length() > 128) return false;
		
		boolean chars[] = new boolean[128];
		
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (chars[val]) {
				return false;
			} else {
				chars[val] = true;
			}
		}
		
		return true;
	}
	
	/*
	using characters a-z
	 */
	static boolean isUniqueChars(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
	
}
