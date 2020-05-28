package com.ny.leetcode.may2020;

import java.util.HashMap;
import java.util.Map;

public class Day26_ContiguousArray {

    public static void main(String[] args) {

    }

    //TODO: something cleaner?
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

}
