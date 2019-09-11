package com.wen.Airbnb;

import java.util.*;

public class MinimumVerticesToTraverseDirectedGraph {
    public static void main(String args[]) {
        int[][] edges = {{2,9},{3,3},{3,5},{3,7},{4,8},{5,8},{6,6},{7,4},{8,7},{9,3},{9,6}};
        List<Integer> result = getMin(edges, 10);
        for (int num : result) {
            System.out.println(num);
        }
    }

    // BFS
	public static List<Integer> getMin(int[][] edges, int n) {
	    List<Integer> result = new ArrayList<>();
	    int[] inDegree=new int[n];
	    Map<Integer, Set<Integer>> graph=new HashMap<>();
	    for(int[] edge: edges) {
	    	graph.putIfAbsent(edge[0], new HashSet<>());
	    	if(!graph.get(edge[0]).contains(edge[1])) {
	    		inDegree[edge[1]]++;
	    		graph.get(edge[0]).add(edge[1]);
	    	}
	    }
	    int[] visited=new int[n];
	    Queue<Integer> q=new LinkedList<>();
	    for(int i=0; i<n; i++) {
	    	if(inDegree[i]==0) {
	    		q.offer(i);
	    		result.add(i);
	    	}
	    }
	    while(!q.isEmpty()) {
	    	int cur=q.poll();
	    	visited[cur]=1;
	    	if(graph.get(cur)!=null) {
	        	for(int next: graph.get(cur)) {
	        		if(visited[next]==0) {
	        			visited[next]=1;
	        			q.offer(next);
	        		}
	        	}
	    	}
	    }
	    for(int i=0; i<n; i++) {
	    	if(visited[i]==0) {
	    		q.offer(i);
	    		result.add(i);
		        while(!q.isEmpty()) {
		        	int cur=q.poll();
		        	visited[cur]=1;
		        	for(int next: graph.get(cur)) {
		        		if(visited[next]==0) {
		        			visited[next]=1;
		        			q.offer(next);
		        		}
		        	}
		        }
	    	}
	    }
	    return result;
	}

//    // DFS
//    public static List<Integer> getMin(int[][] edges, int n) {
//        List<Integer> result = new ArrayList<>();
//        int[] inDegree=new int[n];
//        Map<Integer, Set<Integer>> graph=new HashMap<>();
//        for(int[] edge: edges) {
//            graph.putIfAbsent(edge[0], new HashSet<>());
//            if(!graph.get(edge[0]).contains(edge[1])) {
//                inDegree[edge[1]]++;
//                graph.get(edge[0]).add(edge[1]);
//            }
//        }
//        int[] visited=new int[n];
//        for (int i = 0; i < n; i++) {
//            if (inDegree[i] == 0) {
//                result.add(i);
//                dfs(i, graph, visited);
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            if (visited[i]==0) {
//                result.add(i);
//                dfs(i, graph, visited);
//            }
//        }
//        return result;
//    }
//
//    private static void dfs(int crt, Map<Integer, List<Integer>> map, int[] visited) {
//        visited[crt] = 1;
//        if (map.containsKey(crt)) {
//            for (int next : map.get(crt)) {
//                if (visited[next]==0) {
//                    continue;
//                }
//                dfs(next, map, visited);
//            }
//        }
//    }
}
