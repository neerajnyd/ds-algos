package com.ny.leetcode;

import com.ny.leetcode.domain.TreeNode;

public class BT_MaximumPathSum {
    int maxValueFinalAnswer;

    public int maxPathSum(TreeNode root) {
        maxValueFinalAnswer = Integer.MIN_VALUE;
        postOrderTreeTraversalToUpdateMaxValueWithSubtreeSums(root);
        return maxValueFinalAnswer;
    }

    private int postOrderTreeTraversalToUpdateMaxValueWithSubtreeSums(TreeNode currentNode) {
        if (currentNode == null) return 0;
        int leftSumOnly = Math.max(
                0,
                postOrderTreeTraversalToUpdateMaxValueWithSubtreeSums(currentNode.left)
        );
        int rightSumOnly = Math.max(
                0,
                postOrderTreeTraversalToUpdateMaxValueWithSubtreeSums(currentNode.right)
        );
        int subTreeSum = leftSumOnly + rightSumOnly + currentNode.val;
        maxValueFinalAnswer = Math.max(
                maxValueFinalAnswer, subTreeSum
        );
        return Math.max(leftSumOnly, rightSumOnly) + currentNode.val;
    }
}
