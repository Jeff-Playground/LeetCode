package com.wen.TwentiethFifty;

import java.util.Arrays;

public class DeleteColumnsToMakeSortedIII {
    // dp[i] stands for the maximum number of valid columns when ending with column at i
    public int minDeletionSize(String[] A) {
        if(A==null || A.length==0){
            return 0;
        }
        int m=A.length, n=A[0].length();
        int[] dp=new int[n];
        Arrays.fill(dp, 1);
        int max=1;
        for(int j=1; j<n; j++){
            for(int k=0; k<j; k++){
                boolean inOrder=true;
                for(int i=0; i<m; i++){
                    if(A[i].charAt(k)>A[i].charAt(j)){
                        inOrder=false;
                        break;
                    }
                }
                if(inOrder){
                    dp[j]=Math.max(dp[j], dp[k]+1);
                    max=Math.max(max, dp[j]);
                }
            }
        }
        return n-max;
    }
}
