package com.ny.gfg.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {

    public Node buildTree(String s) {
        if (s.length() == 0 || s.charAt(0) == 'N') {
            return null;
        }
        String[] values = s.split(" ");

        final Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            final Node currNode = queue.remove();
            final String leftValue = values[i++];
            if (!leftValue.equals("N")) {
                currNode.left = new Node(Integer.parseInt(leftValue));
                queue.add(currNode.left);
            }

            if (i >= values.length) break;

            final String rightValue = values[i++];
            if (!rightValue.equals("N")) {
                currNode.right = new Node(Integer.parseInt(rightValue));
                queue.add(currNode.right);
            }
        }
        return root;
    }

    static void printInorder(Node root) {
        if(root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    public void leftView(Node root) {
        if(root != null) {
            final Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node first = null;
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    if(first == null) {
                        first = queue.peek();
                        System.out.print(first.data + " ");
                    }
                    Node curr = queue.remove();
                    if (curr.left != null)
                        queue.add(curr.left);
                    if (curr.right != null)
                        queue.add(curr.right);
                }

            }
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

}
