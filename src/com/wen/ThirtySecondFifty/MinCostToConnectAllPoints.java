package com.wen.ThirtySecondFifty;

import java.util.*;

public class MinCostToConnectAllPoints {
    // Minimum spanning tree
    public int minCostConnectPoints(int[][] points) {
        if(points==null || points.length==0){
            throw new IllegalArgumentException("Invalid input!");
        }
        int l=points.length;
        int[][] dist=new int[l][l];
        for(int i=0; i<l; i++){
            for(int j=0; j<l; j++){
                if(i!=j){
                    if(i>j){
                        dist[i][j]=dist[j][i];
                    } else{
                        dist[i][j]=getDist(points[i], points[j]);
                    }
                }
            }
        }
        List<PriorityQueue<Integer>> sort=new ArrayList<>();
        for(int i=0; i<l; i++){
            int cur=i;
            PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->dist[cur][a]-dist[cur][b]);
            for(int j=0; j<l; j++){
                if(j!=i){
                    pq.offer(j);
                }
            }
            sort.add(pq);
        }
        int result=0;
        Set<Integer> reached=new HashSet<>();
        reached.add(0);
        while(reached.size()<l){
            int min=Integer.MAX_VALUE, next=-1;
            for(int n: reached){
                PriorityQueue<Integer> pq=sort.get(n);
                while(!pq.isEmpty() && reached.contains(pq.peek())){
                    pq.poll();
                }
                if(!pq.isEmpty()){
                    int temp=pq.peek();
                    if(dist[n][temp]<min){
                        next=temp;
                        min=dist[n][temp];
                    }
                }
            }
            reached.add(next);
            result+=min;
        }
        return result;
    }

    private int getDist(int[] a, int[] b){
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }
}
