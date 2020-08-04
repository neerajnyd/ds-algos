package com.ny.leetcode.curatedlistchallenge.day3;

import com.ny.leetcode.domain.TreeNode;

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
        return isValidBST(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode tree, long min, long max) {
        if (tree == null) return true;
        if (tree.val <= min || tree.val >= max) return false;
        return isValidBST(tree.left, min, tree.val) && isValidBST(tree.right, tree.val, max);
    }

}
