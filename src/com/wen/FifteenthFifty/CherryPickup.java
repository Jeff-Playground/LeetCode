package com.wen.FifteenthFifty;

public class CherryPickup {
    // DP, dp[i][p] stands for the maximum of cherry picked up for the paths (0,0)->(i,j) and (p,q)->(0,0)
    // Note n is the steps of the path, and n=i+j=p+q can ensure (i,j) and (p,q) not covered in previous paths
    // When i==p, the two paths form a round trip
    public static int cherryPickup(int[][] grid) {
        int N=grid.length;
        int[][] dp=new int[N][N];
        dp[0][0]=grid[0][0];
        for(int n=1; n<2*N-1; n++){
            for(int i=N-1; i>=0; i--){
                for(int p=N-1; p>=0; p--){
                    int j=n-i, q=n-p;
                    if(j<0 || j>=N || q<0 || q>=N || grid[i][j]==-1 || grid[p][q]==-1){
                        dp[i][p]=-1;
                    } else{
                        if(i>0){
                            dp[i][p]=Math.max(dp[i][p], dp[i-1][p]);
                        }
                        if(p>0){
                            dp[i][p]=Math.max(dp[i][p], dp[i][p-1]);
                        }
                        if(i>0 && p>0){
                            dp[i][p]=Math.max(dp[i][p], dp[i-1][p-1]);
                        }
                        if(dp[i][p]!=-1){
                            dp[i][p]+=i==p?grid[i][j]:grid[i][j]+grid[p][q];
                        }
                    }
                }
            }
        }
        return Math.max(dp[N-1][N-1],0);
    }
}
