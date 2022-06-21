package com.wen.FourteenthFifty;

import java.util.*;

public class KnightProbabilityInChessboard {
//    // BFS, will TLE
//    public double knightProbability(int n, int k, int row, int column) {
//        int[][] dirs=new int[][]{{-2,1},{-2,-1},{2,1},{2,-1},{-1,2},{-1,-2},{1,2},{1,-2}};
//        Queue<Integer> q=new LinkedList<>();
//        q.offer(row*n+column);
//        Map<Integer, Set<Integer>> cache=new HashMap<>();
//        int move=0;
//        while(move++<k){
//            int size=q.size();
//            while(size-->0){
//                int cur=q.poll();
//                if(!cache.containsKey(cur)){
//                    int x=cur/n, y=cur%n;
//                    cache.put(cur, new HashSet<>());
//                    for(int[] d: dirs){
//                        int nx=x+d[0], ny=y+d[1];
//                        if(nx>=0 && nx<n && ny>=0 && ny<n){
//                            cache.get(cur).add(nx*n+ny);
//                        }
//                    }
//                }
//                for(int next: cache.get(cur)){
//                    q.offer(next);
//                }
//            }
//        }
//        return (double)q.size()/Math.pow(8,k);
//    }

    // DP bottom up, dp[m][i][j] stands for the number of onboard moves for moving m times from (i,j)
    public double knightProbability(int n, int k, int row, int column) {
        int[][] dirs=new int[][]{{-2,-1},{2,-1},{-2,1},{2,1},{-1,-2},{1,-2},{-1,2},{1,2}};
        double[][][] dp=new double[k+1][n][n];
        for(int m=0; m<=k; m++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(m==0){
                        dp[m][i][j]=1;
                    } else{
                        for(int[] d: dirs){
                            int x=i+d[0], y=j+d[1];
                            if(x>=0 && x<n && y>=0 && y<n){
                                dp[m][i][j]+=dp[m-1][x][y];
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column]/Math.pow(8,k);
    }

//    // DP top down
//    public double knightProbability(int n, int k, int row, int column) {
//        double[][][] cache=new double[k+1][n][n];
//        for(int m=0; m<=k; m++){
//            for(int i=0; i<n; i++){
//                Arrays.fill(cache[m][i], -1);
//            }
//        }
//        return dp(k, row, column, cache)/Math.pow(8,k);
//    }
//
//    private double dp(int k, int r, int c, double[][][] cache){
//        if(cache[k][r][c]==-1){
//            cache[k][r][c]=0;
//            if(k==0){
//                cache[k][r][c]=1;
//            } else{
//                int[][] dirs=new int[][]{{-2,-1},{2,-1},{-2,1},{2,1},{-1,-2},{1,-2},{-1,2},{1,2}};
//                int n=cache[0].length;
//                for(int[] d: dirs){
//                    int x=r+d[0], y=c+d[1];
//                    if(x>=0 && x<n && y>=0 && y<n){
//                        cache[k][r][c]+=dp(k-1, x, y, cache);
//                    }
//                }
//            }
//        }
//        return cache[k][r][c];
//    }
}
