package com.wen.FourthFifty;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
//    // Bit manipulation
//    public int majorityElement(int[] nums) {
//        int result=0, n=nums.length;
//        for(int i=0; i<32; i++){
//            int ones=0, zeros=0;
//            for(int num: nums){
//                if(ones>n/2 || zeros>n/2){
//                    break;
//                }
//                if((num&(1<<i))!=0){
//                    ones++;
//                } else{
//                    zeros++;
//                }
//            }
//            if(ones>zeros){
//                result|=(1<<i);
//            }
//        }
//        return result;
//    }

    // Moore voting method, this only works when there is a solution exists(added logic to handle when not exists)
    // O(n) time complexity and O(1) space complexity
    // This method can extend to a problem for finding num for which appear time>n/3
    public int majorityElement(int[] nums) {
        int result=0, count=0;
        for(int num: nums){
            if(count==0){
                result=num;
                count++;
            } else{
                if(num==result){
                    count++;
                } else{
                    count--;
                }
            }
        }
        // if not exist return Integer.MIN_VALUE
        count=0;
        for(int num: nums){
            if(num==result){
                count++;
            }
        }
        if(count<nums.length/2){
            result=Integer.MIN_VALUE;
        }
        return result;
    }

//    // HashMap with O(n) time complexity and O(n) space complexity
//    public int majorityElement(int[] nums) {
//        int n=nums.length;
//        Map<Integer, Integer> occurence=new HashMap<>();
//        for(int num: nums){
//            occurence.put(num, occurence.getOrDefault(num, 0)+1);
//            if(occurence.get(num)>n/2){
//                return num;
//            }
//        }
//        return -1;
//    }
}
