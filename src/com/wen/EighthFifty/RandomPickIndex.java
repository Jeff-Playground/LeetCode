package com.wen.EighthFifty;

import java.util.*;

public class RandomPickIndex {
    // Reservoir sampling
    class Solution {
        int[] nums;
        Random r=new Random();

        public Solution(int[] nums) {
            this.nums=nums;
        }

        public int pick(int target) {
            int count=0, result=-1;
            for(int i=0; i<nums.length; i++){
                if(nums[i]==target){
                    count++;
                    if(r.nextInt(count)==0){
                        result=i;
                    }
                }
            }
            return result;
        }
    }

//    class Solution {
//        Map<Integer, List<Integer>> map;
//        Random r=new Random();
//
//        public Solution(int[] nums) {
//            map=new HashMap<>();
//            for(int i=0; i<nums.length; i++){
//                List<Integer> index=map.getOrDefault(nums[i], new ArrayList<>());
//                index.add(i);
//                map.put(nums[i], index);
//            }
//        }
//
//        public int pick(int target) {
//            if(map.containsKey(target)){
//                List<Integer> index=map.get(target);
//                int n=index.size();
//                return index.get(r.nextInt(n));
//            } else {
//                return -1;
//            }
//        }
//    }
}
