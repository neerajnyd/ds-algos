package com.ny.leetcode.curatedlistchallenge.day6;

import com.ny.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBst {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inorder(root, k, inorder);
        return inorder.get(k-1);
    }

    private void inorder(TreeNode node, int k, List<Integer> list) {
        if(list.size() == k) return;

        if(node.left != null) inorder(node.left, k, list);
        list.add(node.val);
        if(node.right != null) inorder(node.right, k, list);
    }

}
