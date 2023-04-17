package com.ny.leetcode.curated.tree;

import com.ny.leetcode.domain.TreeNode;

/*
https://leetcode.com/problems/subtree-of-another-tree/
 */
public class SubTree {

    public boolean isSubtree(TreeNode p, TreeNode q) {

        if (p == null) return false;

        if (isSameTree(p, q)) return true;

        return isSubtree(p.left, q) || isSubtree(p.right, q);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }

}
