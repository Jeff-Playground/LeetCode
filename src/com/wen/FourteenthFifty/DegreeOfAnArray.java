package com.wen.FourteenthFifty;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        int l=nums.length;
        Map<Integer, Integer> start=new HashMap<>();
        // Doesn't need this considering each iteration will have i with end value
//        Map<Integer, Integer> end=new HashMap<>();
        Map<Integer, Integer> degree=new HashMap<>();
        int result=l, maxDegree=Integer.MIN_VALUE;
        for(int i=0; i<l; i++){
            if(degree.containsKey(nums[i])){
                degree.put(nums[i], degree.get(nums[i])+1);
            } else{
                start.put(nums[i], i);
                degree.put(nums[i], 1);
            }
            if(degree.get(nums[i])>maxDegree){
                maxDegree=degree.get(nums[i]);
                result=i-start.get(nums[i])+1;
            } else if(degree.get(nums[i])==maxDegree){
                result=Math.min(result, i-start.get(nums[i])+1);
            }
        }
        return result;
    }
}
