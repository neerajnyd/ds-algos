package com.ny.leetcode.contestbiweekly98;

import com.ny.leetcode.ArrayUtil;

import java.util.Arrays;

public class SmallestNumUsingTwoDigitArays {

    public static void main(String[] args) {

        int[] one = ArrayUtil.read("[3,5,2,6]");
        int[] two = ArrayUtil.read("[3,1,7]");
        System.out.println(minNumber(one, two));

    }

    public static int minNumber(int[] nums1, int[] nums2) {

        int min = 10;

        for (int a : nums1) {
            for (int b : nums2) {
                if (a == b) {
                    min = Math.min(min, a);
                }
            }
        }
        if (min != 10) return min;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int one = nums1[0];
        int two = nums2[0];

        return one < two ? Integer.parseInt(one + "" + two) : Integer.parseInt(two + "" + one);
    }

}
