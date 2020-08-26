package com.wen.TwentyEighthFifty;

import java.util.Arrays;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int l=nums.length;
        int[] result=new int[l];
        Integer[] idxSort=new Integer[l];
        for(int i=0; i<l; i++){
            idxSort[i]=i;
        }
        Arrays.sort(idxSort, (a, b)->nums[a]-nums[b]);
        for(int i=0; i<l; i++){
            int idx=idxSort[i];
            int pre=i-1;
            while(pre>=0 && nums[idxSort[pre]]==nums[idx]){
                pre--;
            }
            result[idx]=pre+1;
        }
        return result;
    }
}
