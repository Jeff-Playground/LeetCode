package com.wen.NinthFifty;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    // Add l to the number at corresponding index, then check which number is larger than 2*l
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result=new ArrayList<>();
        if(nums==null || nums.length<=1){
            return result;
        }
        int l=nums.length;
        for(int i=0; i<l; i++){
            nums[(nums[i]-1)%l]+=l;
        }
        for(int i=0; i<l; i++){
            if(nums[i]>2*l){
                result.add(i+1);
            }
        }
        return result;
    }

//    // Sort and put numbers in there corresponding index, then check mismatches
//    public List<Integer> findDuplicates(int[] nums) {
//        List<Integer> result=new ArrayList<>();
//        if(nums==null || nums.length<=1){
//            return result;
//        }
//        int i=0;
//        while(i<nums.length){
//            int cur=nums[i];
//            while(cur!=i+1){
//                int idx=cur-1;
//                nums[i]=nums[idx];
//                if(nums[idx]==cur){
//                    break;
//                } else{
//                    nums[idx]=cur;
//                }
//                cur=nums[i];
//            }
//            i++;
//        }
//        for(i=0; i<nums.length; i++){
//            if(nums[i]!=i+1){
//                result.add(nums[i]);
//            }
//        }
//        return result;
//    }

//    // Mark corresponding number at index to be negative to identify appeared numbers
//    public List<Integer> findDuplicates(int[] nums) {
//        List<Integer> result=new ArrayList<>();
//        if(nums==null || nums.length<=1){
//            return result;
//        }
//        for(int i=0; i<nums.length; i++){
//            int idx=Math.abs(nums[i])-1;
//            if(nums[idx]<0){
//                result.add(idx+1);
//            } else{
//                nums[idx]=-nums[idx];
//            }
//        }
//        return result;
//    }
}
