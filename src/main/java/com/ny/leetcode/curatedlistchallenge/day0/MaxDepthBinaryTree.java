package com.ny.leetcode.curatedlistchallenge.day0;

import com.ny.leetcode.domain.TreeNode;

/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
