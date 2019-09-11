package com.wen.Airbnb;

import java.util.*;

public class TenWizrds {
    public static void main(String args[]) {
        List<List<Integer>> wizards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 0) {
                list.add(1);
                list.add(2);
            } else if (i == 1) {
                list.add(3);
            } else if (i == 2) {
                list.add(3);
                list.add(4);
            } else if (i == 3) {
                list.add(4);
            }
            wizards.add(list);
        }
        List<Integer> path = getShortestPath(wizards, 0, 4);
        for (int i = 0; i < path.size(); i++) {
            System.out.println(path.get(i));
        }
    }

    // SPFA
    private static List<Integer> getShortestPath(List<List<Integer>> wizards, int src, int dst) {
        List<Integer> result=new ArrayList<>();
        int n=wizards.size();
        int[] cost=new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src]=0;
        int[] last=new int[n];
        Arrays.fill(last, -1);
        Queue<Integer> q=new LinkedList<>();
        q.offer(src);
        int[] count=new int[n];
        count[src]++;
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int to: wizards.get(cur)){
                if(cost[to]>cost[cur]+(cur-to)*(cur-to)){
                    cost[to]=cost[cur]+(cur-to)*(cur-to);
                    last[to]=cur;
                    q.offer(to);
                    if(++count[to]>n){
                        return null;
                    }
                }
            }
        }
        if(cost[dst]<Integer.MAX_VALUE){
            result.add(dst);
            int t=dst;
            while(t!=src){
                result.add(0,last[t]);
                t=last[t];
            }
        }
        return result;
    }

//    // Dijkstra
//    private static List<Integer> getShortestPath(List<List<Integer>> wizards, int src, int dst) {
//        List<Integer> result=new ArrayList<>();
//        int[] visited=new int[wizards.size()];
//        visited[src]=1;
//        int[] last=new int[wizards.size()];
//        Arrays.fill(last, -1);
//        Map<Integer, Integer> reached=new HashMap<>();
//        reached.put(src, 0);
//        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->(a[2]+reached.get(a[0]))-(b[2]+reached.get(b[0])));
//        for(Integer srcTo: wizards.get(src)){
//            pq.offer(new int[]{src, srcTo, (src-srcTo)*(src-srcTo)});
//        }
//        while(!pq.isEmpty()){
//            int[] cur=pq.poll();
//            if(visited[cur[1]]==0){
//                visited[cur[1]]=1;
//                reached.put(cur[1], reached.get(cur[0])+cur[2]);
//                last[cur[1]]=cur[0];
//                if(cur[1]==dst){
//                    result.add(dst);
//                    int t=dst;
//                    while(t!=src){
//                        result.add(0, last[t]);
//                        t=last[t];
//                    }
//                    return result;
//                } else{
//                    for(Integer curTo: wizards.get(cur[1])){
//                        if(visited[curTo]==0){
//                            pq.offer(new int[]{cur[1], curTo, (cur[1]-curTo)*(cur[1]-curTo)});
//                        }
//                    }
//                }
//            }
//        }
//        return null;
//    }
}
