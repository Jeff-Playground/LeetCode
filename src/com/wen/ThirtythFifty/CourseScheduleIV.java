package com.wen.ThirtythFifty;

import java.util.*;

public class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> pres=new HashMap<>();
        for(int[] pre: prerequisites){
            pres.putIfAbsent(pre[1], new HashSet<>());
            pres.get(pre[1]).add(pre[0]);
        }
        List<Boolean> result=new ArrayList<>();
        for(int[] qr: queries){
            int[] visited=new int[n];
            visited[qr[1]]=1;
            Queue<Integer> q=new LinkedList<>();
            q.offer(qr[1]);
            boolean curResult=false;
            while(!q.isEmpty()){
                int cur=q.poll();
                if(pres.containsKey(cur)){
                    for(int next: pres.get(cur)){
                        if(next==qr[0]){
                            curResult=true;
                            break;
                        }
                        if(visited[next]==0){
                            visited[next]=1;
                            q.offer(next);
                        }
                    }
                }
            }
            result.add(curResult);
        }
        return result;
    }
}
