package com.wen.Airbnb;

import java.util.*;

public class NumberOfIntersectedRectangles {
	// BFS
	public static List<Integer> getMin(int[][] edges, int n) {
		List<Integer> result = new ArrayList<>();
		int[] inDegree = new int[n];
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int[] edge : edges) {
			graph.putIfAbsent(edge[0], new HashSet<>());
			if (!graph.get(edge[0]).contains(edge[1])) {
				inDegree[edge[1]]++;
				graph.get(edge[0]).add(edge[1]);
			}
		}
		int[] visited = new int[n];
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
				result.add(i);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			visited[cur] = 1;
			if (graph.get(cur) != null) {
				for (int next : graph.get(cur)) {
					if (visited[next] == 0) {
						visited[next] = 1;
						q.offer(next);
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				q.offer(i);
				result.add(i);
				while (!q.isEmpty()) {
					int cur = q.poll();
					visited[cur] = 1;
					for (int next : graph.get(cur)) {
						if (visited[next] == 0) {
							visited[next] = 1;
							q.offer(next);
						}
					}
				}
			}
		}
		return result;
	}
}
