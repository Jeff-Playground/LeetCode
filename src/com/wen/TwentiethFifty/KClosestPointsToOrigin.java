package com.wen.TwentiethFifty;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    // MaxHeap
    public int[][] kClosest(int[][] points, int K) {
        int l=points.length;
        if(l<=K){
            return points;
        } else{
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1]);
            for(int i=0; i<l; i++){
                int[] p=points[i];
                if(pq.size()==K){
                    int[] max=pq.peek();
                    if(max[0]*max[0]+max[1]*max[1]-p[0]*p[0]-p[1]*p[1]>0){
                        pq.poll();
                        pq.offer(p);
                    }
                } else{
                    pq.offer(p);
                }
            }
            int[][] result=new int[K][2];
            for(int i=0; i<K; i++){
                result[i]=pq.poll();
            }
            return result;
        }
    }

//    // MinHeap
//    public int[][] kClosest(int[][] points, int K) {
//        int l=points.length;
//        if(l<=K){
//            return points;
//        }
//        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[0]*a[0]+a[1]*a[1]-b[0]*b[0]-b[1]*b[1]);
//        for(int i=0; i<l; i++){
//            pq.offer(points[i]);
//        }
//        int[][] result=new int[K][2];
//        for(int i=0; i<K; i++){
//            result[i]=pq.poll();
//        }
//        return result;
//    }
}
