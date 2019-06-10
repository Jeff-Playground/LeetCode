package com.wen.FifthFifty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }

//    public boolean containsDuplicate(int[] nums) {
//        Set<Integer> set=new HashSet<>();
//        for(int num: nums){
//            if(set.contains(num)){
//                return true;
//            } else{
//                set.add(num);
//            }
//        }
//        return false;
//    }
}
