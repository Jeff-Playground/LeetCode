package com.wen.SeventhFifty;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    // Binary insertion sort
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int[] sorted=new int[nums.length];
        int length=0;
        for(int i=nums.length-1; i>=0; i--) {
            if(length==0) {
                sorted[length++]=nums[i];
                result.add(0,length-1);
            } else {
                if(nums[i]<=sorted[length-1]) {
                    int left=0, right=length-1;
                    while(left<=right) {
                        int mid=left+(right-left)/2;
                        if(sorted[mid]<nums[i]) {
                            left=mid+1;
                        } else {
                            right=mid-1;
                        }
                    }
                    for(int j=length++; j>left; j--) {
                        sorted[j]=sorted[j-1];
                    }
                    sorted[left]=nums[i];
                    result.add(0,left);
                } else {
                    sorted[length++]=nums[i];
                    result.add(0,length-1);
                }
            }
        }
        return result;
    }
}
