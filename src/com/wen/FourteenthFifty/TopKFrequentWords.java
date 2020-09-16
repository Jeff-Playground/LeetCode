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
//        Collections.sort(keys, (a, b)->freq.get(a)!=freq.get(b)?freq.get(b)-freq.get(a):a.compareTo(b));
//        int count=0;
//        while(count<k && count<keys.size()){
//            result.add(keys.get(count++));
//        }
//        return result;
//    }

//    // Map and PriorityQueue implementing maxHeap
//    public List<String> topKFrequent(String[] words, int k) {
//        List<String> result=new ArrayList<>();
//        Map<String, Integer> freq=new HashMap<>();
//        for(String word: words){
//            freq.put(word, freq.getOrDefault(word, 0)+1);
//        }
//        PriorityQueue<String> pq=new PriorityQueue<>(
//                (a, b)->freq.get(a)!=freq.get(b)?freq.get(b)-freq.get(a):a.compareTo(b));
//        for(String word: freq.keySet()){
//            pq.offer(word);
//        }
//        int count=0;
//        while(count<k && !pq.isEmpty()){
//            result.add(pq.poll());
//            count++;
//        }
//        return result;
//    }

    // Map and PriorityQueue implementing minHeap
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result=new ArrayList<>();
        Map<String, Integer> freq=new HashMap<>();
        for(String word: words){
            freq.put(word, freq.getOrDefault(word, 0)+1);
        }
        PriorityQueue<String> pq=new PriorityQueue<>(
                (a, b)->freq.get(a)!=freq.get(b)?freq.get(a)-freq.get(b):b.compareTo(a));
        for(String word: freq.keySet()){
            pq.offer(word);
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            result.add(0, pq.poll());
        }
        return result;
    }
}
