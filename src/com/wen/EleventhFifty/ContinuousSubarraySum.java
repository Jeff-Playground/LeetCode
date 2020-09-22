package com.wen.EleventhFifty;

import java.util.HashSet;
import java.util.Set;

public class ContinuousSubarraySum {
    // Optimized to use one loop for both k==0 and k!=0
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums==null || nums.length<2){
            return false;
        }
        int l=nums.length;
        Set<Integer> visited=new HashSet<>();
        k=Math.abs(k);
        nums[0]=k==0?nums[0]:nums[0]%k;
        int last=nums[0];
        for(int i=1; i<l; i++){
            nums[i]=k==0?nums[i-1]+nums[i]:(nums[i-1]+nums[i])%k;
            if(nums[i]==0 || visited.contains(nums[i])){
                return true;
            }
            visited.add(last);
            last=nums[i];
        }
        return false;
    }

//    public boolean checkSubarraySum(int[] nums, int k) {
//        if(nums==null || nums.length<2){
//            return false;
//        }
//        int l=nums.length;
//        if(k==0){
//            for(int i=0; i<l-1; i++){
//                if(nums[i]==0 && nums[i+1]==0){
//                    return true;
//                }
//            }
//        } else{
//            Set<Integer> visited=new HashSet<>();
//            k=Math.abs(k);
//            nums[0]=nums[0]%k;
//            int last=nums[0];
//            for(int i=1; i<l; i++){
//                nums[i]=(nums[i-1]+nums[i])%k;
//                if(nums[i]==0 || visited.contains(nums[i])){
//                    return true;
//                }
//                visited.add(last);
//                last=nums[i];
//            }
//        }
//        return false;
//    }
}
