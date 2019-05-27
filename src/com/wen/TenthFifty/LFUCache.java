package com.wen.TenthFifty;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    private int capacity;
    private int minFreq;
    Map<Integer, Integer> map;
    Map<Integer, Integer> freq;
    Map<Integer, LinkedHashSet<Integer>> occur;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.minFreq=0;
        this.map=new HashMap<>();
        this.freq=new HashMap<>();
        this.occur=new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int keyFreq=freq.get(key);
            freq.put(key, keyFreq+1);
            occur.get(keyFreq).remove(key);
            if(keyFreq==minFreq && occur.get(keyFreq).isEmpty()){
                minFreq++;
            }
            if(!occur.containsKey(keyFreq+1)){
                occur.put(keyFreq+1, new LinkedHashSet<Integer>());
            }
            occur.get(keyFreq+1).add(key);
            return map.get(key);
        } else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(capacity<=0){
            return;
        }
        if(map.containsKey(key)){
            int keyFreq=freq.get(key);
            freq.put(key, keyFreq+1);
            occur.get(keyFreq).remove(key);
            if(keyFreq==minFreq && occur.get(keyFreq).isEmpty()){
                minFreq++;
            }
            if(!occur.containsKey(keyFreq+1)){
                occur.put(keyFreq+1, new LinkedHashSet<Integer>());
            }
            occur.get(keyFreq+1).add(key);
            map.put(key, value);
        } else{
            if(map.size()==capacity){
                int delete=occur.get(minFreq).iterator().next();
                occur.get(minFreq).remove(delete);
                map.remove(delete);
                freq.remove(delete);
            }
            freq.put(key, 1);
            minFreq=1;
            if(!occur.containsKey(1)){
                occur.put(1, new LinkedHashSet<Integer>());
            }
            occur.get(1).add(key);
            map.put(key, value);
        }
    }
}
