package com.wen.EighteenthFifty;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ReachableNodesInSubdividedGraph {
    // Dijkstra to determine the order of nodes to be visited, note graph here stores the steps/nodes on the edges. The
    // graph is updated accordingly to avoid duplicated traversal
    public static int reachableNodes(int[][] edges, int maxMoves, int n) {
        int[][] graph=new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(graph[i], -1);
        }
        for(int[] edge: edges){
            int x=edge[0], y=edge[1], w=edge[2];
            graph[x][y]=w;
            graph[y][x]=w;
        }
        int[] visited=new int[n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->b[0]-a[0]);
        pq.offer(new int[]{maxMoves, 0});
        int result=0;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int remainMoves=cur[0], node=cur[1];
            if(visited[node]==0){
                visited[node]=1;
                result+=1;
                for(int i=0; i<n; i++){
                    if(graph[node][i]>=0){
                        if(remainMoves>graph[node][i]){
                            result+=graph[node][i];
                            if(visited[i]==0){
                                pq.offer(new int[]{remainMoves-graph[node][i]-1, i});
                            }
                            graph[node][i]=0;
                            graph[i][node]=0;
                        } else{
                            result+=remainMoves;
                            graph[node][i]-=remainMoves;
                            graph[i][node]-=remainMoves;
                        }
                    }
                }
            }
        }
        return result;
    }
}
