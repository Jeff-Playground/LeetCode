package com.wen.NinthFifty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitArrayLargestSum {
    // Binary search
    public static int splitArray(int[] nums, int m) {
        int min=nums[0], max=0;
        for(int num: nums){
            min=Math.max(min, num);
            max+=num;
        }
        if(m==1){
            return max;
        } else if(m==nums.length){
            return min;
        } else{
            while(min<max){
                int mid=min+(max-min)/2;
                if(canSplit(nums, m, mid)){
                    max=mid;
                } else{
                    min=mid+1;
                }
            }
            return min;
        }
    }

    private static boolean canSplit(int[] nums, int m, int max){
        int count=1, cur=0;
        for(int num: nums){
            if(cur+num<=max){
                cur+=num;
            } else{
                count++;
                cur=num;
            }
        }
        return count<=m;
    }

//    // Dynamic programming
//    public int splitArray(int[] nums, int m) {
//        return saHelper(nums, m, 0, nums.length-1, new HashMap<>());
//    }
//
//    private int saHelper(int[] nums, int m, int start, int end, Map<List<Integer>, Integer> cache){
//        List<Integer> key=Arrays.asList(start, end, m);
//        if(cache.containsKey(key)){
//            return cache.get(key);
//        } else{
//            int result=0;
//            if(m==1){
//                result=0;
//                for(int i=start; i<=end; i++){
//                    result+=nums[i];
//                }
//            } else{
//                result=Integer.MAX_VALUE;
//                int cur=0;
//                for(int i=start; end-i>=m-1; i++){
//                    cur+=nums[i];
//                    int remain=saHelper(nums, m-1, i+1, end, cache);
//                    int max=Math.max(cur, remain);
//                    result=Math.min(result, max);
//                    if(cur>=remain){
//                        break;
//                    }
//                }
//            }
//            cache.put(key, result);
//            return result;
//        }
//    }
}
