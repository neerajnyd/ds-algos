package com.ny.leetcode.domain;


import java.util.Deque;
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
        StringJoiner s = new StringJoiner(",", "[", "]");
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(this);
        boolean allNulls;
        do {
            allNulls = true;
            int n = Q.size();
            StringJoiner thisLevel = new StringJoiner(",");
            for (int i = 0; i < n; i++) {
                TreeNode node = Q.poll();
                if (node == null) {
                    thisLevel.add("null");
                    continue;
                }
                thisLevel.add(String.valueOf(node.val));

                if (node.left != null) {
                    allNulls = false;
                }
                Q.offer(node.left); //so we can put string null for it later

                if (node.right != null) {
                    allNulls = false;
                }
                Q.offer(node.right);
            }
            s.add(thisLevel.toString());
        } while (!Q.isEmpty() && !allNulls);
        return s.toString();
    }

    public static void main(String[] args) {
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(7);
        TreeNode left1 = new TreeNode(5, left2, right2);
        TreeNode right3 = new TreeNode(12);
        TreeNode right1 = new TreeNode(10, null, right3);
        TreeNode root = new TreeNode(8, left1, right1);
//        System.out.println(root);

        TreeNode root1 = TreeNode.fromTestcase(new Integer[]{1, 2, 3, 4, 5, null, 7});
        System.out.println(root1);


    }

    public static TreeNode fromTestcase(Integer[] A) {

        TreeNode root = new TreeNode(A[0]);
        Deque<TreeNode> Q = new LinkedList<>();
        Q.offer(root);

        //[1,2,3,4,5,6,7,8,9,10,11,12,13,null,null,15]
        int i = 1; //0 has is the root node

        while (!Q.isEmpty()) {
            int n = Q.size();
            boolean nulls = true;
            for (int j = 0; j < n; j++) {
                TreeNode node = Q.removeFirst();
                if (i < A.length) {
                    Integer leftVal = A[i++];
                    if (leftVal != null) nulls = false;
                    TreeNode leftNode = leftVal != null ? new TreeNode(leftVal) : null;
                    node.left = leftNode;
                    if (i == A.length) return root;
                    Q.offer(leftNode);
                }
                if (i < A.length) {
                    Integer rightVal = A[i++];
                    if (rightVal != null) nulls = false;
                    TreeNode rightNode = rightVal != null ? new TreeNode(rightVal) : null;
                    node.right = rightNode;
                    if (i == A.length) return root;
                    Q.offer(rightNode);
                }
            }
            if (nulls) return root;

        }
        return root;

    }
}
