package com.ny.leetcode.march2023;

import com.ny.leetcode.domain.TreeNode;

public class SumRootToLeafNumbers {

    public static void main(String[] args) {

        SumRootToLeafNumbers c = new SumRootToLeafNumbers();

        TreeNode node = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        System.out.println(c.sumNumbers(node));

    }

    public int sumNumbers(TreeNode root) {

        return helper(root, 0);
    }

    private int helper(TreeNode node, int currSum) {

        if (node == null) return 0;

        currSum = 10 * currSum + node.val;

        if (node.left == null && node.right == null) return currSum;

        int leftSum = helper(node.left, currSum); //495
        int rightSum = helper(node.right, currSum); //491
        return leftSum + rightSum;
    }

}
