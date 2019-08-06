package com.wen.FourteenthFifty;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        int l=nums.length;
        Map<Integer, Integer> start=new HashMap<>();
        // Doesn't need this considering each iteration will have i with end value
        // Map<Integer, Integer> end=new HashMap<>();
        Map<Integer, Integer> count=new HashMap<>();
        int result=l, degree=Integer.MIN_VALUE;
        for(int i=0; i<l; i++){
            if(count.containsKey(nums[i])){
                count.put(nums[i], count.get(nums[i])+1);
            } else{
                start.put(nums[i], i);
                count.put(nums[i], 1);
            }
            if(count.get(nums[i])>degree){
                degree=count.get(nums[i]);
                result=i-start.get(nums[i])+1;
            } else if(count.get(nums[i])==degree){
                result=Math.min(result, i-start.get(nums[i])+1);
            }
        }
        return result;
    }
}
