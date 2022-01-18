package com.wen.TwentyEighthFifty;

import java.util.*;

public class TimeNeededToInformAllEmployees {
    // DFS
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Set<Integer>> children=new HashMap<>();
        for(int i=0; i<n; i++){
            int m=manager[i];
            children.putIfAbsent(m, new HashSet<>());
            children.get(m).add(i);
        }
        int[] result=new int[]{0};
        nomDFS(headID, 0, children, informTime, result);
        return result[0];
    }

    private void nomDFS(int cur, int curTime, Map<Integer, Set<Integer>> children, int[] informTime, int[] result){
        if(children.containsKey(cur)){
            for(int c: children.get(cur)){
                nomDFS(c, curTime+informTime[cur], children, informTime, result);
            }
        } else{
            result[0]=Math.max(result[0], curTime);
        }
    }

//    // BFS
//    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
//        Map<Integer, Set<Integer>> children=new HashMap<>();
//        for(int i=0; i<n; i++){
//            int m=manager[i];
//            children.putIfAbsent(m, new HashSet<>());
//            children.get(m).add(i);
//        }
//        Queue<int[]> q=new LinkedList<>();
//        q.offer(new int[]{headID, 0});
//        int result=0;
//        while(!q.isEmpty()){
//            int[] cur=q.poll();
//            int parent=cur[0],  curTime=cur[1];
//            if(!children.containsKey(parent)){
//                result=Math.max(curTime+informTime[parent], result);
//            } else{
//                for(int c: children.get(parent)){
//                    q.offer(new int[]{c, curTime+informTime[parent]});
//                }
//            }
//        }
//        return result;
//    }
}
