package com.wen.ThirteenthFifty;

public class TwoKeysKeyboard {
    // DP, dp[i] stands for the min steps required to produce i
    public int minSteps(int n) {
        int[] dp=new int[n+1];
        for(int i=2; i<=n; i++){
            dp[i]=i;
            for(int j=i-1; j>1; j--){
                if(i%j==0){
                    dp[i]=Math.min(dp[i], dp[j]+i/j);
                }
            }
        }
        return dp[n];
    }

//    // Optimized DP, the idea is also making last pasting as few as possible
//    public int minSteps(int n) {
//        int[] dp=new int[n+1];
//        for(int i=2; i<=n; i++){
//            dp[i]=i;
//            for(int j=i-1; j>1; j--){
//                if(i%j==0){
//                    dp[i]=Math.min(dp[i], dp[j]+i/j);
//                }
//            }
//        }
//        return dp[n];
//    }

//    // Recursion, make each attempt as pasting last string for i times
//    public int minSteps(int n) {
//        if(n==1){
//            return 0;
//        } else{
//            int result=n;
//            for(int i=n-1; i>1; i--){
//                if(n%i==0){
//                    result=Math.min(result, minSteps(n/i)+i);
//                }
//            }
//            return result;
//        }
//    }

//    // Optimized recursion, note here the idea is making last pasting as few as possible
//    public int minSteps(int n) {
//        if(n==1){
//            return 0;
//        } else{
//            int result=n;
//            for(int i=2; i<n; i++){
//                if(n%i==0){
//                    result=Math.min(result, minSteps(n/i)+i);
//                    break;
//                }
//            }
//            return result;
//        }
//    }
}
