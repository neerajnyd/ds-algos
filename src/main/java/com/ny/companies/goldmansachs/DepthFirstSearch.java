package com.ny.companies.goldmansachs;

import com.ny.model.GraphNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch {

    public static void main(String[] args) {

    }

    private static void dfs(GraphNode root) {

        //the stack to use for our depth first searching
        Stack<GraphNode> stack = new Stack<>();
        //so we don't process the already processed items again which can cause a cycle
        Set<GraphNode> seen = new HashSet<>();

        stack.add(root);

        //Pull a node out, process it (if not already processed), add its unseen children to the Stack
        while (!stack.isEmpty()) {
            GraphNode curr = stack.pop();

            if(!seen.contains(curr)) {
                seen.add(curr);
                System.out.println(curr); //PROCESS step - can be anything
            }

            for(GraphNode adjacent : curr.adjacent) {
                if(!seen.contains(adjacent)) {
                    stack.push(adjacent);
                }
            }
        }
    }


}
