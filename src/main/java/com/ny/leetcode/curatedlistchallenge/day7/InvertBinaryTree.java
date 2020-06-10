package com.ny.leetcode.curatedlistchallenge.day7;

import com.ny.leetcode.domain.TreeNode;

/*
https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {

        if(root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }



    public static void main(String[] args) {

    }
}
