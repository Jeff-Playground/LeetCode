package com.wen.FourthFifty;

public class DungeonGame {
    // Optimized dp with one dimensional array
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length, n=dungeon[0].length;
        int[] minimumHP=new int[n];
        minimumHP[n-1]=1-dungeon[m-1][n-1]<=0?1:1-dungeon[m-1][n-1];
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(j==n-1) {
                    if(i==m-1) {
                        minimumHP[j]=1-dungeon[m-1][n-1]<=0?1:1-dungeon[m-1][n-1];
                    } else {
                        minimumHP[j]=minimumHP[j]-dungeon[i][j]<=0?1:minimumHP[j]-dungeon[i][j];
                    }
                } else {
                    if(i==m-1) {
                        minimumHP[j]=minimumHP[j+1]-dungeon[m-1][j]<=0?1:minimumHP[j+1]-dungeon[m-1][j];
                    } else {
                        int preMin=Math.min(minimumHP[j], minimumHP[j+1]);
                        minimumHP[j]=preMin-dungeon[i][j]<=0?1:preMin-dungeon[i][j];
                    }
                }
            }
        }
        return minimumHP[0];
    }

//    // Dp
//    public int calculateMinimumHP(int[][] dungeon) {
//        int m=dungeon.length, n=dungeon[0].length;
//        int[][] minimumHP=new int[m][n];
//        minimumHP[m-1][n-1]=1-dungeon[m-1][n-1]<=0?1:1-dungeon[m-1][n-1];
//        for(int i=m-2; i>=0; i--) {
//            minimumHP[i][n-1]=minimumHP[i+1][n-1]-dungeon[i][n-1]<=0?1:minimumHP[i+1][n-1]-dungeon[i][n-1];
//        }
//        for(int j=n-2; j>=0; j--) {
//            minimumHP[m-1][j]=minimumHP[m-1][j+1]-dungeon[m-1][j]<=0?1:minimumHP[m-1][j+1]-dungeon[m-1][j];
//        }
//        for(int i=m-2; i>=0; i--) {
//            for(int j=n-2; j>=0; j--) {
//                int preMin=Math.min(minimumHP[i+1][j], minimumHP[i][j+1]);
//                minimumHP[i][j]=preMin-dungeon[i][j]<=0?1:preMin-dungeon[i][j];
//            }
//        }
//        return minimumHP[0][0];
//    }
}
