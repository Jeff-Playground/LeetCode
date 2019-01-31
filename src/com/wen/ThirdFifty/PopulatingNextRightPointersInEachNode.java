package com.wen.ThirdFifty;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    // Iterative
    public void connect(TreeLinkNode root) {
        if(root==null) {
            return;
        }
        TreeLinkNode start=root, cur=null;
        while(start.left!=null) {
            cur=start;
            while(cur!=null) {
                if(cur.left!=null) {
                    cur.left.next=cur.right;
                }
                if(cur.next!=null) {
                    cur.right.next=cur.next.left;
                }
                cur=cur.next;
            }
            start=start.left;
        }
    }

//    // Level order traversal
//    public void connect(TreeLinkNode root) {
//        if(root==null){
//            return;
//        }
//        Queue<TreeLinkNode> queue=new LinkedList<>();
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            int size=queue.size();
//            TreeLinkNode cur=null;
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
//    }

//    // Recursive
//    public void connect(TreeLinkNode root) {
//        if(root==null){
//            return;
//        }
//        TreeLinkNode left=root.left, right=root.right;
//        while(left!=null){
//            left.next=right;
//            left=left.right;
//            right=right.left;
//        }
//        connect(root.left);
//        connect(root.right);
//    }

//    // Recursive, take care of right part first, then do left
//    public void connect(TreeLinkNode root) {
//        if(root==null) {
//            return;
//        }
//        TreeLinkNode cur=root.next;
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
//    }
}
