package com.wen.TwelfthFifty;

public class OutOfBoundaryPaths {
    // DP, dp[k][x][y] is, for position(x, y) and step k, the number of path to step out of grid
    public static int findPaths(int m, int n, int N, int i, int j) {
        int[][][] dp=new int[N+1][m][n];
        for(int k=1; k<=N; k++){
            for(int x=0; x<m; x++){
                for(int y=0; y<n; y++){
                    long v1=x==0?1:dp[k-1][x-1][y];
                    long v2=x==m-1?1:dp[k-1][x+1][y];
                    long v3=y==0?1:dp[k-1][x][y-1];
                    long v4=y==n-1?1:dp[k-1][x][y+1];
                    dp[k][x][y]=(int)((v1+v2+v3+v4)%1_000_000_007);
                }
            }
        }
        return dp[N][i][j];
    }

//    // DP, dp[i][j] is the count of path reached position (i, j)
//    // Note this is BFS, but this way is better because it makes time and space contained, using a Queue instead will TLE
//    public static int findPaths(int m, int n, int N, int i, int j) {
//        int[][] dp=new int[m][n];
//        dp[i][j]=1;
//        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//        int result=0;
//        for(int k=1; k<=N; k++){
//            int[][] temp=new int[m][n];
//            for(int x=0; x<m; x++){
//                for(int y=0; y<n; y++){
//                    for(int[] dir: dirs){
//                        int r=x+dir[0], c=y+dir[1];
//                        if(r<0 || r>=m || c<0 || c>=n){
//                            result=(result+dp[x][y])%1_000_000_007;
//                        } else{
//                            temp[r][c]=(temp[r][c]+dp[x][y])%1_000_000_007;
//                        }
//                    }
//                }
//            }
//            dp=temp;
//        }
//        return result;
//    }
}
