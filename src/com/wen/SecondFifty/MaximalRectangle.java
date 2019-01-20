package com.wen.SecondFifty;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int result=0;
        if(matrix.length==0){
            return result;
        }
        int m=matrix.length, n=matrix[0].length;
        int[] heights=new int[n];
        int[] lefts=new int[n];
        int[] rights=new int[n];
        Arrays.fill(rights, n);
        for(int i=0; i<m; i++){
            int currentLeft=0, currentRight=n;
            for(int j=0; j<n; j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                } else{
                    heights[j]=0;
                }
            }
            for(int j=0; j<n; j++){
                if(matrix[i][j]=='1'){
                    lefts[j]=Math.max(currentLeft, lefts[j]);
                } else{
                    lefts[j]=0;
                    currentLeft=j+1;
                }
            }
            for(int j=n-1; j>=0; j--){
                if(matrix[i][j]=='1'){
                    rights[j]=Math.min(currentRight, rights[j]);
                } else{
                    rights[j]=n;
                    currentRight=j;
                }
            }
            for(int j=0; j<n; j++){
                result=Math.max(result, (rights[j]-lefts[j])*heights[j]);
            }
        }
        return result;
    }

//    // Use existing method from LargestRectangleInHistogram
//    public static int maximalRectangle(char[][] matrix) {
//        int result=0;
//        if(matrix.length==0){
//            return result;
//        }
//        int[] heights=new int[matrix[0].length];
//        for(int i=0; i<matrix.length; i++){
//            for(int j=0; j<matrix[i].length; j++){
//                heights[j]=matrix[i][j]=='0' ? 0 : (1+heights[j]);
//            }
//            result=Math.max(result, largestRectangleArea(heights));
//        }
//        return result;
//    }
//
//    public static int largestRectangleArea(int[] heights) {
//        int result=0;
//        int l=heights.length;
//        Stack<Integer> stack=new Stack<>();
//        for(int i=0; i<=l; i++){
//            int h=i==l ? 0 : heights[i];
//            if(stack.isEmpty() || heights[stack.peek()]<h){
//                stack.push(i);
//            } else{
//                int top=stack.pop();
//                result=Math.max(result, heights[top]*(stack.isEmpty() ? i : (i-1-stack.peek())));
//                i--;
//            }
//        }
//        return result;
//    }
}
