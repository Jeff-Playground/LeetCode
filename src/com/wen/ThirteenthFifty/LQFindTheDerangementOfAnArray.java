package com.wen.ThirteenthFifty;

/*
In combinatorial mathematics, a derangement is a permutation of the elements of a set, such that no element appears in
its original position.

There's originally an array consisting of n integers from 1 to n in ascending order, you need to find the number of
derangement it can generate.

Also, since the answer may be very large, you should return the output mod 10^9 + 7.

Example 1:
Input: 3
Output: 2
Explanation: The original array is [1,2,3]. The two derangements are [2,3,1] and [3,1,2].

Note:
n is in the range of [1, 10^6].
 */

public class LQFindTheDerangementOfAnArray {
    // DP, optimized to get rid of array
    public int findDerangement(int n) {
        if(n<2){
            return 0;
        }
        int mod=1_000_000_007;
        int a=0, b=1, c=1;
        for(int i=3; i<=n; i++){
            long t=((long)a+b)*(i-1);
            c=(int)(t%mod);
            a=b;
            b=c;
        }
        return c;
    }

//    // DP, note the long/int conversion for avoiding overflow
//    public int findDerangement(int n) {
//        if(n<2){
//            return 0;
//        }
//        int mod=1_000_000_007;
//        int[] dp=new int[n+1];
//        dp[2]=1;
//        for(int i=3; i<=n; i++){
//            long t=((long)dp[i-2]+dp[i-1])*(i-1);
//            dp[i]=(int)(t%mod);
//        }
//        return dp[n];
//    }
}
