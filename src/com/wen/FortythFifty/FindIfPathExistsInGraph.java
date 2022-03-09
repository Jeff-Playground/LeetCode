package com.wen.FortythFifty;

import java.util.*;

public class FindIfPathExistsInGraph {
    // BFS
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> graph=new HashMap<>();
        for(int[] e: edges){
            int x=e[0], y=e[1];
            graph.putIfAbsent(x, new HashSet<>());
            graph.putIfAbsent(y, new HashSet<>());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        q.offer(source);
        visited.add(source);
        while(!q.isEmpty()){
            int cur=q.poll();
            if(cur==destination){
                return true;
            }
            for(int next: graph.getOrDefault(cur, new HashSet<>())){
                if(!visited.contains(next)){
                    q.offer(next);
                    visited.add(next);
                }
            }
        }
        return false;
    }

//    // DFS
//    public boolean validPath(int n, int[][] edges, int source, int destination) {
//        Map<Integer, Set<Integer>> graph=new HashMap<>();
//        for(int[] e: edges){
//            int x=e[0], y=e[1];
//            graph.putIfAbsent(x, new HashSet<>());
//            graph.putIfAbsent(y, new HashSet<>());
//            graph.get(x).add(y);
//            graph.get(y).add(x);
//        }
//        return vpHelper(graph, new HashSet<>(), source, destination);
//    }
//
//    private boolean vpHelper(Map<Integer, Set<Integer>> graph, Set<Integer> visited, int cur, int dest){
//        if(cur==dest){
//            return true;
//        } else{
//            // Note here it only asks for whether the path exists, so no need to do backtracking, otherwise will TLE
//            // Backtracking is needed when we want to find the exact path(s)
//            visited.add(cur);
//            for(int next: graph.getOrDefault(cur, new HashSet<>())){
//                if(!visited.contains(next)){
//                    if(vpHelper(graph, visited, next, dest)){
//                        return true;
//                    }
//                }
//            }
//            return false;
//        }
//    }

//    // DFS2 iterative with Stack
//    public boolean validPath(int n, int[][] edges, int source, int destination) {
//        Map<Integer, Set<Integer>> graph=new HashMap<>();
//        for(int[] e: edges){
//            int x=e[0], y=e[1];
//            graph.putIfAbsent(x, new HashSet<>());
//            graph.putIfAbsent(y, new HashSet<>());
//            graph.get(x).add(y);
//            graph.get(y).add(x);
//        }
//        Stack<Integer> stack=new Stack<>();
//        Set<Integer> visited=new HashSet<>();
//        stack.push(source);
//        visited.add(source);
//        while(!stack.isEmpty()){
//            int cur=stack.pop();
//            if(cur==destination){
//                return true;
//            }
//            for(int next: graph.getOrDefault(cur, new HashSet<>())){
//                if(!visited.contains(next)){
//                    stack.push(next);
//                    visited.add(next);
//                }
//            }
//        }
//        return false;
//    }
}
