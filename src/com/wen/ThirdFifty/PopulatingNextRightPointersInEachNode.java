package com.wen.ThirdFifty;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

//    // Iterative
//    public Node connect(Node root) {
//        if(root==null) {
//            return null;
//        }
//        Node levelStart=root, curParent=null;
//        while(levelStart.left!=null) {
//            curParent=levelStart;
//            while(curParent!=null) {
//                if(curParent.left!=null) {
//                    curParent.left.next=curParent.right;
//                }
//                if(curParent.next!=null) {
//                    curParent.right.next=curParent.next.left;
//                }
//                curParent=curParent.next;
//            }
//            levelStart=levelStart.left;
//        }
//        return root;
//    }

//    // Level order traversal
//    public Node connect(Node root) {
//        if(root==null){
//            return null;
//        }
//        Queue<Node> queue=new LinkedList<>();
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            int size=queue.size();
//            Node cur=null;
//            for(int i=0; i<size; i++){
//                cur=queue.poll();
//                if(cur.left!=null){
//                    queue.offer(cur.left);
//                    queue.offer(cur.right);
//                }
//                if(i<size-1){
//                    cur.next=queue.peek();
//                }
//            }
//            cur.next=null;
//        }
//        return root;
//    }

//    // Recursive
//    public Node connect(Node root) {
//        if(root==null){
//            return root;
//        }
//        Node left=root.left, right=root.right;
//        while(left!=null){
//            left.next=right;
//            left=left.right;
//            right=right.left;
//        }
//        connect(root.left);
//        connect(root.right);
//        return root;
//    }

    // Recursive, take care of right part first, then do left
    public Node connect(Node root) {
        if(root==null) {
            return null;
        }
        Node nextChild=root.next;
        while(nextChild!=null) {
            if(nextChild.left!=null) {
                nextChild=nextChild.left;
                break;
            }
            if(nextChild.right!=null) {
                nextChild=nextChild.right;
                break;
            }
            nextChild=nextChild.next;
        }
        if(root.right!=null) {
            root.right.next=nextChild;
        }
        if(root.left!=null) {
            root.left.next=root.right!=null?root.right:nextChild;
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
}
