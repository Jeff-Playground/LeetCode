package com.wen.TwelfthFifty;

public class StudentAttendanceRecordII {
    // DP
    // dp[i][0] - A(i)
    // dp[i][1] - L/A(i) - L with no A in front
    // dp[i][2] - P/A(i) - P with no A in front
    // dp[i][3] - L(i)
    // dp[i][4] - P(i)
    // Pay attention to the way of mod(m), it's down for every two numbers adding together
    public int checkRecord(int n) {
        if(n<=0){
            return 0;
        } else if(n==1){
            return 3;
        }
        int m=1_000_000_007;
        int[][] dp=new int[n][5];
        dp[0][0]=1;
        dp[0][1]=1;
        dp[0][2]=1;
        dp[0][3]=1;
        dp[0][4]=1;
        dp[1][0]=2;
        dp[1][1]=2;
        dp[1][2]=2;
        dp[1][3]=3;
        dp[1][4]=3;
        for(int i=2; i<n; i++) {
            dp[i][0]=(dp[i-1][1]+dp[i-1][2])%m;     // A(i)=L/A(i-1)+P/A(i-1)
            dp[i][1]=(dp[i-2][2]+dp[i-1][2])%m;     // L/A(i)=P/A(i-2)+P/A(i-1)
            dp[i][2]=(dp[i-1][1]+dp[i-1][2])%m;     // P/A(i)=L/A(i-1)+P/A(i-1)
            dp[i][3]=((dp[i-2][0]+dp[i-2][4])%m+(dp[i-1][0]+dp[i-1][4])%m)%m;   // L(i)=A(i-2)+P(i-2)+A(i-1)+P(i-1)
            dp[i][4]=((dp[i-1][0]+dp[i-1][3])%m+dp[i-1][4])%m;  // P(i)=A(i-1)+L(i-1)+P(i-1)
        }
        return ((dp[n-1][0]+dp[n-1][3])%m+dp[n-1][4])%m;
    }
}
