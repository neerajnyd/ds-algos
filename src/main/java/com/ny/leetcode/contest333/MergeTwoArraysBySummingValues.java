package com.ny.leetcode.contest333;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoArraysBySummingValues {

    public static void main(String[] args) {
        int[][] nums1 = {{2, 4}, {3, 6}, {5, 5}}, nums2 = {{1, 3}, {4, 3}};

        System.out.println(Arrays.deepToString(mergeArrays(nums1, nums2)));
    }


    private static int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int i = 0, j = 0;
        List<int[]> result = new ArrayList<>();
        while (i != n1 && j != n2) {

            int[] numss1 = nums1[i];
            int[] numss2 = nums2[j];

            if (numss1[0] < numss2[0]) {
                result.add(numss1);
                i++;
            } else if (numss1[0] > numss2[0]) {
                result.add(numss2);
                j++;
            } else { //equal
                numss1[1] = numss1[1] + numss2[1];
                result.add(numss1);
                i++;
                j++;
            }
        }

        if (i < n1) {
            for (int k = i; k < n1; k++) {
                result.add(nums1[k]);
            }
        }
        if (j < n2) {
            for (int k = j; k < n2; k++) {
                result.add(nums2[k]);
            }
        }

        int[][] R = new int[result.size()][];
        for (int k = 0; k < result.size(); k++) {
            R[k] = result.get(k);
        }
        return R;
    }

}
