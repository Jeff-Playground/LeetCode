package com.wen.TwentiethFifty;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    // BFS
    public int orangesRotting(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        Queue<Integer> q=new LinkedList<>();
        int freshCount=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.offer(i*n+j);
                } else if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }
        int result=0;
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                int cur=q.poll();
                int cx=cur/n, cy=cur%n;
                for(int[] dir: dirs){
                    int x=cx+dir[0], y=cy+dir[1];
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                        grid[x][y]=2;
                        q.offer(x*n+y);
                        freshCount--;
                    }
                }
            }
            result++;
        }
        // Note here result-=1 when result>0 because the last iteration will not find any fresh oranges
        result=result>0?result-1:result;
        return freshCount==0?result:-1;
    }
}
