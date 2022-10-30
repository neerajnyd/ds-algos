package com.ny.leetcode.curated.array;

public class ProductExceptSelf {

    public static void main(String[] args) {

//        int[] nums = {1,2,3,4,5};
        int[] nums = {-1, 1, 0, -3, 3};
        int[] res = productExceptSelf(nums);
        for (int i : res) {
            System.out.print(i + " ");
        }

    }

    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        //cumulative left value
        int cumulativeLeft = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                int leftValue = nums[i - 1];
                cumulativeLeft *= leftValue;
            }
            res[i] = cumulativeLeft;
        }
        //Calculate right and the product from the end of the array
        int cumulativeRight = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                int rightValue = nums[i + 1];
                cumulativeRight *= rightValue;
            }
            res[i] *= cumulativeRight;
        }
        return res;
    }


}
