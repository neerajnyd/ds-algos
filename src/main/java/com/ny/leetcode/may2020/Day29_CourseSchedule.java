package com.ny.leetcode.may2020;

import java.util.*;

public class Day29_CourseSchedule {

    public static void main(String[] args) {

        int n = 3;
        int[][] prerequisites = {
                {0, 1}, {0, 2}, {1, 2}
        };

        System.out.println(canFinish(n, prerequisites));

    }

    public static boolean canFinish(int totalCourses, int[][] M) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : M) {
            int course = edge[0];
            int preRequisite = edge[1];
            graph.putIfAbsent(course, new HashSet<>());
            graph.get(course).add(preRequisite);
        }

        boolean[] visited = new boolean[totalCourses];
        boolean[] onStack = new boolean[totalCourses];
        for (int course = 0; course < totalCourses; course++) {
            if (!visited[course]) { // find one not visited and start from it
                if (dfs(graph, course, visited, onStack))
                    return false;
            }
        }

        return true;
    }

    private static boolean dfs(Map<Integer, Set<Integer>> graph, int course, boolean[] visited, boolean[] onStack) {
        onStack[course] = true; // mark course on the stack of a post-order traversal
        for (int preRequisite : graph.getOrDefault(course, new HashSet<>())) {
            if (onStack[preRequisite]) // one of the dependency is still not popped from the stack
                return true;
            if (!visited[preRequisite] && dfs(graph, preRequisite, visited, onStack))
                return true;
        }
        visited[course] = true; // can also be placed before visiting children, so place is not important
        onStack[course] = false; // making DFS a post-order traversal: popping course when all its children are done
        return false;
    }

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = generateDirectedGraph(prerequisites);

        int i = 0;
        boolean[] V = new boolean[numCourses];
        Deque<Integer> stack = new LinkedList<>();
        stack.offerFirst(i);

        while (!stack.isEmpty()) {
            int popped = stack.pollFirst();
            if (V[popped]) return false;

            V[popped] = true;
            if (graph.containsKey(popped)) {
                for (Integer neighbor : graph.get(popped)) {
                    stack.offerFirst(neighbor);
                }
            }
        }

        return true;
    }

    private static Map<Integer, List<Integer>> generateDirectedGraph(int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int after = prerequisite[0];
            int before = prerequisite[1];

            List<Integer> neighborsOfB = graph.getOrDefault(before, new ArrayList<>());

            neighborsOfB.add(after);
            graph.put(before, neighborsOfB);
        }
        return graph;
    }

}
