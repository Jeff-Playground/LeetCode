package com.wen.TenthFifty;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result=new int[nums1.length];
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], i);
        }
        Stack<Integer> stack=new Stack<>();
        for(int i=nums2.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<nums2[i]){
                stack.pop();
            }
            if(stack.isEmpty() || stack.peek()>nums2[i]){
                if(map.containsKey(nums2[i])){
                    if(stack.isEmpty()){
                        result[map.get(nums2[i])]=-1;
                    } else{
                        result[map.get(nums2[i])]=stack.peek();
                    }
                }
                stack.push(nums2[i]);
            }
        }
        return result;
    }
}
