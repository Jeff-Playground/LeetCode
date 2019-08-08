package com.wen.FifteenthFifty;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int l=T.length;
        int[] result=new int[l];
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<l; i++){
            if(!stack.isEmpty() && T[i]>T[stack.peek()]){
                while(!stack.isEmpty() && T[i]>T[stack.peek()]){
                    int idx=stack.pop();
                    result[idx]=i-idx;
                }
            }
            stack.push(i);
        }
        return result;
    }
}
