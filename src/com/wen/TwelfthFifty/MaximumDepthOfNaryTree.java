package com.wen.TwelfthFifty;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthOfNaryTree {
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

    // DFS
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        } else{
            int max=0;
            if(root.children!=null){
                for(Node e: root.children){
                    max=Math.max(max, maxDepth(e));
                }
            }
            return max+1;
        }
    }

//    // BFS
//    public int maxDepth(Node root) {
//        if(root==null){
//            return 0;
//        } else{
//            int result=0;
//            Queue<Node> q=new LinkedList<>();
//            q.offer(root);
//            while(!q.isEmpty()){
//                int size=q.size();
//                while(size-->0){
//                    Node cur=q.poll();
//                    if(cur.children!=null && cur.children.size()>0){
//                        for(Node c: cur.children){
//                            q.offer(c);
//                        }
//                    }
//                }
//                result++;
//            }
//            return result;
//        }
//    }
}
