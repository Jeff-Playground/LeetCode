package com.wen.SixteenthFifty;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SwimInRisingWater {
//    // Binary search
//    public int swimInWater(int[][] grid) {
//        if(grid==null || grid.length==0 || grid[0].length==0){
//            return 0;
//        }
//        int N=grid.length;
//        int left=0, right=N*N-1;
//        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//        while(left<right){
//            int mid=left+(right-left)/2;
//            int[][] visited=new int[N][N];
//            if(swimInWaterDFS(grid, visited, dirs, mid, 0, 0)){
//                right=mid;
//            } else{
//                left=mid+1;
//            }
//        }
//        return left;
//    }
//
//    private boolean swimInWaterDFS(int[][] grid, int[][] visited, int[][] dirs, int depth, int x, int y){
//        if(grid[x][y]>depth){
//            return false;
//        } else{
//            int N=grid.length;
//            if(x==N-1 && y==N-1){
//                return true;
//            }
//            visited[x][y]=1;
//            for(int[] dir: dirs){
//                int newX=x+dir[0], newY=y+dir[1];
//                if(newX>=0 && newX<N && newY>=0 && newY<N && visited[newX][newY]==0){
//                    if(swimInWaterDFS(grid, visited, dirs, depth, newX, newY)){
//                        return true;
//                    }
//                }
//            }
//            return false;
//        }
//    }

//    // DFS with cache
//    public int swimInWater(int[][] grid) {
//        if(grid==null || grid.length==0 || grid[0].length==0){
//            return 0;
//        }
//        int N=grid.length;
//        int[][] dp=new int[N][N];
//        for(int i=0; i<N; i++){
//            Arrays.fill(dp[i], Integer.MAX_VALUE);
//        }
//        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//        swimInWaterDFS(grid, dp, dirs, 0, 0, grid[0][0]);
//        return dp[N-1][N-1];
//    }
//
//    private void swimInWaterDFS(int[][] grid, int[][] dp, int[][] dirs, int x, int y, int cur){
//        if(dp[x][y]<=cur){
//            return;
//        } else{
//            int N=grid.length;
//            if(cur>grid[x][y]){
//                dp[x][y]=cur;
//            } else{
//                dp[x][y]=grid[x][y];
//            }
//            for(int[] dir: dirs){
//                if(x+dir[0]>=0 && x+dir[0]<N && y+dir[1]>=0 && y+dir[1]<N){
//                    swimInWaterDFS(grid, dp, dirs, x+dir[0], y+dir[1], dp[x][y]);
//                }
//            }
//        }
//    }

    // Dijkstra
    public int swimInWater(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        int N=grid.length, k=N*N, result=grid[0][0];
        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.offer(grid[0][0]*k);
        grid[0][0]=-1;
        while(!pq.isEmpty()){
            int cur=pq.poll();
            int curDepth=cur/k, curX=(cur%k)/N, curY=(cur%k)%N;
            result=Math.max(result, curDepth);
            if(curX==N-1 && curY==N-1){
                return result;
            }
            for(int[] dir: dirs){
                int newX=curX+dir[0], newY=curY+dir[1];
                if(newX>=0 && newX<N && newY>=0 && newY<N && grid[newX][newY]!=-1){
                    int key=grid[newX][newY]*k+newX*N+newY;
                    pq.offer(key);
                    grid[newX][newY]=-1;
                }
            }
        }
        return result;
    }
}
