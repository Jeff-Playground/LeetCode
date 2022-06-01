package com.wen.FourteenthFifty;

import java.util.TreeMap;

public class MapSumPairs {
//    // TreeMap
//    class MapSum {
//        TreeMap<String, Integer> map;
//
//        public MapSum() {
//            map=new TreeMap();
//        }
//
//        public void insert(String key, int val) {
//            map.put(key, val);
//        }
//
//        public int sum(String prefix) {
//            int result=0;
//            if(map.ceilingKey(prefix)!=null){
//                for(String key: map.subMap(map.ceilingKey(prefix), true, map.lastKey(), true).keySet()){
//                    if(key.startsWith(prefix)){
//                        result+=map.get(key);
//                    } else{
//                        break;
//                    }
//                }
//            }
//            return result;
//        }
//    }

    // Trie
    class MapSum {
        TrieNode root;

        public MapSum() {
            root=new TrieNode();
        }

        public void insert(String key, int val) {
            root.add(key, val);
        }

        public int sum(String prefix) {
            return root.sum(prefix);
        }

        private class TrieNode{
            TrieNode[] nodes;
            Integer val;

            public TrieNode(){
                nodes=new TrieNode[26];
            }

            public void add(String key, int val){
                TrieNode cur=this;
                for(char c: key.toCharArray()){
                    if(cur.nodes[c-'a']==null){
                        cur.nodes[c-'a']=new TrieNode();
                    }
                    cur=cur.nodes[c-'a'];
                }
                cur.val=val;
            }

            public int sum(String prefix){
                TrieNode cur=this;
                for(char c: prefix.toCharArray()){
                    if(cur.nodes[c-'a']==null){
                        return 0;
                    } else{
                        cur=cur.nodes[c-'a'];
                    }
                }
                return getSum(cur);
            }

            private int getSum(TrieNode node){
                int result=0;
                for(TrieNode e: node.nodes){
                    if(e!=null){
                        result+=getSum(e);
                    }
                }
                if(node.val!=null){
                    result+=node.val;
                }
                return result;
            }
        }
    }
}
