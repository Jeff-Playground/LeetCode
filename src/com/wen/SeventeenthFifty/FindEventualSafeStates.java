package com.wen.SeventeenthFifty;

import java.util.*;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result=new ArrayList<>();
        Map<Integer, Set<Integer>> out=new HashMap<>();
        Map<Integer, Set<Integer>> in=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<graph.length; i++){
            if(graph[i]==null || graph[i].length==0){
                q.offer(i);
            }
            out.putIfAbsent(i, new HashSet<>());
            for(int j=0; j<graph[i].length; j++){
                in.putIfAbsent(graph[i][j], new HashSet<>());
                in.get(graph[i][j]).add(i);
                out.get(i).add(graph[i][j]);
            }
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            result.add(cur);
            if(in.get(cur)!=null){
                for(int inNode: in.get(cur)){
                    out.get(inNode).remove(cur);
                    if(out.get(inNode).isEmpty()){
                        q.offer(inNode);
                    }
                }
            }
        }
        Collections.sort(result);
        return result;
    }

//    // DFS
//    // Mark nodes as white(0, means not visited), gray(1, means in current route), black(2, means visited)
//    public static List<Integer> eventualSafeNodes(int[][] graph) {
//        List<Integer> result=new ArrayList<>();
//        int l=graph.length;
//        int[] color=new int[l];
//        for(int i=0; i<l; i++){
//            if(eventualSafeNodesDFS(graph, i, color)){
//                result.add(i);
//            }
//        }
//        return result;
//    }
//
//    private static boolean eventualSafeNodesDFS(int[][] graph, int cur, int[] color){
//        if(color[cur]>0){
//            return color[cur]==2;
//        }
//        color[cur]=1;
//        for(int node: graph[cur]){
//            if(color[node]==2){
//                continue;
//            }
//            if(color[node]==1 || !eventualSafeNodesDFS(graph, node, color)){
//                return false;
//            }
//        }
//        color[cur]=2;
//        return true;
//    }

//    // DFS and backtracking, will TLE!!!
//    public List<Integer> eventualSafeNodes(int[][] graph) {
//        Set<Integer> result=new HashSet<>();
//        int l=graph.length;
//        for(int i=0; i<l; i++){
//            result.add(i);
//        }
//        for(int i=0; i<l; i++){
//            if(result.contains(i)){
//                eventualSafeNodesDFS(graph, result, i, new HashSet<>());
//            }
//        }
//        return new ArrayList<>(result);
//    }
//
//    private void eventualSafeNodesDFS(int[][] graph, Set<Integer> result, int cur, Set<Integer> onRoute){
//        if(graph[cur]==null || graph[cur].length==0){
//            return;
//        } else{
//            if(onRoute.contains(cur)){
//                result.removeAll(onRoute);
//                return;
//            }
//            onRoute.add(cur);
//            for(int node: graph[cur]){
//                if(!result.contains(node)){
//                    result.removeAll(onRoute);
//                    return;
//                } else{
//                    eventualSafeNodesDFS(graph, result, node, onRoute);
//                }
//            }
//            onRoute.remove(cur);
//        }
//    }
}
