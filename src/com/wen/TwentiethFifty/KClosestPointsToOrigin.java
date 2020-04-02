package com.wen.TwentiethFifty;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        int l=points.length;
        if(l<=K){
            return points;
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[0]*a[0]+a[1]*a[1]-b[0]*b[0]-b[1]*b[1]);
        for(int i=0; i<l; i++){
            pq.offer(points[i]);
        }
        int[][] result=new int[K][2];
        for(int i=0; i<K; i++){
            int[] point=pq.poll();
            result[i][0]=point[0];
            result[i][1]=point[1];
        }
        return result;
    }
}
