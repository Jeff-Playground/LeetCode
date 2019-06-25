package com.wen.SeventhFifty;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }
        int l=nums.length;
        int[][] dp=new int[l][l];
        for(int len=1; len<=l; len++) {
            for(int i=0; i<l-len+1; i++) {
                int j=i+len-1;
                int left=i-1<0?1:nums[i-1];
                int right=j+1>l-1?1:nums[j+1];
                if(len==1) {
                    dp[i][j]=left*nums[i]*right;
                } else {
                    for(int k=i; k<=j; k++) {
                        dp[i][j]=Math.max(dp[i][j],(k-1>=0?dp[i][k-1]:0)+nums[k]*left*right+(k+1<l?dp[k+1][j]:0));
                    }
                }
            }
        }
        return dp[0][l-1];
    }
}
