package com.wen.TwentyThirdFifty;

import java.util.*;

public class LQParallelCourses {
    // Topological sort
    public int minimumSemesters(int n, int[][] relations) {
        int[] inDegree=new int[n+1];
        Map<Integer, Set<Integer>> graph=new HashMap<>();
        for(int[] r: relations){
            graph.putIfAbsent(r[0], new HashSet<>());
            graph.get(r[0]).add(r[1]);
            inDegree[r[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }
        int result=0, count=0;
        while(!q.isEmpty()){
            int size=q.size();
            result++;
            for(int i=0; i<size; i++){
                int cur=q.poll();
                count++;
                for(int next: graph.getOrDefault(cur, new HashSet<>())){
                    if(--inDegree[next]==0){
                        q.offer(next);
                    }
                }
            }
        }
        return count==n?result:-1;
    }
}
