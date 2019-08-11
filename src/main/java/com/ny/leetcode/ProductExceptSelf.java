package com.ny.leetcode;

public class ProductExceptSelf {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};
        int[] res = productExceptSelf(nums);
        for (int i : res) {
            System.out.print(i + " ");
        }

    }

    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        //Calculate lefts and store in res array
        int left = 1;
        for (int i = 0; i < n; i++) {
            if(i > 0) {
                left = left * nums[i-1];
            }
            res[i] = left;
        }
        //Calculate right and the product from the end of the array
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if(i < n-1) {
                right = right * nums[i + 1];
            }
            res[i] *= right;
        }
        return res;
    }


}
