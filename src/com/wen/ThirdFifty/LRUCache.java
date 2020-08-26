package com.wen.ThirdFifty;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    // Double linked list
    class LRUcache {
        private class CacheEntry{
            public CacheEntry pre, next;
            public int key, value;

            public CacheEntry(int key, int value){
                this.key=key;
                this.value=value;
            }
        }

        private int capacity;
        private CacheEntry head, tail, last;
        private Map<Integer, CacheEntry> map;

        public LRUcache(int capacity) {
            this.capacity=capacity;
            head=new CacheEntry(-1,-1);
            tail=new CacheEntry(-1,-1);
            last=head;
            head.next=tail;
            tail.pre=head;
            map=new HashMap<>();
        }

        public int get(int key) {
            CacheEntry cur=map.get(key);
            if(cur!=null){
                if(cur.pre!=head){
                    if(cur==last){
                        last=cur.pre;
                    }
                    cur.pre.next=cur.next;
                    cur.next.pre=cur.pre;
                    cur.next=head.next;
                    cur.pre=head;
                    head.next=cur;
                    cur.next.pre=cur;
                }
                return cur.value;
            } else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(capacity<=0){
                return;
            }
            CacheEntry cur=map.get(key);
            if(cur!=null){
                cur.value=value;
                if(cur.pre!=head){
                    if(cur==last){
                        last=cur.pre;
                    }
                    cur.pre.next=cur.next;
                    cur.next.pre=cur.pre;
                    cur.next=head.next;
                    cur.pre=head;
                    head.next=cur;
                    cur.next.pre=cur;
                }
            } else{
                cur=new CacheEntry(key, value);
                if(head==last){
                    last=cur;
                }
                cur.next=head.next;
                cur.pre=head;
                head.next=cur;
                cur.next.pre=cur;
                map.put(key, cur);
                if(map.size()>capacity){
                    CacheEntry lastPre=last.pre;
                    lastPre.next=last.next;
                    last.next.pre=lastPre;
                    map.remove(last.key);
                    last=lastPre;
                }
            }
        }
    }

//    // Single linked list
//    class LRUcache {
//        private class CacheEntry{
//            public CacheEntry next;
//            public int key;
//            public int value;
//
//            public CacheEntry(int key, int value){
//                this.key=key;
//                this.value=value;
//            }
//        }
//
//        private int capacity;
//        private Map<Integer, CacheEntry> map;
//        private CacheEntry head, tail, last;
//
//        public LRUcache(int capacity) {
//            this.capacity=capacity;
//            head=new CacheEntry(-1, -1);
//            tail=new CacheEntry(-1, -1);
//            head.next=tail;
//            last=head;
//            map=new HashMap<>();
//        }
//
//        public int get(int key) {
//            CacheEntry pre=map.get(key);
//            if(pre!=null){
//                CacheEntry cur=pre.next;
//                if(pre!=head){
//                    pre.next=cur.next;
//                    if(cur!=last){
//                        map.put(cur.next.key, pre);
//                    } else{
//                        last=pre;
//                    }
//                    cur.next=head.next;
//                    map.put(head.next.key, cur);
//                    head.next=cur;
//                    map.put(cur.key, head);
//                }
//                return cur.value;
//            } else{
//                return -1;
//            }
//        }
//
//        public void put(int key, int value) {
//            if(capacity<=0){
//                return;
//            }
//            CacheEntry pre=map.get(key);
//            if(pre!=null){
//                CacheEntry cur=pre.next;
//                cur.value=value;
//                if(pre!=head){
//                    pre.next=cur.next;
//                    if(cur!=last){
//                        map.put(cur.next.key, pre);
//                    } else{
//                        last=pre;
//                    }
//                    cur.next=head.next;
//                    map.put(head.next.key, cur);
//                    head.next=cur;
//                    map.put(cur.key, head);
//                }
//            } else{
//                CacheEntry cur=new CacheEntry(key, value);
//                CacheEntry next=head.next;
//                cur.next=next;
//                if(next!=tail){
//                    map.put(next.key, cur);
//                } else{
//                    last=cur;
//                }
//                head.next=cur;
//                map.put(cur.key, head);
//                if(map.size()>capacity){
//                    CacheEntry lastPre=map.get(last.key);
//                    lastPre.next=tail;
//                    map.remove(last.key);
//                    last=lastPre;
//                }
//            }
//        }
//    }
}
