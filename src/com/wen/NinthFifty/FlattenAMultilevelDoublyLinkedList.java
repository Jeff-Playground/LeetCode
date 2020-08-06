package com.wen.NinthFifty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // Level-order traversal, recursively
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        } else{
            levelOrderDFS(root, 0, result);
        }
        return result;
    }

    private void levelOrderDFS(Node cur, int level, List<List<Integer>> result){
        if(result.size()==level){
            result.add(new ArrayList<>());
        }
        List<Integer> curLevel=result.get(level);
        curLevel.add(cur.val);
        cur.children.forEach(e->levelOrderDFS(e, level+1, result));
    }

//    // Level-order traversal, iteratively
//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> result=new ArrayList<>();
//        if(root==null){
//            return result;
//        } else{
//            Queue<Node> q=new LinkedList<>();
//            q.offer(root);
//            while(!q.isEmpty()){
//                int size=q.size();
//                List<Integer> level=new ArrayList<>();
//                while(size-->0){
//                    Node cur=q.poll();
//                    level.add(cur.val);
//                    cur.children.forEach(e->q.offer(e));
//                }
//                result.add(level);
//            }
//        }
//        return result;
//    }
}
