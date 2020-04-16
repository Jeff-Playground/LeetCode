package com.wen.TwentyFourthFifty;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        int result=Integer.MIN_VALUE;
        int m=grid.length, n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int[][] dirs=new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    q.offer(new int[]{i, j});
                    grid[i][j]=-1;
                }
            }
        }
        if(q.isEmpty() || q.size()==m*n){
            return -1;
        }
        int dist=0;
        while(!q.isEmpty()){
            int size=q.size();
            dist++;
            for(int i=0; i<size; i++){
                int[] cur=q.poll();
                for(int[] dir: dirs){
                    int x=cur[0]+dir[0], y=cur[1]+dir[1];
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==0){
                        grid[x][y]=dist;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
        dist--;
        return dist;
    }
}
