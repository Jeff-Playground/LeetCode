package com.wen.Airbnb;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.create("/a", 1);
        System.out.println(solution.get("/a"));
        solution.create("/a/b", 2);
        System.out.println(solution.get("/a/b"));
        solution.create("/c/d", 3);
        System.out.println(solution.get("/c"));
        solution.set("/a/b", 4);
        System.out.println(solution.get("/a/b"));
        solution.watch("/a", "/a call back triggerred");
        solution.watch("/a/b", "/a/b call back triggerred");
        solution.set("/d", 5);
        solution.create("/a/b/c", 10);
        solution.set("/a/b/c", 11);
    }

//    // Using map
//    static class Solution {
//        Map<String, Integer> map;
//        Map<String, Runnable> callbackMap;
//
//        public Solution() {
//            this.map = new HashMap<>();
//            map.put("", 0);
//            this.callbackMap = new HashMap<>();
//        }
//
//        public boolean create(String key, int value) {
//            if (map.containsKey(key)) {
//                return false;
//            }
//            String prefix = key.substring(0, key.lastIndexOf("/"));
//            if (!map.containsKey(prefix)) {
//                return false;
//            }
//            map.put(key, value);
//            return true;
//        }
//
//        public boolean set(String key, int value) {
//            if (!map.containsKey(key)) {
//                return false;
//            }
//            map.put(key, value);
//            String curt = key;
//            while (curt.length() > 0) {
//                if (callbackMap.containsKey(curt)) {
//                    callbackMap.get(curt).run();
//                }
//                curt = curt.substring(0, curt.lastIndexOf("/"));
//            }
//            return true;
//        }
//
//        public int get(String key) {
//            if (!map.containsKey(key)) {
//                return -1;
//            }
//            return map.get(key);
//        }
//
//        public void watch(String path, String alert) {
//            Runnable runnable = new Runnable() {
//                public void run() {
//                    System.out.println(alert);
//                }
//            };
//            callbackMap.put(path, runnable);
//        }
//    }

    // Using trie
    static class Solution {
        private TrieNode root;

        public Solution() {
            this.root = new TrieNode("", 0, null, new HashMap<>());
        }

        public boolean create(String key, int value) {
            //    /a/b/c/d -> "" a b c
            TrieNode node = root;
            String[] arr = key.split("/");
            for (int i = 1; i < arr.length - 1; i++) {
                String toCheck = arr[i];
                if (!node.map.containsKey(toCheck)) {
                    return false;
                }
                node = node.map.get(toCheck);
            }
            String toAdd = arr[arr.length - 1];
            if (node.map.containsKey(toAdd)) {
                return false;
            }
            TrieNode newNode = new TrieNode(toAdd, value, null, new HashMap<>());
            node.map.put(toAdd, newNode);
            return true;
        }

        public int get(String key) {
            TrieNode node = root;
            String[] arr = key.split("/");
            for (int i = 1; i < arr.length; i++) {
                String next = arr[i];
                if (!node.map.containsKey(next)) {
                    return -1;
                }
                node = node.map.get(next);
            }
            return node.value;
        }

        public boolean set(String key, int value) {
            TrieNode node = root;
            String[] arr = key.split("/");
            for (int i = 1; i < arr.length; i++) {
                String toCheck = arr[i];
                if (!node.map.containsKey(toCheck)) {
                    return false;
                }
                node = node.map.get(toCheck);
                if(node.callback!=null){
                    node.callback.run();
                }
            }
            node.value = value;
            return true;
        }

        public void watch(String key, String alert) {
            //关于watch方法，需要询问未建立的节点是否能添加watch，如果可以的话，就需要用HashMap做；
            //如果只在当前的存在的节点上添加watch的话，就直接按照路径找到节点，然后添加即可.以下做的是在现有的路径上添加watch的版本
            //另外如果需要没有error的时候才执行callback函数的话，那么需要在每个节点添加父亲节点，只有在没有error成功create和set的时候才通过parent节点反向向上执行callback
            TrieNode node = root;
            String[] arr = key.split("/");
            for (int i = 1; i < arr.length; i++) {
                String toCheck = arr[i];
                if (!node.map.containsKey(toCheck)) {
                    return;
                }
                node = node.map.get(toCheck);
            }
            Runnable runnable = new Runnable(){
                public void run() {
                    System.out.println(alert);
                }
            };
            node.callback = runnable;
        }
    }

    static class TrieNode {
        String key;
        int value;
        Runnable callback;
        Map<String, TrieNode> map;
        public TrieNode(String key, int value, Runnable callback, Map<String, TrieNode> map) {
            this.key = key;
            this.value = value;
            this.callback = callback;
            this.map = map;

        }
    }
}
