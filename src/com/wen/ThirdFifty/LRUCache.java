package com.wen.ThirdFifty;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
//    // Doubly linked list
//    class LRUcache {
//        private class CacheEntry{
//            CacheEntry prev, next;
//            int key, value;
//
//            public CacheEntry(int key, int value){
//                this.key=key;
//                this.value=value;
//            }
//        }
//
//        // capacity is the maximum number of items this LRU cache can hold
//        private int capacity;
//        private CacheEntry head, tail;
//        private Map<Integer, CacheEntry> map;
//
//        public LRUcache(int capacity) {
//            if(capacity<=0){
//                throw new IllegalArgumentException("LRU Cache capacity has to be a positive number!");
//            }
//            this.capacity=capacity;
//            this.head=new CacheEntry(-1, -1);
//            this.tail=new CacheEntry(-1, -1);
//            head.next=tail;
//            tail.prev=head;
//            map=new HashMap<>();
//        }
//
//        public int get(int key) {
//            CacheEntry cur=map.get(key);
//            if(cur==null){
//                return -1;
//            } else{
//                if(cur.prev!=head){
//                    cur.prev.next=cur.next;
//                    cur.next.prev=cur.prev;
//                    cur.prev=head;
//                    cur.next=head.next;
//                    head.next.prev=cur;
//                    head.next=cur;
//                }
//                return cur.value;
//            }
//        }
//
//        public void put(int key, int value) {
//            CacheEntry cur=map.get(key);
//            if(cur!=null){
//                cur.value=value;
//                get(key);
//            } else{
//                cur=new CacheEntry(key, value);
//                if(map.size()==capacity){
//                    CacheEntry last=tail.prev;
//                    tail.prev=last.prev;
//                    last.prev.next=tail;
//                    map.remove(last.key);
//                }
//                map.put(key, cur);
//                head.next.prev=cur;
//                cur.next=head.next;
//                head.next=cur;
//                cur.prev=head;
//            }
//        }
//    }

    // Singly linked list
    class LRUcache {
        private class CacheEntry{
            public CacheEntry next;
            public int key, value;

            public CacheEntry(int key, int value){
                this.key=key;
                this.value=value;
            }
        }

        private int capacity;
        // Note here the map stores the PREVIOUS cache entry because singly linked list can't easily trace the previous item
        private Map<Integer, CacheEntry> map;
        // Note here store last to make removing items easier, last needs to be handled with caution
        private CacheEntry head, tail, last;

        public LRUcache(int capacity) {
            if(capacity<=0){
                throw new IllegalArgumentException("LRU Cache capacity has to be a positive number!");
            }
            this.capacity=capacity;
            head=new CacheEntry(-1, -1);
            tail=new CacheEntry(-1, -1);
            head.next=tail;
            last=head;
            map=new HashMap<>();
        }

        public int get(int key) {
            CacheEntry pre=map.get(key);
            if(pre==null){
                return -1;
            } else{
                CacheEntry cur=pre.next;
                if(pre!=head){
                    pre.next=cur.next;
                    if(cur!=last){
                        map.put(cur.next.key, pre);
                    } else{
                        last=pre;
                    }
                    cur.next=head.next;
                    map.put(head.next.key, cur);
                    head.next=cur;
                    map.put(cur.key, head);
                }
                return cur.value;
            }
        }

        public void put(int key, int value) {
            CacheEntry pre=map.get(key);
            if(pre!=null){
                CacheEntry cur=pre.next;
                cur.value=value;
                get(key);
            } else{
                CacheEntry cur=new CacheEntry(key, value);
                if(map.size()==capacity){
                    CacheEntry lastPre=map.get(last.key);
                    lastPre.next=tail;
                    map.remove(last.key);
                    last=lastPre;
                }
                CacheEntry first=head.next;
                if(last!=head){
                    map.put(first.key, cur);
                } else{
                    last=cur;
                }
                head.next=cur;
                cur.next=first;
                map.put(cur.key, head);
            }
        }
    }
}
