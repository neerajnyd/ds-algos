package com.ny.leetcode;

import java.util.*;

public class ZigzagTraversalBinaryTree {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zigzag = false;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int           size  = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (zigzag) {
                    level.add(0, node.val);
                } else {
                    level.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
            zigzag = !zigzag;
        }
        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
