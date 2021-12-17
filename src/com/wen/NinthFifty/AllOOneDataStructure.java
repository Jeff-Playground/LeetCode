package com.wen.NinthFifty;

import java.util.*;

public class AllOOneDataStructure {
//    // Use TreeMap
//    public static class AllOne {
//        TreeMap<Integer, Set<String>> sorted;
//        HashMap<String, Integer> count;
//
//        public AllOne() {
//            sorted=new TreeMap<>();
//            count=new HashMap<>();
//        }
//
//        public void inc(String key) {
//            int keyCount=count.getOrDefault(key, 0);
//            count.put(key, keyCount+1);
//            sorted.getOrDefault(keyCount, new HashSet<>()).remove(key);
//            sorted.putIfAbsent(keyCount+1, new HashSet<>());
//            sorted.get(keyCount+1).add(key);
//            if(sorted.containsKey(keyCount)){
//                sorted.get(keyCount).remove(key);
//                if(sorted.get(keyCount).size()==0){
//                    sorted.remove(keyCount);
//                }
//            }
//        }
//
//        public void dec(String key) {
//            if(count.containsKey(key)){
//                int keyCount=count.get(key);
//                if(keyCount==1){
//                    count.remove(key);
//                } else{
//                    count.put(key, keyCount-1);
//                    sorted.putIfAbsent(keyCount-1, new HashSet<>());
//                    sorted.get(keyCount-1).add(key);
//                }
//                sorted.get(keyCount).remove(key);
//                if(sorted.get(keyCount).size()==0){
//                    sorted.remove(keyCount);
//                }
//            }
//        }
//
//        public String getMaxKey() {
//            if(count.size()>0){
//                int maxCount=sorted.lastKey();
//                return sorted.get(maxCount).iterator().next();
//            } else{
//                return "";
//            }
//        }
//
//        public String getMinKey() {
//            if(count.size()>0){
//                int minCount=sorted.firstKey();
//                return sorted.get(minCount).iterator().next();
//            } else{
//                return "";
//            }
//        }
//    }

    // Use Linked List
    public static class AllOne {
        class LinkedBucketNode{
            LinkedBucketNode prev, next;
            Set<String> keys;
            int val;

            public LinkedBucketNode(int val){
                this.val=val;
                keys=new HashSet<>();
            }
        }

        LinkedBucketNode head, tail;
        Map<String, Integer> count;
        Map<Integer, LinkedBucketNode> buckets;

        private void removeBucket(LinkedBucketNode node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
            buckets.remove(node.val);
        }

        private LinkedBucketNode createBucket(int val){
            LinkedBucketNode newBucket=new LinkedBucketNode(val);
            buckets.put(val, newBucket);
            LinkedBucketNode cur=head;
            while(cur.next!=tail && cur.next.val<val){
                cur=cur.next;
            }
            newBucket.next=cur.next;
            cur.next=newBucket;
            newBucket.prev=cur;
            newBucket.next.prev=newBucket;
            return newBucket;
        }

        public AllOne() {
            head=new LinkedBucketNode(-1);
            tail=new LinkedBucketNode(-1);
            head.next=tail;
            tail.prev=head;
            count=new HashMap<>();
            buckets=new HashMap<>();
        }

        public void inc(String key) {
            int keyCount=count.getOrDefault(key, 0);
            count.remove(key);
            count.put(key, keyCount+1);
            if(buckets.containsKey(keyCount)){
                LinkedBucketNode keyBucket=buckets.get(keyCount);
                keyBucket.keys.remove(key);
                if(keyBucket.keys.size()==0){
                    removeBucket(keyBucket);
                }
            }
            if(buckets.containsKey(keyCount+1)){
                LinkedBucketNode newBucket=buckets.get(keyCount+1);
                newBucket.keys.add(key);
            } else{
                LinkedBucketNode newBucket=createBucket(keyCount+1);
                newBucket.keys.add(key);
            }
        }

        public void dec(String key) {
            if(count.containsKey(key)){
                int keyCount=count.get(key);
                LinkedBucketNode keyBucket=buckets.get(keyCount);
                keyBucket.keys.remove(key);
                if(keyBucket.keys.size()==0){
                    removeBucket(keyBucket);
                }
                count.remove(key);
                if(keyCount>1){
                    count.put(key, keyCount-1);
                    if(buckets.containsKey(keyCount-1)){
                        LinkedBucketNode newBucket=buckets.get(keyCount-1);
                        newBucket.keys.add(key);
                    } else{
                        LinkedBucketNode newBucket=createBucket(keyCount-1);
                        newBucket.keys.add(key);
                    }
                }
            }
        }

        public String getMaxKey() {
            if(head.next!=tail){
                LinkedBucketNode maxBucket=tail.prev;
                return maxBucket.keys.iterator().next();
            } else{
                return "";
            }
        }

        public String getMinKey() {
            if(head.next!=tail){
                LinkedBucketNode minBucket=head.next;
                return minBucket.keys.iterator().next();
            } else{
                return "";
            }
        }
    }
}
