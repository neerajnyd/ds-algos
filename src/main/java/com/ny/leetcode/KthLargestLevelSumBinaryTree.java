package com.ny.leetcode;

import com.ny.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KthLargestLevelSumBinaryTree {

    public static void main(String[] args) {
        KthLargestLevelSumBinaryTree tree = new KthLargestLevelSumBinaryTree();
        //411310,211244,111674
        TreeNode root = new TreeNode(411310, new TreeNode(211244), new TreeNode(111674));
        System.out.println(tree.kthLargestLevelSum(root, 3));

    }


    public long kthLargestLevelSum(TreeNode root, int k) {

        List<Long> levelSum = levelOrder(root);

        if (levelSum.size() >= k) return levelSum.get(k - 1);
        return -1;
    }

    public List<Long> levelOrder(TreeNode root) {

        List<List<Integer>> intsAtEachLevel = new ArrayList<>();
        levelOrderHelper(intsAtEachLevel, Collections.singletonList(root));

        return intsAtEachLevel.stream()
                .map(integers -> integers.stream().mapToLong(value -> value).sum())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private void levelOrderHelper(List<List<Integer>> intsAtEachLevel, List<TreeNode> sameLevelNodes) {

        List<TreeNode> nextSameLevelNodes = new ArrayList<>();
        List<Integer> level = new ArrayList<>();

        for (TreeNode node : sameLevelNodes) {
            level.add(node.val);

            if (node.left != null) nextSameLevelNodes.add(node.left);
            if (node.right != null) nextSameLevelNodes.add(node.right);

        }
        intsAtEachLevel.add(level);
        if (!nextSameLevelNodes.isEmpty()) {
            levelOrderHelper(intsAtEachLevel, nextSameLevelNodes);
        }
    }

}
