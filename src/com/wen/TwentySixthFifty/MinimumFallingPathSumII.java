package com.wen.TwentySixthFifty;

public class MinimumFallingPathSumII {
    // DP
    public int minFallingPathSum(int[][] arr) {
        int m=arr.length, n=arr[0].length;
        int[][] last=new int[][]{{-1, 0}, {-1, 0}};
        for(int i=0; i<m; i++){
            int[][] cur=new int[][]{{-2, Integer.MAX_VALUE}, {-2, Integer.MAX_VALUE}};
            for(int j=0; j<n; j++){
                int temp=arr[i][j]+(j==last[0][0]?last[1][1]:last[0][1]);
                if(cur[0][0]==-2){
                    cur[0][0]=j;
                    cur[0][1]=temp;
                } else if(temp<cur[0][1]){
                    cur[1][1]=cur[0][1];
                    cur[1][0]=cur[0][0];
                    cur[0][1]=temp;
                    cur[0][0]=j;
                } else if(temp<cur[1][1]){
                    cur[1][1]=temp;
                    cur[1][0]=j;
                }
            }
            last=cur;
        }
        return Math.min(last[0][1], last[1][1]);
    }
}
