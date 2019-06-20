package com.wen.FourthFifty;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    // BFS
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) {
            return 0;
        }
        int result=0;
        int m=grid.length, n=grid[0].length;
        Queue<Integer> queue=new LinkedList<>();
        int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    result++;
                    queue.offer(i*n+j);
                    grid[i][j]='2';
                    while(!queue.isEmpty()){
                        int cur=queue.poll();
                        for(int[] dir: dirs){
                            int x=cur/n+dir[0], y=cur%n+dir[1];
                            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]=='1'){
                                queue.offer(x*n+y);
                                grid[x][y]='2';
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

//    // DFS
//    public int numIslands(char[][] grid) {
//        if(grid==null || grid.length==0 || grid[0].length==0) {
//            return 0;
//        }
//        int result=0;
//        int m=grid.length, n=grid[0].length;
//        int[][] visited=new int[m][n];
//        for(int i=0; i<m; i++) {
//            for(int j=0; j<n; j++) {
//                if(grid[i][j]=='1' && visited[i][j]!=1) {
//                    result++;
//                    numIslandsDFS(grid, i, j, visited);
//                }
//            }
//        }
//        return result;
//    }
//
//    private void numIslandsDFS(char[][] grid, int x, int y, int[][] visited) {
//        if(x<0 || x>grid.length-1 || y<0 || y>grid[0].length-1) {
//            return;
//        }
//        if(grid[x][y]=='0' || visited[x][y]==1) {
//            return;
//        }
//        visited[x][y]=1;
//        numIslandsDFS(grid, x-1, y, visited);
//        numIslandsDFS(grid, x, y+1, visited);
//        numIslandsDFS(grid, x, y-1, visited);
//        numIslandsDFS(grid, x+1, y, visited);
//    }
}
