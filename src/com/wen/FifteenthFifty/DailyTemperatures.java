package com.wen.FifteenthFifty;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int l=temperatures.length;
        int[] result=new int[l];
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<l; i++){
            int cur=temperatures[i];
            while(!stack.isEmpty() && cur>temperatures[stack.peek()]){
                int idx=stack.pop();
                result[idx]=i-idx;
            }
            stack.push(i);
        }
        return result;
    }
}
