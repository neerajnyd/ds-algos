package com.ny.leetcode.curated.tree;

import com.ny.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBst {

    public int kthSmallest(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();
        inorder(root, list, k);
        return list.get(k - 1);
    }

    private void inorder(TreeNode node, List<Integer> list, int k) {
        if (list.size() == k) return;
        if (node != null) {
            inorder(node.left, list, k);
            list.add(node.val);
            inorder(node.right, list, k);
        }

    }

}
