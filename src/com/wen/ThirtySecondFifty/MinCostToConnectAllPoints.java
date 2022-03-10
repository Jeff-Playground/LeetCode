package com.wen.ThirtySecondFifty;

import java.util.*;

public class MinCostToConnectAllPoints {
    // Prim's algorithm
    public int minCostConnectPoints(int[][] points) {
        int l=points.length;
        int[][] dist=new int[l][l];
        for(int i=0; i<l; i++){
            for(int j=i+1; j<l; j++){
                dist[i][j]=getManhattanDist(points[i], points[j]);
            }
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[2]-b[2]);
        Set<Integer> visited=new HashSet<>();
        visited.add(0);
        for(int j=1; j<l; j++){
            pq.offer(new int[]{0, j, dist[0][j]});
        }
        int result=0;
        while(!pq.isEmpty() && visited.size()<l){
            int[] cur=pq.poll();
            int x=cur[0], y=cur[1], d=cur[2];
            if(!visited.contains(y)){
                visited.add(y);
                result+=d;
                for(int i=0; i<y; i++){
                    if(!visited.contains(i)){
                        pq.offer(new int[]{y, i, dist[i][y]});
                    }
                }
                for(int j=y+1; j<l; j++){
                    if(!visited.contains(j)){
                        pq.offer(new int[]{y, j, dist[y][j]});
                    }
                }
            }
        }
        return result;
    }

    private int getManhattanDist(int[] p1, int[] p2){
        return Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
    }

//    // Kruskal's algorithm
//    public int minCostConnectPoints(int[][] points) {
//        int l=points.length;
//        int[][] dist=new int[l][l];
//        for(int i=0; i<l; i++){
//            for(int j=0; j<=i; j++){
//                if(i!=j){
//                    dist[i][j]=getManhattanDist(points[i], points[j]);
//                }
//            }
//        }
//        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[2]-b[2]);
//        for(int i=0; i<l; i++){
//            for(int j=0; j<=i; j++){
//                if(i!=j){
//                    pq.offer(new int[]{i, j, dist[i][j]});
//                }
//            }
//        }
//        int result=0, foundCount=0;
//        UnionFind uf=new UnionFind(l);
//        while(!pq.isEmpty()){
//            int[] cur=pq.poll();
//            int x=cur[0], y=cur[1], d=cur[2];
//            if(uf.find(x)!=uf.find(y)){
//                uf.union(x, y);
//                result+=d;
//                if(++foundCount==l-1){
//                    break;
//                }
//            }
//        }
//        return result;
//    }
//
//    private class UnionFind{
//        int[] root, rank;
//
//        public UnionFind(int l){
//            root=new int[l];
//            rank=new int[l];
//            for(int i=0; i<l; i++){
//                root[i]=i;
//                rank[i]=1;
//            }
//        }
//
//        public int find(int x){
//            if(root[x]!=x){
//                root[x]=find(root[x]);
//            }
//            return root[x];
//        }
//
//        public void union(int x, int y){
//            int rx=find(x), ry=find(y);
//            if(rx!=ry){
//                if(rank[rx]>rank[ry]){
//                    root[ry]=rx;
//                } else if(rank[rx]<rank[ry]){
//                    root[rx]=ry;
//                } else{
//                    root[rx]=ry;
//                    rank[ry]++;
//                }
//            }
//        }
//    }
//
//    private int getManhattanDist(int[] p1, int[] p2){
//        return Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
//    }
}
