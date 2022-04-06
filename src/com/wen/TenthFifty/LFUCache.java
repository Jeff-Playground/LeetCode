package com.wen.TenthFifty;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    // Note use LinkedHashSet here to maintain the order of the keys hitting a certain count
    class LFUcache {
        private int capacity, minFreq;
        private Map<Integer, Integer> cache, freq;
        private Map<Integer, LinkedHashSet<Integer>> count;

        public LFUcache(int capacity) {
            this.capacity=capacity;
            minFreq=Integer.MAX_VALUE;
            cache=new HashMap<>();
            freq=new HashMap<>();
            count=new HashMap<>();
        }

        public int get(int key) {
            if(cache.containsKey(key)){
                int curFreq=freq.get(key);
                freq.put(key, curFreq+1);
                count.get(curFreq).remove(key);
                if(count.get(curFreq).size()==0){
                    count.remove(curFreq);
                    if(curFreq==minFreq){
                        minFreq++;
                    }
                }
                count.putIfAbsent(curFreq+1, new LinkedHashSet<>());
                count.get(curFreq+1).add(key);
                return cache.get(key);
            } else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(capacity==0){
                return;
            }
            if(cache.containsKey(key)){
                get(key);
            } else{
                if(cache.size()==capacity){
                    int delete=count.get(minFreq).iterator().next();
                    count.get(minFreq).remove(delete);
                    cache.remove(delete);
                    freq.remove(delete);
                    if(count.get(minFreq).size()==0){
                        count.remove(minFreq);
                    }
                }
                freq.put(key, 1);
                minFreq=1;
                count.putIfAbsent(1, new LinkedHashSet<>());
                count.get(1).add(key);
            }
            cache.put(key, value);
        }
    }
}
