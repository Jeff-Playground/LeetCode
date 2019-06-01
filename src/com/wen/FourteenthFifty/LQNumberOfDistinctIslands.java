package com.wen.FourteenthFifty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LQNumberOfDistinctIslands {
    // DFS, note this can also be done by BFS with Queue
    public int numberofDistinctIslands(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            throw new IllegalArgumentException("Input grid can't be null or empty!");
        }
        int m=grid.length, n=grid[0].length;
        Set<List<Integer>> result=new HashSet<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    List<Integer> island=new ArrayList();
                    numberofDistinctIslandsDFS(grid, i, j, i, j, island);
                    result.add(island);
                }
            }
        }
        return result.size();
    }

    public void numberofDistinctIslandsDFS(int[][] grid, int x0, int y0, int x, int y, List<Integer> island) {
        int m=grid.length, n=grid[0].length;
        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
            grid[x][y]=-1;
            island.add(x-x0);
            island.add(y-y0);
            for(int[] dir: dirs){
                numberofDistinctIslandsDFS(grid, x0, y0, x+dir[0], y+dir[1], island);
            }
        }
    }
}
