package com.ny.leetcode.contest340;

import com.ny.leetcode.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Two {

    public static void main(String[] args) {
        Two o = new Two();
        System.out.println(Arrays.toString(o.distance(ArrayUtil.read("[1,3,1,1,2]"))));
        System.out.println(Arrays.toString(o.distance(ArrayUtil.read("[0,5,3]"))));
    }

    public long[] distance(int[] nums) {

        long[] result = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            long sum = 0;

            for (int j = 0; j < nums.length; j++) {
                if(i==j) continue;

                if(nums[i] == nums[j]) {
                    sum += Math.abs(j - i);
                }
            }

            result[i] = sum;
        }
        return result;
    }
}
