package com.wen.NineteenthFifty;

import java.util.Stack;

public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] A) {
        int l=A.length;
        int result=0, mod=(int)Math.pow(10,9)+7;
        int dp[]=new int[l+1];
        // The monotonous stack can be replaced by logic of loop, which takes less space but more time
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<l; i++){
            while(!stack.isEmpty() && (A[i]<A[stack.peek()-1])){
                stack.pop();
            }
            int start=stack.isEmpty()?0:stack.peek();
            dp[i+1]=dp[start]+A[i]*(i+1-start);
            result=(result+dp[i+1])%mod;
            stack.push(i+1);
        }
        return result;
    }
}
