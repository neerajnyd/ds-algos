package com.ny.leetcode.contestbiweekly102;

import com.ny.leetcode.domain.TreeNode;

import java.util.*;

public class BinaryTreeCousins {

    /*
    Given the root of a binary tree, replace the value of each node in the tree with the sum of all its cousins' values.
    Two nodes of a binary tree are cousins if they have the same depth with different parents.
    Returns the root of the modified tree.
    Note that the depth of a node is the number of edges in the path from the root node to it.
     */
    public TreeNode replaceValueInTree(TreeNode root) {

        List<Level> levels = new ArrayList<>();
        levelOrderHelper(levels, Collections.singletonList(root));

        replaceValues(levels);
        return root;
    }

    private void replaceValues(List<Level> levels) {
        for (int j = 0; j < levels.size(); j++) {
            Level level = levels.get(j);
            List<TreeNode> nodes = level.nodes;
            if (j == 0) nodes.get(0).val = 0;
            for (int i = 0; i < nodes.size() - 1; i += 2) {
                TreeNode left = nodes.get(i);
                TreeNode right = nodes.get(i + 1);
                int val = level.sum - (getVal(left) + getVal(right));
                if (left != null) left.val = val;
                if (right != null) right.val = val;
            }
        }
    }

    private int getVal(TreeNode node) {
        return node != null ? node.val : 0;
    }

    private void levelOrderHelper(List<Level> levels, List<TreeNode> sameLevelNodes) {

        List<TreeNode> nextSameLevelNodes = new ArrayList<>();
        Level level = new Level();
        int sum = 0;
        boolean allNull = true;
        for (TreeNode node : sameLevelNodes) {
            level.nodes.add(node);
            sum += node.val;
            nextSameLevelNodes.add(node.left);
            nextSameLevelNodes.add(node.right);
            if (node.right != null) {
                allNull = false;
            }
            if (node.left != null) {
                allNull = false;
            }
        }
        levels.add(level);
        level.sum = sum;
        if (!allNull) {
            levelOrderHelper(levels, nextSameLevelNodes);
        }
    }

    private static class Level {
        private List<TreeNode> nodes;
        private int sum;

        public Level() {
            this.nodes = new ArrayList<>();
            this.sum = 0;
        }
    }

}