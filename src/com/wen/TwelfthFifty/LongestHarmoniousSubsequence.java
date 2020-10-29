package com.wen.TwelfthFifty;

import java.util.*;

public class LongestHarmoniousSubsequence {
    // Single loop HashMap solution, not as efficient as double loop solution, but has simpler code
    public int findLHS(int[] nums) {
        int result=0;
        Map<Integer, Integer> count=new HashMap<>();
        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0)+1);
            if(count.containsKey(num+1)){
                result=Math.max(result, count.get(num)+count.get(num+1));
            }
            if(count.containsKey(num-1)){
                result=Math.max(result, count.get(num)+count.get(num-1));
            }
        }
        return result;
    }

//    // Use a HashMap to store counts of numbers, more efficient than TreeMap
//    public int findLHS(int[] nums) {
//        Map<Integer, Integer> count=new HashMap<>();
//        for(int num: nums){
//            count.put(num, count.getOrDefault(num, 0)+1);
//        }
//        int result=0;
//        for(int key: count.keySet()){
//            if(count.containsKey(key+1)){
//                result=Math.max(result, count.get(key)+count.get(key+1));
//            }
//        }
//        return result;
//    }

//    // Use a TreeMap to sort and store counts of numbers, not very efficient due to TreeMap sort complexity
//    public int findLHS(int[] nums) {
//        TreeMap<Integer, Integer> count=new TreeMap<>();
//        for(int num: nums){
//            count.put(num, count.getOrDefault(num, 0)+1);
//        }
//        Iterator<Integer> itKey=count.keySet().iterator();
//        Iterator<Integer> itValue=count.values().iterator();
//        int lastKey=itKey.next(), lastValue=itValue.next(), result=0;
//        while(itKey.hasNext()){
//            int key=itKey.next(), value=itValue.next();
//            if(lastKey+1==key){
//                result=Math.max(result, lastValue+value);
//            }
//            lastKey=key;
//            lastValue=value;
//        }
//        return result;
//    }

//    // Sliding window
//    public int findLHS(int[] nums) {
//        Arrays.sort(nums);
//        int result=0, left=0, right=0, secondNumStart=0;
//        while(right<nums.length){
//            while(right+1<nums.length && nums[right+1]==nums[right]){
//                right++;
//            }
//            if(nums[left]==nums[right]){
//                secondNumStart=++right;
//            } else{
//                if(nums[left]+1==nums[right]){
//                    result=Math.max(result, right-left+1);
//                }
//                left=secondNumStart;
//            }
//        }
//        return result;
//    }
}
