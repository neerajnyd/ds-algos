package com.ny.leetcode.curated.array;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] H = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(H));
    }

    private static int maxArea(int[] A) {

        int max = 0;
        int lo = 0, hi = A.length - 1;

        while (lo < hi) {
            int height = Math.min(A[lo], A[hi]);
            int width = hi - lo;
            int area = height * width;

            max = Math.max(area, max);

            if (A[lo] > A[hi]) {
                hi--;
            } else {
                lo++;
            }
        }
        return max;
    }

}
