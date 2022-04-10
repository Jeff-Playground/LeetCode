package com.wen.FifthFifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<i+k+1 && j<nums.length; j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        Map<Integer, List<Integer>> numToIdx=new HashMap<>();
//        for(int i=0; i<nums.length; i++){
//            int num=nums[i];
//            if(numToIdx.containsKey(num)){
//                List<Integer> numIdx=numToIdx.get(num);
//                if(numIdx.get(numIdx.size()-1)+k>=i){
//                    return true;
//                } else{
//                    numIdx.add(i);
//                }
//            } else{
//                numToIdx.put(num, new ArrayList<>());
//                numToIdx.get(num).add(i);
//            }
//        }
//        return false;
//    }
}
