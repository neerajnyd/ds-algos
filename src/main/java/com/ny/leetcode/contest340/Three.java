package com.ny.leetcode.contest340;

import com.ny.leetcode.ArrayUtil;

import java.util.*;

public class Three {

    public static void main(String[] args) {
        Three o = new Three();
        /*int[] arr = ArrayUtil.read("[10,1,2,7,1,3]");
        System.out.println(o.minimizeMax(arr, 2));
        int[] arr2 = ArrayUtil.read("[4,2,1,2]");
        System.out.println(o.minimizeMax(arr2, 1));*/
        int[] arr3 = ArrayUtil.read("[0,5,3,4]");
        System.out.println(o.minimizeMax(arr3, 0));
    }

    public int minimizeMax(int[] nums, int p) {

        List<Integer> mins = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int minDiff = Integer.MAX_VALUE;
            int j = i + 1;
            int k = j;
            while (j < nums.length) {
                if (!seen.contains(j)) {
                    int diff = Math.abs(nums[i] - nums[j++]);
                    if (diff < minDiff) {
                        minDiff = diff;
                        k = j;
                    }
                }
            }
            mins.add(minDiff);
            seen.add(k);
        }
        Collections.sort(mins);
        return mins.get(p - 1);
    }


}
