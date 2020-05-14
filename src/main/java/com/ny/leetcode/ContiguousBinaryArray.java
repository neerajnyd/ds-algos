package com.ny.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContiguousBinaryArray {

    public static void main(String[] args) {

        int[][] A = {
                {0,0,1,0,0,0,1,1}
        };
        for (int[] nums : A)
            System.out.println(findMaxLength(nums
            ));
    }

    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0, count = 0;
        Map<Integer, Integer> countToFirstIndex = new HashMap<>();
        countToFirstIndex.put(0, -1); /* count of 0 before we start traversing */
        for (int i = 0; i < n; i++) {
            count += nums[i] == 0 ? -1 : 1;
            if(countToFirstIndex.containsKey(count)) { /* if this count was already present */
                Integer previousIndex = countToFirstIndex.get(count); /* then we get the previous index */
                int distance = i - previousIndex; /* and find the distance with the current index */
                maxLen = Math.max(maxLen, distance); /* that distance is a candidate for maxLen, since count same means equal 0's and 1's in that distance */
            } else {
                countToFirstIndex.put(count, i);
            }
        }
        return maxLen;
    }

    public static int findMaxLength3(int[] nums) {
        int n = nums.length;
        int[] countArray = new int[2 * n + 1];
        Arrays.fill(countArray, -2);
        countArray[n] = -1;
        int maxlen = 0, count = 0;
        for (int i = 0; i < n; i++) {
            //0,0,1,0,0,0,1,1
            count += (nums[i] == 0 ? -1 : 1);
            int positionInCountArray = count + n;
            if (countArray[positionInCountArray] >= -1) {
                int sameCountPositionDif = i - countArray[positionInCountArray];
                maxlen = Math.max(maxlen, sameCountPositionDif);
            } else countArray[positionInCountArray] = i;
        }
        return maxlen;
    }

    private static int findMaxLength2(int[] nums) {
        int globalMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int zeros = 0, ones = 0;
            if (nums[i] == 0) zeros++;
            else ones++;
            int max = 0;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == 0) zeros++;
                else ones++;
                if (ones == zeros) max = Math.max(max, zeros * 2);
            }
            globalMax = Math.max(max, globalMax);
        }
        return globalMax;
    }



}
