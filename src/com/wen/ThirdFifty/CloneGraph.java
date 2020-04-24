package com.wen.ThirdFifty;

import java.util.*;

public class CloneGraph {
    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

//    // BFS, note created is acting as visited
//    public CacheEntry cloneGraph(CacheEntry node) {
//        if(node==null){
//            return null;
//        }
//        Map<Integer, CacheEntry> created=new HashMap<>();
//        CacheEntry nodeCopy=new CacheEntry();
//        nodeCopy.val=node.val;
//        created.put(nodeCopy.val, nodeCopy);
//        Queue<CacheEntry> q=new LinkedList<>();
//        q.offer(node);
//        while(!q.isEmpty()){
//            int size=q.size();
//            for(int i=0; i<size; i++){
//                CacheEntry cur=q.poll();
//                for(CacheEntry nghbr: cur.neighbors){
//                    CacheEntry clone=null;
//                    if(!created.containsKey(nghbr.val)){
//                        clone=new CacheEntry();
//                        clone.val=nghbr.val;
//                        created.put(nghbr.val, clone);
//                        q.offer(nghbr);
//                    } else{
//                        clone=created.get(nghbr.val);
//                    }
//                    created.get(cur.val).neighbors.add(clone);
//                }
//            }
//        }
//        return nodeCopy;
//    }

//    // DFS, note created is acting as visited
//    public CacheEntry cloneGraph(CacheEntry node) {
//        if(node==null){
//            return null;
//        }
//        Map<Integer, CacheEntry> created=new HashMap<>();
//        cloneGraphDFS(node, created);
//        return created.get(node.val);
//    }
//
//    private void cloneGraphDFS(CacheEntry node, Map<Integer, CacheEntry> created){
//        if(!created.containsKey(node.val)){
//            CacheEntry clone=new CacheEntry();
//            clone.val=node.val;
//            created.put(node.val, clone);
//            for(CacheEntry nghbr: node.neighbors){
//                cloneGraphDFS(nghbr, created);
//                clone.neighbors.add(created.get(nghbr.val));
//            }
//        }
//    }

    // DFS with Stack, note created is acting as visited
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Map<Integer, Node> created=new HashMap<>();
        Stack<Node> stack=new Stack<>();
        Node nodeCopy=new Node();
        nodeCopy.val=node.val;
        created.put(node.val, nodeCopy);
        stack.push(node);
        while(!stack.isEmpty()){
            Node cur=stack.pop();
            for(Node nghbr: cur.neighbors){
                if(!created.containsKey(nghbr.val)){
                    Node clone=new Node();
                    clone.val=nghbr.val;
                    created.put(nghbr.val, clone);
                    stack.push(nghbr);
                }
                created.get(cur.val).neighbors.add(created.get(nghbr.val));
            }
        }
        return nodeCopy;
    }
}
