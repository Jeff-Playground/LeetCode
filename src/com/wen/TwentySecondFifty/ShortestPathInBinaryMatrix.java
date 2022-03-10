package com.wen.TwentySecondFifty;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    // BFS
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1){
            return -1;
        }
        int l=grid.length;
        if(l==1){
            return 1;
        }
        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0});
        grid[0][0]=2;
        int result=0;
        while(!q.isEmpty()){
            int size=q.size();
            result++;
            for(int i=0; i<size; i++){
                int[] cur=q.poll();
                int x=cur[0], y=cur[1];
                for(int[] d: dirs){
                    int nx=x+d[0], ny=y+d[1];
                    if(nx>=0 && nx<l && ny>=0 && ny<l && grid[nx][ny]==0){
                        if(nx==l-1 && ny==l-1){
                            return result+1;
                        }
                        grid[nx][ny]=2;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}
