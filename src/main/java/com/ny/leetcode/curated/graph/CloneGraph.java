package com.ny.leetcode.curated.graph;

import java.util.*;

public class CloneGraph {

    public Node cloneGraph(Node node) {

        if (node == null) return null;

        if (node.neighbors.isEmpty()) return new Node(node.val);
        Map<Integer, Node> map = new HashMap<>();
        return cloneHelper(node, map);
    }

    private Node cloneHelper(Node node, Map<Integer, Node> existingNodes) {

        if (existingNodes.containsKey(node.val)) return existingNodes.get(node.val);

        ArrayList<Node> neighbors = new ArrayList<>();
        Node cloneNode = new Node(node.val, neighbors);
        existingNodes.put(node.val, cloneNode);

        for (Node n : node.neighbors) {

            Node cloneN = cloneHelper(n, existingNodes);
            neighbors.add(cloneN);

        }
        return cloneNode;

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
