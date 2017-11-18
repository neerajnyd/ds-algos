package com.ny.util;

import java.util.Random;

public class Util {
	
	public static int[] getRandomNumberArray() {
		
		Random random = new Random(System.currentTimeMillis());
		int[] arr = new int[random.nextInt(50)];
		for (int i = 0; i < arr.length; i++) {
			random = new Random(System.nanoTime());
			arr[i] = random.nextInt(100);
		}
		return arr;
	}
	
}
