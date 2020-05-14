package com.ny.leetcode.curatedlistchallenge.day2;

import com.ny.leetcode.TreeNode;

/*
https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode node) {
        /*BST property
        node.val > left subtree node values (left is a BST)
        node.val < right subtree node values (right is a BSR)
                5
               / \
              1  6
                 / \
                4   7
            here 4 is on the right side of root and thus violates the property.

        */
        if(node == null) return true;

        return helper(node.left, Long.MIN_VALUE, node.val)
                && helper(node.right, node.val, Long.MAX_VALUE);

    }

    private boolean helper(TreeNode node, long minAllowed, long maxAllowed) {

        if(node == null) return true;
        long val = node.val;
        if(val <= minAllowed || val >= maxAllowed) return false;

        return helper(node.left, minAllowed, val)
                && helper(node.right, val, maxAllowed);

    }

}
