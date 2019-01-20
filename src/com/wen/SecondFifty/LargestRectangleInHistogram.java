package com.wen.SecondFifty;

import java.util.Stack;

public class LargestRectangleInHistogram {
    // Stack
    public static int largestRectangleArea(int[] heights) {
        int result=0;
        int l=heights.length;
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<=l; i++){
            int h=i==l ? 0 : heights[i];
            if(stack.isEmpty() || heights[stack.peek()]<h){
                stack.push(i);
            } else{
                int top=stack.pop();
                result=Math.max(result, heights[top]*(stack.isEmpty() ? i : (i-1-stack.peek())));
                i--;
            }
        }
        return result;
    }

//    public static int largestRectangleArea(int[] heights) {
//        int result=0;
//        int l=heights.length;
//        for(int i=0; i<l; i++){
//            if(i+1<l && heights[i]<=heights[i+1]){
//                continue;
//            }
//            int minH=heights[i];
//            for(int j=i; j>=0; j--){
//                minH=Math.min(minH, heights[j]);
//                int area=minH*(i-j+1);
//                result=Math.max(result, area);
//            }
//        }
//        return result;
//    }

//    // Dynamic Programming(Brutal force, exceeds maximum memory limit)
//    public int largestRectangleArea(int[] heights) {
//        int result=0;
//        int l=heights.length;
//        int dp[][] = new int[l][l];
//        for(int i=0; i<l; i++){
//            for(int j=i; j<l; j++){
//                if(i==j){
//                    dp[i][j]=heights[i];
//                } else{
//                    dp[i][j]=Math.min(dp[i][j-1]/(j-i),heights[j])*(j-i+1);
//                }
//                result=Math.max(result, dp[i][j]);
//            }
//        }
//        return result;
//    }
}
