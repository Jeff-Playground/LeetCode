package com.wen.TwelfthFifty;

import java.util.Arrays;

public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        int l=nums.length;
        Arrays.sort(nums);
        int result=0;
        for(int i=0; i<l-1; i+=2){
            result+=nums[i];
        }
        return result;
    }
}
