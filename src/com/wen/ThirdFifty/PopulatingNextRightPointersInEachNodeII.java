package com.wen.ThirdFifty;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
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

    // Iterative, use pre to point at the previous node of the same level
    public Node connect(Node root) {
        if(root==null) {
            return root;
        }
        Node levelStart=root, curParent=null, preChild=null;
        while(levelStart!=null) {
            curParent=levelStart;
            while(curParent!=null) {
                if(curParent.left!=null && curParent.right!=null) {
                    curParent.left.next=curParent.right;
                }
                if(curParent.left!=null || curParent.right!=null) {
                    if(preChild!=null) {
                        preChild.next=curParent.left!=null?curParent.left:curParent.right;
                    }
                    preChild=curParent.right!=null?curParent.right:curParent.left;
                }
                curParent=curParent.next;
            }
            while(levelStart.left==null && levelStart.right==null) {
                levelStart=levelStart.next;
                if(levelStart==null) {
                    return root;
                }
            }
            levelStart=levelStart.left!=null?levelStart.left:levelStart.right;
            preChild=null;
        }
        return root;
    }

//    // Recursive, take care of right part first, then do left
//    public Node connect(Node root) {
//        if(root==null) {
//            return root;
//        }
//        Node cur=root.next;
//        while(cur!=null) {
//            if(cur.left!=null) {
//                cur=cur.left;
//                break;
//            }
//            if(cur.right!=null) {
//                cur=cur.right;
//                break;
//            }
//            cur=cur.next;
//        }
//        if(root.right!=null) {
//            root.right.next=cur;
//        }
//        if(root.left!=null) {
//            root.left.next=root.right!=null?root.right:cur;
//        }
//        if(root.left!=null && root.right!=null) {
//            root.left.next=root.right;
//        }
//        connect(root.right);
//        connect(root.left);
//        return root;
//    }

//    // Level order traversal
//    public Node connect(Node root) {
//        if(root==null){
//            return null;
//        }
//        Queue<Node> q=new LinkedList<>();
//        q.offer(root);
//        while(!q.isEmpty()){
//            int size=q.size();
//            Node pre=null;
//            while(size-->0){
//                Node cur=q.poll();
//                if(pre!=null){
//                    pre.next=cur;
//                }
//                if(cur.left!=null){
//                    q.offer(cur.left);
//                }
//                if(cur.right!=null){
//                    q.offer(cur.right);
//                }
//                pre=cur;
//            }
//        }
//        return root;
//    }
}
