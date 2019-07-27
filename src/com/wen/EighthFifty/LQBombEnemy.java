package com.wen.EighthFifty;

public class LQBombEnemy {
    // DP2
    public int maxKilledEnemies(char[][] grid) {
        int result=0;
        if(grid==null || grid.length==0 || grid[0].length==0){
            return result;
        }
        int m=grid.length, n=grid[0].length;
        int inRow=0;
        int[] inCol=new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(j==0 || grid[i][j-1]=='W'){
                    inRow=0;
                    for(int k=j; k<n && grid[i][k]!='W'; k++){
                        inRow+=grid[i][k]=='E'?1:0;
                    }
                }
                if(i==0 || grid[i-1][j]=='W'){
                    inCol[j]=0;
                    for(int k=i; k<m && grid[k][j]!='W'; k++){
                        inCol[j]+=grid[k][j]=='E'?1:0;
                    }
                }
                if(grid[i][j]=='0'){
                    result=Math.max(result, inRow+inCol[j]);
                }
            }
        }
        return result;
    }

//    // DP1
//    public int maxKilledEnemies(char[][] grid) {
//        int result=0;
//        if(grid==null || grid.length==0 || grid[0].length==0){
//            return result;
//        }
//        int m=grid.length, n=grid[0].length;
//        int[][] left=new int[m][n];
//        int[][] right=new int[m][n];
//        int[][] up=new int[m][n];
//        int[][] down=new int[m][n];
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                int pre=(j==0 || grid[i][j]=='W')?0:left[i][j-1];
//                left[i][j]=grid[i][j]=='E'?pre+1:pre;
//            }
//            for(int j=n-1; j>=0; j--){
//                int pre=(j==n-1 || grid[i][j]=='W')?0:right[i][j+1];
//                right[i][j]=grid[i][j]=='E'?pre+1:pre;
//            }
//        }
//        for(int j=0; j<n; j++){
//            for(int i=0; i<m; i++){
//                int pre=(i==0 || grid[i][j]=='W')?0:up[i-1][j];
//                up[i][j]=grid[i][j]=='E'?pre+1:pre;
//            }
//            for(int i=m-1; i>=0; i--){
//                int pre=(i==m-1 || grid[i][j]=='W')?0:down[i+1][j];
//                down[i][j]=grid[i][j]=='E'?pre+1:pre;
//            }
//        }
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(grid[i][j]=='0'){
//                    result=Math.max(result, left[i][j]+right[i][j]+up[i][j]+down[i][j]);
//                }
//            }
//        }
//        return result;
//    }
}
