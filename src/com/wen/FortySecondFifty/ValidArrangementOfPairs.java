package com.wen.FortySecondFifty;

import java.util.*;

public class ValidArrangementOfPairs {
    // DFS to find eulerian path with a Stack
    public int[][] validArrangement(int[][] pairs) {
        int l=pairs.length;
        Map<Integer, Queue<int[]>> graph=new HashMap<>();
        Map<Integer, Integer> inDegree=new HashMap<>();
        for(int i=0; i<l; i++){
            int[] p=pairs[i];
            graph.putIfAbsent(p[0], new LinkedList<>());
            graph.get(p[0]).offer(new int[]{p[1], i});
            inDegree.put(p[0], inDegree.getOrDefault(p[0],0)-1);
            inDegree.put(p[1], inDegree.getOrDefault(p[1],0)+1);
        }
        int start=-1;
        for(int node: inDegree.keySet()){
            if(inDegree.get(node)%2!=0 && inDegree.get(node)<0){
                start=node;
                break;
            }
        }
        if(start==-1){
            start=pairs[0][0];
        }
        int[][] result=new int[l][2];
        int idx=l-1;
        Stack<int[]> stack=new Stack<>();
        stack.push(new int[]{start, -1});
        while(!stack.isEmpty()){
            int[] cur=stack.peek();
            int node=cur[0], edgeIdx=cur[1];
            if(graph.containsKey(node) && !graph.get(node).isEmpty()){
                int[] next=graph.get(node).poll();
                stack.push(next);
            } else{
                if(edgeIdx!=-1){
                    result[idx--]=pairs[edgeIdx];
                }
                stack.pop();
            }
        }
        return result;
    }

//    // Eulerian path, note how the graph is built using Queue, if there's a requirement on the ordering of the path, then
//    // it should use PriorityQueue, but the point is using such a data structure rather than Map or Set brings the flexibility
//    // of removing visited edges
//    public static int[][] validArrangement(int[][] pairs) {
//        int l=pairs.length;
//        Map<Integer, Integer> inDegree=new HashMap<>();
//        Map<Integer, Queue<int[]>> graph=new HashMap<>();
//        for(int i=0; i<l; i++){
//            int[] p=pairs[i];
//            inDegree.put(p[0], inDegree.getOrDefault(p[0], 0)-1);
//            inDegree.put(p[1], inDegree.getOrDefault(p[1], 0)+1);
//            graph.putIfAbsent(p[0], new LinkedList<>());
//            graph.get(p[0]).offer(new int[]{p[1], i});
//        }
//        int start=-1;
//        for(int node: inDegree.keySet()){
//            if(inDegree.get(node)%2!=0 && inDegree.get(node)<0){
//                start=node;
//                break;
//            }
//        }
//        if(start==-1){
//            start=pairs[0][0];
//        }
//        List<Integer> idx=new ArrayList<>();
//        vaHelper(start, -1, graph, idx);
//        int[][] result=new int[l][2];
//        for(int i=l-1; i>=0; i--){
//            int index=idx.get(i);
//            result[l-1-i]=pairs[index];
//        }
//        return result;
//    }
//
//    private static void vaHelper(int start, int edge, Map<Integer, Queue<int[]>> graph, List<Integer> idx){
//        if(graph.containsKey(start) && !graph.get(start).isEmpty()){
//            while(!graph.get(start).isEmpty()){
//                int[] next=graph.get(start).poll();
//                vaHelper(next[0], next[1], graph, idx);
//            }
//        }
//        if(edge!=-1){
//            idx.add(edge);
//        }
//    }
}
