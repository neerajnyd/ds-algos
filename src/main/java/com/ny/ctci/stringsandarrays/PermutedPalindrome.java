package com.ny.ctci.stringsandarrays;

public class PermutedPalindrome {
	
	public static void main(String[] args) {
		System.out.println(checIfPermutedPalindrome("ggo"));
	}
	
	private static boolean checIfPermutedPalindrome(String str) {
		
		int[] table = buildCharacterFrequencyTable(str);
		
		return checkMaxOneOdd(table);
	}
	
	private static int[] buildCharacterFrequencyTable(String str) {
		
		int table[] = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		
		for (char c : str.toCharArray()) {
			int value = getCharValue(c);
			if (value != -1) {
				table[value]++;
			}
			
		}
		return table;
	}
	
	private static int getCharValue(char c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int value = Character.getNumericValue(c);
		if (value >= a && value <= z) {
			return value - a;
		}
		return -1;
	}
	
	
	private static boolean checkMaxOneOdd(int[] table) {
		int odds = 0;
		for (int i : table) {
			if (i % 2 == 1) {
				if (odds > 1) {
					return false;
				}
				odds++;
			}
		}
		return true;
		
	}
	
}
