package com.wen.FirstFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length<3){
            return result;
        }
        Arrays.sort(nums);
        for(int k=0; k<nums.length; k++){
            if(nums[k]>0){
                break;
            }
            if(k>0 && nums[k]==nums[k-1]){
                continue;
            }
            int target=0-nums[k];
            int i=k+1, j=nums.length-1;
            while(i<j){
                if(nums[i]+nums[j]==target){
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[k]);
                    l.add(nums[i]);
                    l.add(nums[j]);
                    result.add(l);
                    while(i<j && nums[i]==nums[i+1]){
                        i++;
                    }
                    while(i<j && nums[j]==nums[j-1]){
                        j--;
                    }
                    i++;
                    j--;
                } else if(nums[i]+nums[j]<target){
                    i++;
                } else{
                    j--;
                }
            }
        }
        return result;
    }
}
