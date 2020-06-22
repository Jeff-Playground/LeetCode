package com.wen.SeventhFifty;

public class LongestIncreasingPathInAMatrix {
    // DFS
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        int m=matrix.length, n=matrix[0].length;
        int[][] length=new int[m][n];
        int result=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(length[i][j]==0){
                    lipHelper(matrix, length, i, j);
                }
                result=Math.max(result, length[i][j]);
            }
        }
        return result;
    }

    private void lipHelper(int[][] matrix, int[][] length, int x, int y){
        int m=matrix.length, n=matrix[0].length;
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int max=0;
        for(int[] dir: dirs){
            int newX=x+dir[0], newY=y+dir[1];
            if(newX>=0 && newX<m && newY>=0 && newY<n){
                if(matrix[newX][newY]>matrix[x][y]){
                    if(length[newX][newY]==0){
                        lipHelper(matrix, length, newX, newY);
                    }
                    max=Math.max(length[newX][newY], max);
                }
            }
        }
        length[x][y]=max+1;
    }
}
