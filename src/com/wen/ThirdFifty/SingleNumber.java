package com.wen.ThirdFifty;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int num: nums){
            result^=num;
        }
        return result;
    }

//    // This is not O(1) space complexity
//    public int singleNumber(int[] nums) {
//        Set<Integer> set=new HashSet<>();
//        for(int num: nums){
//            if(set.contains(num)){
//                set.remove(num);
//            } else{
//                set.add(num);
//            }
//        }
//        return set.iterator().next();
//    }
}
