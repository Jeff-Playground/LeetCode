package com.wen.NinthFifty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOOneDataStructure {
    public static class AllOne {

        class Bucket{
            public int val;
            public Set<String> keys;
            public Bucket pre, next;
            public Bucket(int val){
                this.val=val;
                this.keys=new HashSet<>();
            }
        }

        private Bucket high, low;
        private Map<String, Integer> keyValues;
        private Map<Integer, Bucket> valueBuckets;

        /** Initialize your data structure here. */
        public AllOne() {
            keyValues=new HashMap<>();
            valueBuckets=new HashMap<>();
            high=low=new Bucket(0);
            valueBuckets.put(0, low);
        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            int curVal=keyValues.getOrDefault(key, 0);
            Bucket cur=valueBuckets.get(curVal);
            createHigherIfNotExists(curVal);
            Bucket higher=valueBuckets.get(curVal+1);
            higher.keys.add(key);
            cur.keys.remove(key);
            if(cur.keys.size()==0 && cur.val!=0){
                deleteBucket(cur);
                valueBuckets.remove(cur.val);
            }
            keyValues.put(key, curVal+1);
        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            if(keyValues.containsKey(key)){
                int curVal=keyValues.get(key);
                Bucket cur=valueBuckets.get(curVal);
                if(curVal!=1){
                    createLowerIfNotExists(curVal);
                    Bucket lower=valueBuckets.get(curVal-1);
                    lower.keys.add(key);
                    keyValues.put(key, curVal-1);
                } else{
                    keyValues.remove(key);
                }
                cur.keys.remove(key);
                if(cur.keys.size()==0 && cur.val!=0){
                    deleteBucket(cur);
                    valueBuckets.remove(cur.val);
                }
            }
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            if(high==low){
                return "";
            } else{
                return high.keys.iterator().next();
            }
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            if(high==low){
                return "";
            } else{
                return low.pre.keys.iterator().next();
            }
        }

        private void createHigherIfNotExists(int val){
            if(!valueBuckets.containsKey(val+1)){
                Bucket cur=valueBuckets.get(val);
                Bucket higher=new Bucket(val+1);
                if(cur==high){
                    high=higher;
                }
                higher.next=cur;
                if(cur.pre!=null){
                    cur.pre.next=higher;
                    higher.pre=cur.pre;
                }
                cur.pre=higher;
                valueBuckets.put(val+1, higher);
            }
        }

        private void createLowerIfNotExists(int val){
            if(!valueBuckets.containsKey(val-1)){
                Bucket cur=valueBuckets.get(val);
                Bucket lower=new Bucket(val-1);
                lower.pre=cur;
                if(cur.next!=null){
                    lower.next=cur.next;
                    cur.next.pre=lower;
                }
                cur.next=lower;
                valueBuckets.put(val-1, lower);
            }
        }

        private void deleteBucket(Bucket cur){
            Bucket pre=cur.pre, next=cur.next;
            if(pre!=null && next!=null){
                pre.next=next;
                next.pre=pre;
            } else if(pre==null){
                if(cur==high){
                    high=cur.next;
                    cur.next.pre=null;
                    cur.next=null;
                }
            }
        }
    }
}
