package com.wen.TenthFifty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int[] result=new int[nums1.length];
//        Map<Integer, Integer> indices=new HashMap<>();
//        for(int i=0; i<nums1.length; i++){
//            indices.put(nums1[i], i);
//        }
//        Stack<Integer> stack=new Stack<>();
//        for(int i=nums2.length-1; i>=0; i--){
//            while(!stack.isEmpty() && stack.peek()<nums2[i]){
//                stack.pop();
//            }
//            if(stack.isEmpty() || stack.peek()>nums2[i]){
//                if(indices.containsKey(nums2[i])){
//                    if(stack.isEmpty()){
//                        result[indices.get(nums2[i])]=-1;
//                    } else{
//                        result[indices.get(nums2[i])]=stack.peek();
//                    }
//                }
//                stack.push(nums2[i]);
//            }
//        }
//        return result;
//    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null || nums1.length>nums2.length){
            throw new IllegalArgumentException("Invalid input array(s)!");
        }
        int l1=nums1.length, l2=nums2.length;
        int[] result=new int[l1];
        Arrays.fill(result, -1);
        Map<Integer, Integer> indices=new HashMap<>();
        for(int i=0; i<l1; i++){
            indices.put(nums1[i], i);
        }
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<l2; i++){
            while(!stack.isEmpty() && nums2[stack.peek()]<nums2[i]){
                int index=stack.pop();
                if(indices.containsKey(nums2[index])){
                    result[indices.get(nums2[index])]=nums2[i];
                }
            }
            stack.push(i);
        }
        return result;
    }
}
