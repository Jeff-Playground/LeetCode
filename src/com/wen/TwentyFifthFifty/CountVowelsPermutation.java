package com.wen.TwentyFifthFifty;

public class CountVowelsPermutation {
    public int countVowelPermutation(int n) {
        int[][] dp=new int[n][5];
        int mod=1_000_000_007;
        for(int i=0; i<n; i++){
            for(int j=0; j<5; j++){
                if(i==0){
                    dp[i][j]=1;
                } else{
                    dp[i][0]=dp[i-1][1];
                    dp[i][1]=(dp[i-1][0]+dp[i-1][2])%mod;
                    dp[i][2]=(((dp[i-1][0]+dp[i-1][1])%mod+dp[i-1][3])%mod+dp[i-1][4])%mod;
                    dp[i][3]=(dp[i-1][2]+dp[i-1][4])%mod;
                    dp[i][4]=dp[i-1][0];
                }
            }
        }
        int result=0;
        for(int v: dp[n-1]){
            result=(result+v)%mod;
        }
        return result;
    }
}
