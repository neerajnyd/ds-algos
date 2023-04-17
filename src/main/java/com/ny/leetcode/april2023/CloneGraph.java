package com.ny.leetcode.april2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public Node cloneGraph(Node node) {

        if (node == null) return null;

        return cloneGraphHelper(node, new HashMap<>());
    }

    private Node cloneGraphHelper(Node node, Map<Integer, Node> clonedNodes) {

        if (clonedNodes.containsKey(node.val)) return clonedNodes.get(node.val);

        Node clonedNode = new Node(node.val);
        clonedNodes.put(clonedNode.val, clonedNode);

        for (Node n : node.neighbors)
            clonedNode.neighbors.add(cloneGraphHelper(n, clonedNodes));

        return clonedNode;
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

}
