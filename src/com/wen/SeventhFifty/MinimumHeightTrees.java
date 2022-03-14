package com.wen.SeventhFifty;

import java.util.*;

public class MinimumHeightTrees {
    // Find the nodes with inDegree==1 level by level and remove them from the all nodes set, the result will have no
    // more than 2 nodes, because otherwise it can be further reduced.
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result=new ArrayList<>();
        if(n==1){
            result.add(0);
            return result;
        }
        Map<Integer, Set<Integer>> tree=new HashMap<>();
        for(int[] e:edges){
            int x=e[0], y=e[1];
            tree.putIfAbsent(x, new HashSet<>());
            tree.putIfAbsent(y, new HashSet<>());
            tree.get(x).add(y);
            tree.get(y).add(x);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int v: tree.keySet()){
            if(tree.get(v).size()==1){
                q.offer(v);
            }
        }
        Set<Integer> level=new HashSet<>();
        while(!q.isEmpty()){
            int size=q.size();
            level=new HashSet<>();
            for(int i=0; i<size; i++){
                int cur=q.poll();
                level.add(cur);
                for(int next: tree.get(cur)){
                    tree.get(next).remove(cur);
                    if(tree.get(next).size()==1){
                        q.offer(next);
                    }
                }
            }
        }
        result.addAll(level);
        return result;
    }
}
