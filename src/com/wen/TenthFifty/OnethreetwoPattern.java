package com.wen.TenthFifty;

import java.util.Stack;

public class OnethreetwoPattern {
    public boolean find132pattern(int[] nums) {
        if(nums==null || nums.length<3){
            return false;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            min=Math.min(min, nums[i]);
            if(nums[i]>min){
                for(int j=i+1; j<nums.length; j++){
                    if(nums[j]>min && nums[j]<nums[i]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

//    // Monotonic stack
//    public boolean find132pattern(int[] nums) {
//        if(nums==null || nums.length<3){
//            return false;
//        }
//        Stack<Integer> stack=new Stack<>();
//        int third=Integer.MIN_VALUE;
//        for(int i=nums.length-1; i>=0; i--){
//            if(nums[i]<third){
//                return true;
//            }
//            while(!stack.isEmpty() && nums[i]>stack.peek()){
//                third=stack.pop();
//            }
//            stack.push(nums[i]);
//        }
//        return false;
//    }
}
