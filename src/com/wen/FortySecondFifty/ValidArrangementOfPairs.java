package com.wen.FortySecondFifty;

import java.util.*;

public class ValidArrangementOfPairs {
//    // DFS to find eulerian path with a Stack
//    public int[][] validArrangement(int[][] pairs) {
//        Map<Integer, Queue<Integer>> graph=new HashMap<>();
//        Map<Integer, Integer> outMinusInDegree=new HashMap<>();
//        for(int[] p: pairs){
//            int x=p[0], y=p[1];
//            graph.putIfAbsent(x, new LinkedList<>());
//            graph.get(x).offer(y);
//            outMinusInDegree.put(x, outMinusInDegree.getOrDefault(x, 0)+1);
//            outMinusInDegree.put(y, outMinusInDegree.getOrDefault(y, 0)-1);
//        }
//        int start=-1;
//        for(int k: outMinusInDegree.keySet()){
//            if(outMinusInDegree.get(k)>0){
//                start=k;
//                break;
//            }
//        }
//        start=start==-1?outMinusInDegree.keySet().iterator().next():start;
//        int[][] result=new int[pairs.length][2];
//        int i=pairs.length-1, last=-1;;
//        Stack<Integer> stack=new Stack<>();
//        stack.push(start);
//        while(!stack.isEmpty()){
//            int cur=stack.peek();
//            Queue<Integer> nb=graph.get(cur);
//            if(nb!=null && !nb.isEmpty()){
//                stack.push(nb.poll());
//            } else{
//                if(last!=-1){
//                    result[i--]=new int[]{cur, last};
//                }
//                last=stack.pop();
//            }
//        }
//        return result;
//    }

    // Eulerian path, note how the graph is built using Queue, if there's a requirement on the ordering of the path, then
    // it should use PriorityQueue, but the point is using such a data structure rather than Map or Set brings the flexibility
    // of removing visited edges
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Queue<Integer>> graph=new HashMap<>();
        Map<Integer, Integer> outMinusInDegree=new HashMap<>();
        for(int[] p: pairs){
            int x=p[0], y=p[1];
            graph.putIfAbsent(x, new LinkedList<>());
            graph.get(x).offer(y);
            outMinusInDegree.put(x, outMinusInDegree.getOrDefault(x, 0)+1);
            outMinusInDegree.put(y, outMinusInDegree.getOrDefault(y, 0)-1);
        }
        int start=-1;
        for(int k: outMinusInDegree.keySet()){
            if(outMinusInDegree.get(k)>0){
                start=k;
                break;
            }
        }
        start=start==-1?outMinusInDegree.keySet().iterator().next():start;
        int[][] result=new int[pairs.length][2];
        int[] cache=new int[]{pairs.length-1, -1};
        vaHelper(graph, start, result, cache);
        return result;
    }

    private void vaHelper(Map<Integer, Queue<Integer>> graph, int cur, int[][] result, int[] cache){
        if(graph.containsKey(cur)){
            Queue<Integer> nb=graph.get(cur);
            while(!nb.isEmpty()){
                vaHelper(graph, nb.poll(), result, cache);
            }
        }
        if(cache[1]==-1){
            cache[1]=cur;
        } else{
            result[cache[0]][0]=cur;
            result[cache[0]--][1]=cache[1];
            cache[1]=cur;
        }
    }
}
