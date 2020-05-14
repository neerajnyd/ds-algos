package com.ny.leetcode;

import java.util.*;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        final Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        final Set<Node> visitedNodes = new HashSet<>();
        while (!queue.isEmpty()) {
            final Node polledNode = queue.poll();
            final List<Node> neighbors = polledNode.neighbors;
            for(Node n : neighbors) {
                queue.add(n);
            }

        }

        return node;
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
