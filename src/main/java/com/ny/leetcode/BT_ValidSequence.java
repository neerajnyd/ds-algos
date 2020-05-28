package com.ny.leetcode;

import com.ny.leetcode.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BT_ValidSequence {


    public boolean isValidSequence(TreeNode root, int[] A) {
        return isValidSequenceHelper(root, A, 0);
    }

    private boolean isValidSequenceHelper(TreeNode node, int[] A, int i) {
        if (node == null || i == A.length || node.val != A[i]) return false;
        if (node.left == null && node.right == null && i == A.length - 1) return true;
        return isValidSequenceHelper(node.left, A, i + 1) ||
                isValidSequenceHelper(node.right, A, i + 1);
    }

    /*
    Works only for unique values
     */
    public boolean isValidSequenceIterative(TreeNode root, int[] A) {

        int n = A.length;
        if ((n == 0 && root != null) || (n != 0 && root == null)) return false;
        if (root == null /*&& n == 0*/) return true;

        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        int i = 0;
        TreeNode x;
        do {
            x = Q.poll();
            if (x.val == A[i]) {
                if (x.left != null) Q.offer(x.left);
                if (x.right != null) Q.offer(x.right);
                i++;
            } else {

            }

        } while (!Q.isEmpty() && i < n);

        return x.left == null && x.right == null && i == n;

    }

}
