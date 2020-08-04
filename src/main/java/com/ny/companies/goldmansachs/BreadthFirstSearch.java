package com.ny.companies.goldmansachs;

import com.ny.model.GraphNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {

    public static void main(String[] args) {

    }

    private static void bfs(GraphNode root) {
        //the queue to use for our breadth first searching
        Queue<GraphNode> queue = new LinkedList<>();
        //so we don't process the already processed items again which can cause a cycle
        Set<GraphNode> seen = new HashSet<>();

        queue.add(root);

        //Pull a node out, process it (if not already processed), add its unseen children to the Queue
        while (!queue.isEmpty()) {

            GraphNode curr = queue.poll();
            if(!seen.contains(curr)) {
                seen.add(curr);
                System.out.println(curr); //PROCESS step - can be anything
            }
            for(GraphNode node : curr.adjacent) {
                if(!seen.contains(node)) {
                    queue.add(node);
                }
            }
        }
    }

}
