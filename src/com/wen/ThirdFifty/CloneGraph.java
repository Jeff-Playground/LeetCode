package com.wen.ThirdFifty;

import java.util.*;

public class CloneGraph {
    public class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // BFS, note created is acting as visited
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Node root=new Node(node.val);
        Map<Integer, Node> created=new HashMap<>();
        created.put(node.val, root);
        Queue<Node> q=new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            Node orig=q.poll();
            Node copy=created.get(orig.val);
            for(Node next: orig.neighbors){
                if(!created.containsKey(next.val)){
                    Node nextCopy=new Node(next.val);
                    created.put(next.val, nextCopy);
                    q.offer(next);
                    copy.neighbors.add(nextCopy);
                } else{
                    Node nextCopy=created.get(next.val);
                    copy.neighbors.add(nextCopy);
                }
            }
        }
        return root;
    }

//    // DFS, note created is acting as visited
//    public Node cloneGraph(Node node) {
//        if(node==null){
//            return null;
//        }
//        Map<Integer, Node> created=new HashMap<>();
//        cloneGraphDFS(node, created);
//        return created.get(node.val);
//    }
//
//    private void cloneGraphDFS(Node node, Map<Integer, Node> created){
//        if(!created.containsKey(node.val)){
//            Node clone=new Node(node.val);
//            created.put(node.val, clone);
//            for(Node nghbr: node.neighbors){
//                cloneGraphDFS(nghbr, created);
//                clone.neighbors.add(created.get(nghbr.val));
//            }
//        }
//    }

//    // DFS with Stack, note created is acting as visited
//    public Node cloneGraph(Node node) {
//        if(node==null){
//            return null;
//        }
//        Map<Integer, Node> created=new HashMap<>();
//        Stack<Node> stack=new Stack<>();
//        Node nodeCopy=new Node(node.val);
//        created.put(node.val, nodeCopy);
//        stack.push(node);
//        while(!stack.isEmpty()){
//            Node cur=stack.pop();
//            for(Node nghbr: cur.neighbors){
//                if(!created.containsKey(nghbr.val)){
//                    Node clone=new Node(nghbr.val);
//                    created.put(nghbr.val, clone);
//                    stack.push(nghbr);
//                }
//                created.get(cur.val).neighbors.add(created.get(nghbr.val));
//            }
//        }
//        return nodeCopy;
//    }
}
