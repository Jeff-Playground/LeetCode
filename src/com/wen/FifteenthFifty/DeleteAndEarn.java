package com.wen.FifteenthFifty;

import java.util.*;

public class DeleteAndEarn {
    // DP, top down
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> sortedCount=new TreeMap<>();
        for(int n: nums){
            sortedCount.put(n, sortedCount.getOrDefault(n, 0)+1);
        }
        List<Integer> keys=new ArrayList<>(), values=new ArrayList<>();
        for(int k: sortedCount.keySet()){
            keys.add(k);
            values.add(k*sortedCount.get(k));
        }
        Map<Integer, Integer> cache=new HashMap<>();
        cache.put(0, values.get(0));
        if(values.size()>1){
            cache.put(1, Math.max(values.get(1)+(keys.get(1)-1==keys.get(0)?0:values.get(0)), values.get(0)));
        }
        return daeHelper(keys, values,cache, sortedCount.size()-1);
    }

    private int daeHelper(List<Integer> keys, List<Integer> values, Map<Integer, Integer> cache, int i){
        if(!cache.containsKey(i)){
            cache.put(i, Math.max((keys.get(i)-1==keys.get(i-1)?daeHelper(keys, values, cache, i-2):daeHelper(keys, values, cache, i-1))+values.get(i), daeHelper(keys, values, cache, i-1)));
        }
        return cache.get(i);
    }

    // DP, bottom up, dp[i] stands for the maximum value when the i-th smallest number is considered, note considered
    // doesn't necessarily mean included
//    public int deleteAndEarn(int[] nums) {
//        Map<Integer, Integer> count=new HashMap<>();
//        for(int num: nums){
//            count.put(num, count.getOrDefault(num, 0)+1);
//        }
//        TreeMap<Integer, Integer> value=new TreeMap<>();
//        for(int key: count.keySet()){
//            value.put(key, key*count.get(key));
//        }
//        int size=value.size(), i=0;
//        int[] dp=new int[size];
//        for(int key: value.keySet()){
//            if(i==0){
//                dp[i]=value.get(key);
//            } else if(i==1){
//                dp[1]=value.get(key)+(value.containsKey(key-1)?0:dp[0]);
//                dp[1]=Math.max(dp[1], dp[0]);
//            } else{
//                dp[i]=value.get(key)+(value.containsKey(key-1)?dp[i-2]:dp[i-1]);
//                dp[i]=Math.max(dp[i], dp[i-1]);
//            }
//            i++;
//        }
//        return dp[size-1];
//    }
}
