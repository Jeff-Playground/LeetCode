package com.wen.EleventhFifty;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int l=nums.length;
        int[] result=new int[l];
        Arrays.fill(result, -1);
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<2*l; i++){
            int num=nums[i%l];
            while(!stack.isEmpty() && nums[stack.peek()]<num){
                result[stack.pop()]=num;
            }
            if(i<l){
                stack.push(i);
            }
        }
        return result;
    }
}
