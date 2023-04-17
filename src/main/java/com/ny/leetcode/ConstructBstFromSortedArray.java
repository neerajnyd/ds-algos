package com.ny.leetcode;

import com.ny.leetcode.domain.TreeNode;

public class ConstructBstFromSortedArray {

    public static void main(String[] args) {

        ConstructBstFromSortedArray m = new ConstructBstFromSortedArray();
        System.out.println(m.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums, 0, nums.length - 1);

    }

    private TreeNode helper(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, lo, mid - 1);
        node.right = helper(nums, mid + 1, hi);
        return node;

    }

}
