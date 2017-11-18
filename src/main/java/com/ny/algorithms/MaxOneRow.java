package com.ny.algorithms;

public class MaxOneRow {
	
	public static void main(String[] args) {
		
		int[][] a = {
				{0, 1, 0, 1, 0, 1},
				{1, 0, 0, 1, 1, 0},
				{0, 0, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1},
				{0, 0, 0, 0, 0, 1}
		};
		
		printIndexOfRowWithMaxOnes(a);
		
	}
	
	private static void printIndexOfRowWithMaxOnes(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		
		int rowWithMaxOne = 0;
		int maxOnes = 0;
		for (int i = 0; i < a.length; i++) {
			int noOfOnesInRow = 0;
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 1) {
					noOfOnesInRow += 1;
				}
			}
			if (noOfOnesInRow > maxOnes) {
				maxOnes = noOfOnesInRow;
				rowWithMaxOne = i;
			}
		}
		System.out.println(maxOnes);
		System.out.println(rowWithMaxOne);
		
	}
	
}
