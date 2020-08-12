package com.wen.NinthFifty;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    // Sort and put numbers in their corresponding index, then check mismatches
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<>();
        if(nums==null || nums.length==0){
            return result;
        }
        int l=nums.length;
        for(int i=0; i<l; i++){
            int cur=nums[i];
            while(cur!=i+1){
                nums[i]=nums[cur-1];
                nums[cur-1]=cur;
                if(nums[i]==cur){
                    break;
                } else{
                    cur=nums[i];
                }
            }
        }
        for(int i=0; i<l; i++){
            if(nums[i]!=i+1){
                result.add(i+1);
            }
        }
        return result;
    }

//    // Mark corresponding number at index to be negative to identify appeared numbers
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> result=new ArrayList<>();
//        if(nums==null || nums.length==0){
//            return result;
//        }
//        int l=nums.length;
//        for(int num: nums){
//            int idx=Math.abs(num)-1;
//            if(nums[idx]>0){
//                nums[idx]=-nums[idx];
//            }
//        }
//        for(int i=0; i<l; i++){
//            if(nums[i]>0){
//                result.add(i+1);
//            }
//        }
//        return result;
//    }

//    // Add l to the number at corresponding index, then check which number is less than l+1
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> result=new ArrayList<>();
//        if(nums==null || nums.length==0){
//            return result;
//        }
//        int l=nums.length;
//        for(int num: nums){
//            nums[(num-1)%l]+=l;
//        }
//        for(int i=0; i<l; i++){
//            if(nums[i]<l+1){
//                result.add(i+1);
//            }
//        }
//        return result;
//    }
}
