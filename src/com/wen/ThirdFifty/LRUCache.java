package com.wen.ThirdFifty;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class CacheEntry{
        int key;
        int value;
        CacheEntry pre;
        CacheEntry next;

        public CacheEntry(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    private int capacity;
    private Map<Integer, CacheEntry> map=new HashMap<>();
    private CacheEntry head, tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new CacheEntry(-1, -1);
        tail=new CacheEntry(-1, -1);
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            CacheEntry entry=map.get(key);
            moveToHead(entry);
            return entry.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            CacheEntry existing=map.get(key);
            existing.value=value;
            moveToHead(existing);
        } else {
            CacheEntry newEntry=new CacheEntry(key, value);
            moveToHead(newEntry);
            if(map.size()==capacity){
                int tailKey=removeTail();
                map.remove(tailKey);
            }
            map.put(key, newEntry);
        }
    }

    private int removeTail() {
        CacheEntry preTail=tail.pre;
        preTail.pre.next=tail;
        tail.pre=preTail.pre;
        preTail.pre=null;
        preTail.next=null;
        return preTail.key;
    }

    private void moveToHead(CacheEntry entry) {
        if(entry.pre!=null && entry.next!=null){
            entry.pre.next=entry.next;
            entry.next.pre=entry.pre;
        }
        entry.pre=head;
        entry.next=head.next;
        head.next.pre=entry;
        head.next=entry;
    }
}
