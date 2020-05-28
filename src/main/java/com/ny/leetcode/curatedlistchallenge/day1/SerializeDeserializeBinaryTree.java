package com.ny.leetcode.curatedlistchallenge.day1;

import com.ny.leetcode.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        /*
            1
           / \
          2   3
             / \
            4   5
        */
        boolean allNull;
        //Q -> null, null, null, null, null, null, null, null
        //sb -> 1,2, 3, null, null, 4, 5
        do {
            allNull = true;
            int n = Q.size(); //4
            for (int i = 0; i < n; i++) {
                TreeNode node = Q.poll(); //4
                if (node == null) {
                    sb.append("null").append(",");
                    Q.add(null);
                    Q.add(null);
                } else {
                    sb.append(node.val).append(",");
                    if (node.left != null) allNull = false;
                    Q.add(node.left);
                    if (node.right != null) allNull = false;
                    Q.add(node.right);
                }
            }
        } while (!Q.isEmpty() && !allNull);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //"1,2,3,null,null,4,5"
        //|0|1|2| 3  | 4  |5|6|
        if (data == null) return null;

        String[] nodes = data.split(",");
        String value = nodes[0];
        TreeNode root = new TreeNode(Integer.parseInt(value));

        if (nodes.length > 1)
            build(root, nodes, 0);

        //how do I do this iteratively?
        /*for (int i=1; i<nodes.length; i++) {
            String val = nodes[i];
            TreeNode node = new TreeNode(Integer.parseInt(val));

        }*/

        return root;
    }


    private void build(TreeNode node, String[] nodes, int i) {
        int leftAt = 2 * i + 1;

        if (leftAt < nodes.length) {

            String value = nodes[leftAt];
            if (value.equals("null")) return;

            int val = Integer.parseInt(value);

            TreeNode left = new TreeNode(val);
            node.left = left;
            build(left, nodes, leftAt);
        } else
            return;

        int rightAt = 2 * i + 2;

        if (rightAt < nodes.length) {

            String value = nodes[rightAt];
            if (value.equals("null")) return;

            int val = Integer.parseInt(value);

            TreeNode right = new TreeNode(val);
            node.right = right;
            build(right, nodes, rightAt);
        }
    }

}
