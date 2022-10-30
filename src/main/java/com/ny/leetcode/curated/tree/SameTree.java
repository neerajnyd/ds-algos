package com.ny.leetcode.curated.tree;

import com.ny.leetcode.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/same-tree/
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false; //(p == null & q != null) || (p != null & q == null)

        return p.val == q.val &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }

    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {

            TreeNode p1 = queue.poll();
            TreeNode q1 = queue.poll();

            if (p1 == null && q1 == null) {
                continue; //sameTree check continues
            }
            if (p1 == null || q1 == null) {
                return false;
            }
            if (p1.val != q1.val) {
                return false;
            }
            queue.offer(p1.left);
            queue.offer(q1.left);

            queue.offer(p1.right);
            queue.offer(q1.right);

        }
        return true;
    }

}
