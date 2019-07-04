package com.wen.FourthFifty;

import java.util.ArrayList;
import java.util.List;

public class LQMissingRanges {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result=new ArrayList<>();
        if(nums.length==0){
            if(lower==upper){
                result.add(String.valueOf(lower));
            } else{
                result.add(String.valueOf(lower)+"->"+String.valueOf(upper));
            }
            return result;
        }
        int cur=lower;
        for(int i=0; i<nums.length; i++){
            if(cur<nums[i]){
                if(cur+1==nums[i]){
                    result.add(String.valueOf(cur));
                } else{
                    result.add(String.valueOf(cur)+"->"+String.valueOf(nums[i]-1));
                }
            }
            cur=nums[i]+1;
            // This is to make sure overflow(when nums[i]+1==Integer.MAX_VALUE) doesn't affect result
            if(cur==Integer.MIN_VALUE){
                break;
            }
        }
        if(upper>nums[nums.length-1]){
            if(upper-1==nums[nums.length-1]){
                result.add(String.valueOf(upper));
            } else{
                result.add(String.valueOf(nums[nums.length-1]+1)+"->"+String.valueOf(upper));
            }
        }
        return result;
    }
}
