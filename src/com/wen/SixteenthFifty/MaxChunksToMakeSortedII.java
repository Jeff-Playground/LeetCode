package com.wen.SixteenthFifty;

import java.util.Arrays;
import java.util.Stack;

public class MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        if(arr==null || arr.length<2){
            return 1;
        }
        int l=arr.length;
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<l; i++) {
            if(stack.isEmpty() || arr[stack.peek()]<=arr[i]) {
                stack.push(i);
            } else {
                int curMax=stack.pop();
                while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) {
                    stack.pop();
                }
                stack.push(curMax);
            }
        }
        return stack.size();
    }

//    public int maxChunksToSorted(int[] arr) {
//        if(arr==null || arr.length<2){
//            return 1;
//        }
//        int l=arr.length;
//        int[] min=new int[l];
//        min[l-1]=arr[l-1];
//        for(int i=l-2; i>=0; i--) {
//            min[i]=Math.min(min[i+1], arr[i]);
//        }
//        int result=1, max=Integer.MIN_VALUE;
//        for(int i=0; i<l-1; i++) {
//            max=Math.max(max, arr[i]);
//            if(max<=min[i+1]) {
//                result++;
//            }
//        }
//        return result;
//    }

//    public int maxChunksToSorted(int[] arr) {
//        if(arr==null || arr.length<2){
//            return 1;
//        }
//        int[] sorted=Arrays.copyOf(arr, arr.length);
//        Arrays.sort(sorted);
//        int result=0, sum1=0, sum2=0;
//        for(int i=0; i<arr.length; i++){
//            sum1+=arr[i];
//            sum2+=sorted[i];
//            if(sum1==sum2) {
//                result++;
//            }
//        }
//        return result;
//    }
}
