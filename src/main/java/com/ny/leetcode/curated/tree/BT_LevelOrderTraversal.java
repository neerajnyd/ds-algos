package com.ny.leetcode.curated.tree;

import com.ny.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BT_LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return Collections.emptyList();

        List<List<Integer>> levels = new ArrayList<>();
        levelOrderHelper(levels, Collections.singletonList(root));
        return levels;
    }

    private void levelOrderHelper(List<List<Integer>> levels, List<TreeNode> sameLevelNodes) {

        List<TreeNode> nextSameLevelNodes = new ArrayList<>();
        List<Integer> level = new ArrayList<>();

        for (TreeNode node : sameLevelNodes) {
            level.add(node.val);

            if (node.left != null) nextSameLevelNodes.add(node.left);
            if (node.right != null) nextSameLevelNodes.add(node.right);

        }
        levels.add(level);
        if (!nextSameLevelNodes.isEmpty()) {
            levelOrderHelper(levels, nextSameLevelNodes);
        }
    }
}
