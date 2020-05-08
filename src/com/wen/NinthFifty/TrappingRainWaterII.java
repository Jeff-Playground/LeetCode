package com.wen.NinthFifty;

import java.util.PriorityQueue;

public class TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {
        int m=heightMap.length, n=heightMap[0].length, result=0;
        int[][] visited=new int[m][n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[2]-b[2]);
        int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || i==m-1 || j==0 || j==n-1){
                    visited[i][j]=1;
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                }
            }
        }
        int max=Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            max=Math.max(max, cur[2]);
            for(int[] dir: dirs){
                int x=cur[0]+dir[0], y=cur[1]+dir[1];
                if(x>=0 && x<m && y>=0 && y<n && visited[x][y]==0){
                    int h=heightMap[x][y];
                    visited[x][y]=1;
                    if(h<max){
                        result+=max-h;
                    }
                    pq.offer(new int[]{x, y, h});
                }
            }
        }
        return result;
    }
}
