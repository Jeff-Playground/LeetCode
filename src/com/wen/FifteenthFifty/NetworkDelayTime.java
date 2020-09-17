package com.wen.FifteenthFifty;

import java.util.*;

public class NetworkDelayTime {
//    // Dijkstra
//    public int networkDelayTime(int[][] times, int N, int K) {
//        int[][] edges=new int[N+1][N+1];
//        for(int i=0; i<N+1; i++) {
//            Arrays.fill(edges[i],-1);
//        }
//        Map<Integer, Integer> reached=new HashMap<>();
//        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->((edges[a[0]][a[1]]+reached.get(a[0]))-(edges[b[0]][b[1]]+reached.get(b[0]))));
//        reached.put(K, 0);
//        for(int[] time: times) {
//            edges[time[0]][time[1]]=time[2];
//            if(time[0]==K) {
//                pq.offer(new int[] {time[0], time[1]});
//            }
//        }
//        while(!pq.isEmpty()) {
//            int[] cur=pq.poll();
//            if(!reached.containsKey(cur[1])) {
//                reached.put(cur[1], reached.get(cur[0])+edges[cur[0]][cur[1]]);
//                if(reached.size()==N) {
//                    return reached.get(cur[1]);
//                } else {
//                    for(int i=0; i<N+1; i++) {
//                        if(edges[cur[1]][i]!=-1 && !reached.containsKey(i)) {
//                            pq.offer(new int[] {cur[1], i});
//                        }
//                    }
//                }
//            }
//        }
//        return -1;
//    }

//    // Bellman-ford
//    public int networkDelayTime(int[][] times, int N, int K) {
//        int[] cost=new int[N+1];
//        Arrays.fill(cost, Integer.MAX_VALUE);
//        cost[K]=0;
//        for(int i=1; i<=N-1; i++) {
//            for(int[] time: times) {
//                if(cost[time[0]]<Integer.MAX_VALUE && cost[time[0]]+time[2]<cost[time[1]]) {
//                    cost[time[1]]=cost[time[0]]+time[2];
//                }
//            }
//        }
//        // Logic to determine whether there's a negative loop
//        // for(int[] time: times) {
//        // 	if(cost[time[0]]<Integer.MAX_VALUE && cost[time[0]]+time[2]<cost[time[1]]) {
//        // 		return -1;
//        // 	}
//        // }
//        int result=0;
//        for(int i=1; i<=N; i++) {
//            if(cost[i]==Integer.MAX_VALUE) {
//                return -1;
//            } else{
//                result=Math.max(result, cost[i]);
//            }
//        }
//        return result;
//    }

//    // SPFA
//    public int networkDelayTime(int[][] times, int N, int K) {
//        int[] cost=new int[N+1];
////        int[] count=new int[N+1];
//        Arrays.fill(cost, Integer.MAX_VALUE);
//        cost[K]=0;
//        Queue<Integer> q=new LinkedList<>();
//        q.offer(K);
////        count[K]++;
//        while(!q.isEmpty()) {
//            int reached=q.poll();
//            for(int[] time: times) {
//                if(time[0]==reached && cost[time[0]]+time[2]<cost[time[1]]) {
//                    cost[time[1]]=cost[time[0]]+time[2];
//                    q.offer(time[1]);
//                    // Logic to determine whether there's a negative loop
//                    // Note here normally should be >N-1, but to handle the case when N==1, give N
//                    // if(++count[time[1]]>N) {
//                    // 	return -1;
//                    // }
//                }
//            }
//        }
//        int result=0;
//        for(int i=1; i<=N; i++) {
//            if(cost[i]==Integer.MAX_VALUE) {
//                return -1;
//            } else{
//                result=Math.max(result, cost[i]);
//            }
//        }
//        return result;
//    }

    // Floyd
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] dist=new int[N+1][N+1];
        // last can be used to output path
        // int[][] last=new int[N+1][N+1];
        for(int i=1; i<N+1; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for(int i=1; i<N+1; i++) {
            dist[i][i]=0;
        }
        for(int[] time: times) {
            dist[time[0]][time[1]]=time[2];
            // last[time[0]][time[1]]=time[0];
        }
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(dist[i][k]<Integer.MAX_VALUE && dist[k][j]<Integer.MAX_VALUE && dist[i][k]+dist[k][j]<dist[i][j]) {
                        dist[i][j]=dist[i][k]+dist[k][j];
                        // last[i][j]=k;
                    }
                }
            }
        }
        int result=0;
        for(int i=1; i<=N; i++) {
            if(i!=K) {
                if(dist[K][i]==Integer.MAX_VALUE) {
                    return -1;
                } else {
                    result=Math.max(result, dist[K][i]);
                }
            }
        }
        return result;
    }
}
