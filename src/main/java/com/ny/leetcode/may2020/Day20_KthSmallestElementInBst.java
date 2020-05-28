package com.ny.leetcode.may2020;

import com.ny.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Day20_KthSmallestElementInBst {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> R = inorder(root, new ArrayList<>());
        return R.get(k-1);
    }

    private List<Integer> inorder(TreeNode root, List<Integer> R) {

        if(root != null) {
            inorder(root.left, R);
            R.add(root.val);
            inorder(root.right, R);
        }
        return R;
    }

}
