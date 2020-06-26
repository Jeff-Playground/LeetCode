package com.wen.SeventhFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerBreak {
//    // Logic based on regularities
//    public int integerBreak(int n) {
//        if(n==2 || n==3){
//            return n-1;
//        } else{
//            int result=1;
//            while(n>4){
//                result*=3;
//                n-=3;
//            }
//            result*=n;
//            return result;
//        }
//    }

//    // Logic based on regularities
//    public int integerBreak(int n) {
//        List<Integer> result=new ArrayList<>(Arrays.asList(0,0,1,2,4,6,9));
//        for(int i=7; i<=n; i++){
//            result.add(result.get(i-3)*3);
//        }
//        return result.get(n);
//    }

//    // Logic based on regularities
//    public int integerBreak(int n) {
//        if(n==2 || n==3){
//            return n-1;
//        } else if(n==4){
//            return n;
//        } else{
//            n-=5;
//            return (int)Math.pow(3, n/3+1)*(n%3+2);
//        }
//    }

    // DP
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i-1; j++){
                dp[i]=Math.max(dp[i], Math.max(dp[j]*(i-j), j*(i-j)));
            }
        }
        return dp[n];
    }
}
