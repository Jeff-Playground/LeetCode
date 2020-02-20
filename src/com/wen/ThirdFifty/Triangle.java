package com.wen.ThirdFifty;

import java.util.List;

public class Triangle {
    // Dynamic programming, from bottom to top
    // dp[i] stands for the sum from bottom to current layer to reach node i
    public int minimumTotal(List<List<Integer>> triangle) {
        int l=triangle.size();
        int[] dp=new int[l];
        for(int i=0; i<triangle.get(l-1).size(); i++){
            dp[i]=triangle.get(l-1).get(i);
        }
        for(int i=l-2; i>=0; i--){
            for(int j=0; j<triangle.get(i+1).size()-1; j++){
                dp[j]=triangle.get(i).get(j)+Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}
