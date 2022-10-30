package com.ny.leetcode.curated.array;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(
                threeSum(nums)
        );
    }

    private static List<List<Integer>> threeSum(int[] A) {
        List<List<Integer>> R = new ArrayList<>();
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            /* the array is sorted, if the number is positive,
            no way there are elements up ahead that add to this number */
            if (A[i] > 0) break;
            /* we want unique triplets
            if the number was same as previous number, it will always create a duplicate triplet
            here both -1 will combine with 0 and 1 to form -1, 0, 1 <--- a duplicate triplet
            [-4, -1, -1, 0, 1, 2]
            */
            if (i > 0 && A[i] == A[i - 1]) continue;

            int j = i + 1, k = A.length - 1;

            while (j < k) {
                int sum = A[i] + A[j] + A[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    R.add(Arrays.asList(A[i], A[j], A[k]));
                    j++;
                    k--;
                    //we want unique triplets
                    while (j < k && A[j] == A[j - 1]) j++;
                    while (j < k && A[k] == A[k + 1]) k--;
                }
            }
        }
        return R;
    }

    private static List<List<Integer>> threeSum_Set(int[] A) {
        Set<List<Integer>> R = new HashSet<>();
        if (A.length == 0) return Collections.emptyList();

        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            int j = i + 1;
            int k = A.length - 1;
            while (j < k) {
                int sum = A[i] + A[j] + A[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else { //sum == 0
                    R.add(Arrays.asList(A[i], A[j], A[k]));
                    j++;
                    k--;
                }
            }
        }
        return new ArrayList<>(R);
    }

}
