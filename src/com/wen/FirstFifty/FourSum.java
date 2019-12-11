package com.wen.FirstFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length<4) {
            return result;
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++) {
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            for(int j=i+1; j<nums.length-2; j++) {
                if(j>i+1 && nums[j]==nums[j-1]) {
                    continue;
                }
                int m=j+1, n=nums.length-1;
                while(m<n) {
                    if(nums[i]+nums[j]+nums[m]+nums[n]==target) {
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[m]);
                        temp.add(nums[n]);
                        result.add(temp);
                        m++;
                        n--;
                        while(m<n && nums[m]==nums[m-1]) {
                            m++;
                        }
                        while(m<n && nums[n]==nums[n+1]) {
                            n--;
                        }
                    } else if(nums[i]+nums[j]+nums[m]+nums[n]>target) {
                        n--;
                    } else {
                        m++;
                    }
                }
            }
        }
        return result;
    }
}
