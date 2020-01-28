package com.wen.FourteenthFifty;

import java.util.*;

public class LQNumberOfDistinctIslands {
//    // DFS
//    public int numberofDistinctIslands(int[][] grid) {
//        if(grid==null || grid.length==0 || grid[0].length==0){
//            throw new IllegalArgumentException("Input grid can't be null or empty!");
//        }
//        int m=grid.length, n=grid[0].length;
//        Set<List<Integer>> result=new HashSet<>();
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(grid[i][j]==1){
//                    List<Integer> island=new ArrayList();
//                    numberofDistinctIslandsDFS(grid, i, j, i, j, island);
//                    result.add(island);
//                }
//            }
//        }
//        return result.size();
//    }
//
//    public void numberofDistinctIslandsDFS(int[][] grid, int x0, int y0, int x, int y, List<Integer> island) {
//        int m=grid.length, n=grid[0].length;
//        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
//        if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
//            grid[x][y]=-1;
//            island.add(x-x0);
//            island.add(y-y0);
//            for(int[] dir: dirs){
//                numberofDistinctIslandsDFS(grid, x0, y0, x+dir[0], y+dir[1], island);
//            }
//        }
//    }

    // BFS
    public int numberofDistinctIslands(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            throw new IllegalArgumentException("Input grid can't be null or empty!");
        }
        int m=grid.length, n=grid[0].length;
        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        Set<List<Integer>> result=new HashSet<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    grid[i][j]=-1;
                    List<Integer> island=new ArrayList<>();
                    Queue<int[]> q=new LinkedList<>();
                    q.offer(new int[]{i, j});
                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        island.add(cur[0]-i);
                        island.add(cur[1]-j);
                        for(int[] dir: dirs){
                            int x=cur[0]+dir[0], y=cur[1]+dir[1];
                            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                                grid[x][y]=-1;
                                q.offer(new int[]{x, y});
                            }
                        }
                    }
                    result.add(island);
                }
            }
        }
        return result.size();
    }
}
