package com.ny.leetcode.march2023;

import com.ny.leetcode.ArrayUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnreachablePairsInGraph {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/ny/leetcode/march2023/UnreachablePairsInGraph_input.txt");
        Charset charset = Charset.defaultCharset();
        String input = FileUtils.readFileToString(file, charset);
        UnreachablePairsInGraph c = new UnreachablePairsInGraph();
        System.out.println(c.countPairs(100000, ArrayUtil.read2D(input)));

    }

    public long countPairs(int n, int[][] edges) {
        /*
        connected components and their sizes
        then multiple each pair of the sizes to get the result
         */

        boolean[] visited = new boolean[n];

        Map<Integer, List<Integer>> adj = adjacencyMatrix(edges);
        long pairs = 0;
        long remainingNodes = n;
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                long sizeOfComponent = dfs(node, adj, visited);
                pairs += sizeOfComponent * (remainingNodes - sizeOfComponent);
                remainingNodes -= sizeOfComponent;
            }
        }
        return pairs;
    }

    private int dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited) {
        int count = 1;
        visited[node] = true;
        if (!adj.containsKey(node)) return count;

        for (Integer neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, adj, visited);
            }
        }
        return count;
    }

    private Map<Integer, List<Integer>> adjacencyMatrix(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            map.computeIfAbsent(a, key -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, key -> new ArrayList<>()).add(a);
        }
        return map;
    }
}
