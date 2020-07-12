package com.wen.FourteenthFifty;

import java.util.*;

public class TopKFrequentWords {
//    // Collections.sort
//    public List<String> topKFrequent(String[] words, int k) {
//        List<String> result=new ArrayList<>();
//        Map<String, Integer> freq=new HashMap<>();
//        for(String word: words){
//            freq.put(word, freq.getOrDefault(word, 0)+1);
//        }
//        List<String> keys=new ArrayList<>(freq.keySet());
//        Collections.sort(keys, (a, b)->{
//            int freqDiff=freq.get(b)-freq.get(a);
//            if(freqDiff!=0){
//                return freqDiff;
//            } else{
//                return a.compareTo(b);
//            }
//        });
//        int count=0;
//        while(count<k && count<keys.size()){
//            result.add(keys.get(count++));
//        }
//        return result;
//    }

    // Map and PriorityQueue
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result=new ArrayList<>();
        Map<String, Integer> freq=new HashMap<>();
        for(String word: words){
            freq.put(word, freq.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq=new PriorityQueue<>((a, b)->{
            int freqDiff=b.getValue()-a.getValue();
            if(freqDiff!=0){
                return freqDiff;
            } else{
                return a.getKey().compareTo(b.getKey());
            }
        });
        for(Map.Entry<String, Integer> entry: freq.entrySet()){
            pq.offer(entry);
        }
        int count=0;
        while(count<k && !pq.isEmpty()){
            result.add(pq.poll().getKey());
            count++;
        }
        return result;
    }
}
