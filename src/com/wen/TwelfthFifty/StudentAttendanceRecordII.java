package com.wen.TwelfthFifty;

public class StudentAttendanceRecordII {
    public static int checkRecord(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 3;
        }
        int m=1000000007;
        int[][] dp=new int[n][3];
        dp[0][0]=1;
        dp[0][1]=1;
        dp[0][2]=1;
        dp[1][0]=2;
        dp[1][1]=2;
        dp[1][2]=2;
        for(int i=2; i<n; i++){
            dp[i][0]=(dp[i-1][1]+dp[i-1][2])%m;
            dp[i][1]=(dp[i-1][2]+dp[i-2][2])%m;
            dp[i][2]=(dp[i-1][1]+dp[i-1][2])%m;
        }
        dp[1][1]=3;
        dp[1][2]=3;
        for(int i=2; i<n; i++){
            dp[i][1]=((dp[i-1][0]+dp[i-1][2])%m+(dp[i-2][0]+dp[i-2][2])%m)%m;
            dp[i][2]=((dp[i-1][0]+dp[i-1][1])%m+dp[i-1][2])%m;
        }
        return ((dp[n-1][0]+dp[n-1][1])%m+dp[n-1][2])%m;
    }
}