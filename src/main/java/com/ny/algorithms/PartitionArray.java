package com.ny.algorithms;

public class PartitionArray {

    public static void main(String[] args) {
        int[] nums = {12, 3, 8, 6, 5, 10, 11, 1, 4};
        int k = 7;
        final int partitionedAt = partitionArray(nums, k);
        System.out.println("Partitioned at " + partitionedAt);
        for (int x : nums) {
            System.out.print(x + " ");
        }
    }

    public static int partitionArray(int[] nums, int k) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right)
            if (nums[left] > k)
                swap(nums, left, right--);
            else
                left++;
        return left;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
