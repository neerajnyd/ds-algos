package com.ny.pramp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given a package with a weight limit limit and an array arr of item weights, implement a function getIndicesOfItemWeights that finds two items whose sum of weights equals the weight limit limit. Your function should return a pair [i, j] of the indices of the item weights, ordered such that i > j. If such a pair doesn’t exist, return an empty array.

Analyze the time and space complexities of your solution.

Example:

input:  arr = [4, 6, 10, 15, 16],  lim = 21

output: [3, 1] # since these are the indices of the
               # weights 6 and 15 whose sum equals to 21
 */
public class Two_MergingTwoPackages {

    public static void main(String[] args) {

        int[] R = getIndicesOfItemWeights(new int[] {
                4, 6, 10, 15, 16
        }, 23);

        System.out.println(Arrays.toString(R));

    }

    static int[] getIndicesOfItemWeights(int[] A, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int c = target - a;
            if (numToIndex.containsKey(c)) {
                return new int[]{i, numToIndex.get(c)};
            }
            numToIndex.put(a, i);
        }
        return new int[]{};
    }

}
