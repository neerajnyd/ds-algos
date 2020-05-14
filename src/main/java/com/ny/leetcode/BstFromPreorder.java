package com.ny.leetcode;

public class BstFromPreorder {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static void main(String[] args) {
        int[] preorder = {
                8,5,1,7,10,12
        };

        final TreeNode rootTreeNode = bstFromPreorder(preorder);
        System.out.println(rootTreeNode);
    }

    private static int i = 0;
    public static TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    private static TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }
}
