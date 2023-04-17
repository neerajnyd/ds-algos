package com.ny.leetcode.curated.tree;

import com.ny.leetcode.domain.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

essentially, we want to return the same TreeNode from deserialize as we received in input of serialize

 */
public class SerializeDeserializeBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(
                        3,
                        new TreeNode(4),
                        new TreeNode(5)
                )
        );

        LevelOrder levelOrder = new LevelOrder();
        System.out.println(
                levelOrder.serialize(root)
        );

    }

    private static class PreOrder {

        public String serialize(TreeNode root) {
            return buildString(root, new StringBuilder()).toString();
        }

        private StringBuilder buildString(TreeNode node, StringBuilder sb) {
            if (node == null) {
                return sb.append("#").append(",");
            }
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right, sb);
            return sb;
        }

        public TreeNode deserialize(String data) {
            return buildTree(new LinkedList<>(Arrays.asList(data.split(","))));
        }

        private TreeNode buildTree(Deque<String> nodes) {
            String val = nodes.remove();
            if ("#".equals(val)) return null;

            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }

    }

    private static class LevelOrder {

        // Encodes a tree to a single string using Level Order traversal
        public String serialize(TreeNode root) {

            if (root == null) {
                return null;
            }

            StringBuilder sb = new StringBuilder();

            Queue<TreeNode> Q = new LinkedList<>();
            Q.offer(root);

            boolean allNulls;
            do {
                allNulls = true;

                int n = Q.size();

                for (int i = 0; i < n; i++) {
                    TreeNode node = Q.poll();

                    if (node == null) {
                        sb.append("#").append(",");
                        Q.add(null);
                        Q.add(null);
                    } else {
                        sb.append(node.val).append(",");
                        Q.offer(node.left);
                        Q.offer(node.right);
                        if (node.left != null || node.right != null) {
                            allNulls = false;
                        }
                    }
                }
            } while (!Q.isEmpty() && !allNulls);

            return sb.substring(0, sb.length() - 1);
        }

        // Decodes your encoded data to tree by reading the level order traversed data
        public TreeNode deserialize(String data) {
            if (data == null) {
                return null;
            }

            String[] nodes = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

            build(root, nodes, 0);

            return root;
        }

        private void build(TreeNode p, String[] nodes, int ind) {
            int leftInd = 2 * ind + 1;

            if (leftInd < nodes.length && !nodes[leftInd].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[leftInd]));
                p.left = left;
                build(left, nodes, leftInd);
            }

            int rightInd = 2 * ind + 2;

            if (rightInd < nodes.length && !nodes[rightInd].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[rightInd]));
                p.right = right;
                build(right, nodes, rightInd);
            }
        }

    }

}

