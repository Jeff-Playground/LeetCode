package com.wen.ThirdFifty;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    // Iterative, use pre to point at the last node of the same level
    public void connect(TreeLinkNode root) {
        if(root==null) {
            return;
        }
        TreeLinkNode start=root, cur=null, pre=null;
        while(start!=null) {
            cur=start;
            while(cur!=null) {
                if(cur.left!=null && cur.right!=null) {
                    cur.left.next=cur.right;
                }
                if(cur.left!=null || cur.right!=null) {
                    if(pre!=null) {
                        pre.next=cur.left!=null?cur.left:cur.right;
                    }
                    pre=cur.right!=null?cur.right:cur.left;
                }
                cur=cur.next;
            }
            while(start.left==null && start.right==null) {
                start=start.next;
                if(start==null) {
                    return;
                }
            }
            start=start.left!=null?start.left:start.right;
            pre=null;
        }
    }

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

//    // Level order traversal
//    public void connect(TreeLinkNode root) {
//       if(root==null){
//        return;
//        }
//        Queue<TreeLinkNode> queue=new LinkedList<>();
//           queue.offer(root);
//           while(!queue.isEmpty()){
//            int size=queue.size();
//            TreeLinkNode cur=null;
//            for(int i=0; i<size; i++){
//                cur=queue.poll();
//                if(cur.left!=null){
//                    queue.offer(cur.left);
//                }
//                if(cur.right!=null){
//                    queue.offer(cur.right);
//                }
//                if(i<size-1){
//                    cur.next=queue.peek();
//                }
//            }
//            cur.next=null;
//        }
//    }
}
