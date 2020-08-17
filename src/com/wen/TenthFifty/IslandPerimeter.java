package com.wen.TenthFifty;

public class IslandPerimeter {
    // For each square, add 4 then check its left and up square, if exists minus 2 edges from the result
    public int islandPerimeter(int[][] grid) {
        int result=0;
        int m=grid.length, n=grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    result+=4;
                    if(i>0 && grid[i-1][j]==1){
                        result-=2;
                    }
                    if(j>0 && grid[i][j-1]==1){
                        result-=2;
                    }
                }
            }
        }
        return result;
    }

//    public int islandPerimeter(int[][] grid) {
//        // Find the edge squares and update result
//        int result=0;
//        int m=grid.length, n=grid[0].length;
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(grid[i][j]==1){
//                    if(i==0 || grid[i-1][j]==0){
//                        result++;
//                    }
//                    if(i==m-1 || grid[i+1][j]==0){
//                        result++;
//                    }
//                    if(j==0 || grid[i][j-1]==0){
//                        result++;
//                    }
//                    if(j==n-1 || grid[i][j+1]==0){
//                        result++;
//                    }
//                }
//            }
//        }
//        return result;
//    }

//    // DFS
//    public int islandPerimeter(int[][] grid) {
//        int[] result=new int[]{0};
//        int m=grid.length, n=grid[0].length;
//        for(int i=0; i<grid.length; i++){
//            for(int j=0; j<grid[0].length; j++){
//                if(grid[i][j]==1){
//                    int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//                    grid[i][j]=-1;
//                    result[0]+=4;
//                    ilpHelper(grid, dirs, i, j, -1, -1, result);
//                }
//            }
//        }
//        return result[0];
//    }
//
//    private void ilpHelper(int[][] grid, int[][] dirs, int x, int y, int lastX, int lastY, int[] result){
//        int m=grid.length, n=grid[0].length;
//        for(int[] dir: dirs){
//            int newX=x+dir[0], newY=y+dir[1];
//            if(!(newX==lastX && newY==lastY) && newX>=0 && newX<m && newY>=0 && newY<n){
//                if(grid[newX][newY]==1){
//                    grid[newX][newY]=-1;
//                    result[0]=result[0]-1+3;
//                    ilpHelper(grid, dirs, newX, newY, x, y, result);
//                } else if(grid[newX][newY]==-1){
//                    result[0]-=1;
//                }
//            }
//        }
//    }
}
