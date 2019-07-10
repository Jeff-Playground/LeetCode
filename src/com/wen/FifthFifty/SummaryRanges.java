package com.wen.FifthFifty;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result=new ArrayList<>();
        if(nums==null || nums.length==0) {
            return result;
        }
        int l=nums.length;
        int left=0, right=-1;
        for(int i=0; i<l; i++) {
            if(i+1<l && nums[i]+1==nums[i+1]) {
                continue;
            } else {
                right=i;
                if(left==right) {
                    result.add(nums[left]+"");
                } else {
                    result.add(nums[left]+"->"+nums[right]);
                }
                left=i+1;
                right=i+1;
            }
        }
        return result;
    }
}
