package com.wen.ThirdFifty;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int result=0;
        Map<Integer, Integer> map=new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)){
                continue;
            }
            int left=map.containsKey(num-1)?map.get(num-1):0;
            int right=map.containsKey(num+1)?map.get(num+1):0;
            int sum=left+right+1;
            map.put(num, sum);
            result=Math.max(result, sum);
            map.put(num-left, sum);
            map.put(num+right, sum);
        }
        return result;
    }

//    public int longestConsecutive(int[] nums) {
//        int result=0;
//        Set<Integer> set=new HashSet<>();
//        set.addAll(IntStream.of(nums).boxed().collect(Collectors.toList()));
//        for(int num: nums){
//            if(set.contains(num)){
//                set.remove(num);
//                int pre=num-1, next=num+1;
//                while(set.contains(pre)){
//                    set.remove(pre);
//                    pre--;
//                }
//                while(set.contains(next)){
//                    set.remove(next);
//                    next++;
//                }
//                result=Math.max(result, next-pre-1);
//            }
//        }
//        return result;
//    }
}
