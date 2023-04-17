package com.ny.leetcode.march2023;

import com.ny.leetcode.domain.TreeNode;

import java.util.*;

public class ConstructBtFromInorderPostorder {

    public static void main(String[] args) {
        ConstructBtFromInorderPostorder m = new ConstructBtFromInorderPostorder();
        System.out.println(m.buildTree(new int[]{
                9, 3, 15, 20, 7
        }, new int[]{
                9, 15, 7, 20, 3
        }));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) map.put(inorder[i], i);

        return build(0, n - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode build(int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inorderMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        int inIndex = inorderMap.get(rootVal);
        int postEndLeft = postStart + (inIndex - 1) - inStart;
        TreeNode left = build(
                inStart,
                inIndex - 1,
                postorder,

                postStart,
                postEndLeft,

                inorderMap
        );

        TreeNode right = build(
                inIndex + 1,
                inEnd,
                postorder,

                postEndLeft + 1,
                postEnd - 1,

                inorderMap
        );
        return new TreeNode(rootVal, left, right);
    }

}
