package com.wen.EighteenthFifty;

import java.util.*;

public class ReachableNodesInSubdividedGraph {
    public static int reachableNodes(int[][] edges, int M, int N) {
        int[][] graph=new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(graph[i], -1);
        }
        for(int[] edge: edges){
            int x=edge[0], y=edge[1], l=edge[2];
            graph[x][y]=l;
            graph[y][x]=l;
        }
        int[] visited=new int[N];
        PriorityQueue<int[]> q=new PriorityQueue<>((a, b)->b[0]-a[0]);
        q.offer(new int[]{M, 0});
        int result=0;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int remain=cur[0], n=cur[1];
            if(visited[n]==0){
                visited[n]=1;
                result++;
                for(int i=0; i<N; i++){
                    if(graph[n][i]>=0){
                        if(remain>graph[n][i] && visited[i]==0){
                            q.offer(new int[]{remain-graph[n][i]-1, i});
                        }
                        graph[i][n]-=Math.min(remain, graph[n][i]);
                        result+=Math.min(remain, graph[n][i]);
                    }
                }
            }
        }
        return result;
    }
}
