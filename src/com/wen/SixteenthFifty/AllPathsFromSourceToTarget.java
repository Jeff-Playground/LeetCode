package com.wen.SixteenthFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllPathsFromSourceToTarget {
    // DFS recursive
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result=new ArrayList<>();
        apstHelper(graph, 0, new ArrayList<>(), result);
        return result;
    }

    private void apstHelper(int[][] graph, int cur, List<Integer> path, List<List<Integer>> result){
        path.add(cur);
        if(cur==graph.length-1){
            List<Integer> copyPath=new ArrayList<>(path);
            result.add(copyPath);
        } else{
            for(int next: graph[cur]){
                apstHelper(graph, next, path, result);
            }
        }
        path.remove(path.size()-1);
    }

//    // DFS iterative with Stack
//    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//        List<List<Integer>> result=new ArrayList<>();
//        Stack<List<Integer>> stack=new Stack<>();
//        List<Integer> start=new ArrayList<>();
//        start.add(0);
//        stack.push(start);
//        int l=graph.length;
//        while(!stack.isEmpty()){
//            List<Integer> cur=stack.pop();
//            if(cur.get(cur.size()-1)==l-1){
//                result.add(cur);
//            } else{
//                for(int next: graph[cur.get(cur.size()-1)]){
//                    List<Integer> copyCur=new ArrayList<>(cur);
//                    copyCur.add(next);
//                    stack.push(copyCur);
//                }
//            }
//        }
//        return result;
//    }
}
