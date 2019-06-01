package com.wen.SeventhFifty;

import java.util.*;

public class TopKFrequentElements {
    // Collections.sort
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result=new ArrayList<>();
        Map<Integer, Integer> freq=new TreeMap<>();
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        List<Integer> keys=new ArrayList<>(freq.keySet());
        Collections.sort(keys, (a,b)->{
            return freq.get(b)-freq.get(a);
        });
        int count=0;
        while(count<k && count<keys.size()){
            result.add(keys.get(count++));
        }
        return result;
    }

//    // Map and PriorityQueue
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        List<Integer> result=new ArrayList<>();
//        Map<Integer, Integer> freq=new HashMap<>();
//        for(int num: nums){
//            freq.put(num, freq.getOrDefault(num, 0)+1);
//        }
//        PriorityQueue<Map.Entry<Integer, Integer>> pq=new PriorityQueue<>((a, b)->b.getValue()-a.getValue());
//        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
//            pq.offer(entry);
//        }
//        int count=0;
//        while(count<k && !pq.isEmpty()){
//            result.add(pq.poll().getKey());
//            count++;
//        }
//        return result;
//    }
}
