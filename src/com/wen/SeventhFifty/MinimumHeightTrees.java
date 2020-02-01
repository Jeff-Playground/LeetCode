package com.wen.SeventhFifty;

import java.util.*;

public class MinimumHeightTrees {
    // Find the nodes with inDegree==1 level by level and remove them from the all nodes set, the result will have no
    // more than 2 nodes, because otherwise it can be further reduced.
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 3) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            Set<Integer> s0 = tree.getOrDefault(edge[0], new HashSet<>());
            s0.add(edge[1]);
            tree.putIfAbsent(edge[0], s0);
            Set<Integer> s1 = tree.getOrDefault(edge[1], new HashSet<>());
            s1.add(edge[0]);
            tree.putIfAbsent(edge[1], s1);
        }
        Set<Integer> nodes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nodes.add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int node : tree.keySet()) {
            if (tree.get(node).size() == 1) {
                q.offer(node);
                nodes.remove(node);
            }
        }
        while (nodes.size() > 2 && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int nghbr : tree.get(cur)) {
                    tree.get(nghbr).remove(cur);
                    if (tree.get(nghbr).size() == 1) {
                        q.offer(nghbr);
                        nodes.remove(nghbr);
                    }
                }
            }
        }
        return new ArrayList(nodes);
    }
}
