package com.wen.FourteenthFifty;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int result=0;
        if(nums==null || nums.length==0){
            return result;
        }
        int length=0, last=-1;
        for(int num: nums){
            if(length==0){
                last=num;
                length++;
            } else{
                if(num>last){
                    last=num;
                    length++;
                } else{
                    result=Math.max(result, length);
                    length=1;
                    last=num;
                }
            }
        }
        result=Math.max(result, length);
        return result;
    }
}
