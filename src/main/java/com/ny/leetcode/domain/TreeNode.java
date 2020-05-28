package com.ny.leetcode.domain;


import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringJoiner sb = new StringJoiner(",", "[", "]");
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(this);
        boolean allNulls;
        do {
            allNulls = true;
            int n = Q.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = Q.poll();
                if (node == null) {
                    sb.add("null");
                    continue;
                }
                sb.add(String.valueOf(node.val));
                if (node.left != null) {
                    allNulls = false;
                }
                Q.offer(node.left);
                if (node.right != null) {
                    allNulls = false;
                }
                Q.offer(node.right);
            }

        } while (!Q.isEmpty() && !allNulls);
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(7);
        TreeNode left1 = new TreeNode(5, left2, right2);
        TreeNode right3 = new TreeNode(12);
        TreeNode right1 = new TreeNode(10, null, right3);
        TreeNode root = new TreeNode(8, left1, right1);
        System.out.println(root);

    }
}
