package com.wen.EighthFifty;

/*
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:

For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)
 */

public class LQBombEnemy {
//    // DP2
//    public int maxKilledEnemies(char[][] grid) {
//        int result=0;
//        if(grid==null || grid.length==0 || grid[0].length==0){
//            return result;
//        }
//        int m=grid.length, n=grid[0].length;
//        int inRow=0;
//        int[] inCol=new int[n];
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(j==0 || grid[i][j-1]=='W'){
//                    inRow=0;
//                    for(int k=j; k<n && grid[i][k]!='W'; k++){
//                        inRow+=grid[i][k]=='E'?1:0;
//                    }
//                }
//                if(i==0 || grid[i-1][j]=='W'){
//                    inCol[j]=0;
//                    for(int k=i; k<m && grid[k][j]!='W'; k++){
//                        inCol[j]+=grid[k][j]=='E'?1:0;
//                    }
//                }
//                if(grid[i][j]=='0'){
//                    result=Math.max(result, inRow+inCol[j]);
//                }
//            }
//        }
//        return result;
//    }

    // DP1
    // left[i][j] stands for the number of enemies on the left of grid[i][j] before a wall if exists, right, up and down
    // are similar
    public int maxKilledEnemies(char[][] grid) {
        int result=0;
        if(grid==null || grid.length==0 || grid[0].length==0){
            return result;
        }
        int m=grid.length, n=grid[0].length;
        int[][] left=new int[m][n];
        int[][] right=new int[m][n];
        int[][] up=new int[m][n];
        int[][] down=new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int pre=(j==0 || grid[i][j]=='W')?0:left[i][j-1];
                left[i][j]=grid[i][j]=='E'?pre+1:pre;
            }
            for(int j=n-1; j>=0; j--){
                int pre=(j==n-1 || grid[i][j]=='W')?0:right[i][j+1];
                right[i][j]=grid[i][j]=='E'?pre+1:pre;
            }
        }
        for(int j=0; j<n; j++){
            for(int i=0; i<m; i++){
                int pre=(i==0 || grid[i][j]=='W')?0:up[i-1][j];
                up[i][j]=grid[i][j]=='E'?pre+1:pre;
            }
            for(int i=m-1; i>=0; i--){
                int pre=(i==m-1 || grid[i][j]=='W')?0:down[i+1][j];
                down[i][j]=grid[i][j]=='E'?pre+1:pre;
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='0'){
                    result=Math.max(result, left[i][j]+right[i][j]+up[i][j]+down[i][j]);
                }
            }
        }
        return result;
    }
}
