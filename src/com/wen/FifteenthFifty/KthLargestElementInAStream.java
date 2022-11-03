package com.wen.FifteenthFifty;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    class KthLargest {
        PriorityQueue<Integer> pq;
        int size;

        public KthLargest(int k, int[] nums) {
            pq=new PriorityQueue<>((a, b)->a-b);
            size=k;
            for(int num: nums){
                add(num);
            }
        }

        public int add(int val) {
            if(pq.size()<size){
                pq.offer(val);
            } else{
                if(val>pq.peek()){
                    pq.poll();
                    pq.offer(val);
                }
            }
            return pq.peek();
        }
    }

//    // Binary search tree
//    class KthLargest {
//        private class TreeNode{
//            public TreeNode left, right;
//            public int val, count;
//
//            public TreeNode(int val, int count){
//                this.val=val;
//                this.count=count;
//            }
//        }
//
//        private TreeNode root;
//        private int idx;
//
//        public KthLargest(int k, int[] nums) {
//            idx=k;
//            for(int num: nums){
//                add(num);
//            }
//        }
//
//        public int add(int val) {
//            add(root, val);
//            return search(root, idx);
//        }
//
//        private TreeNode add(TreeNode cur, int val){
//            if(cur==null){
//                cur=new TreeNode(val, 1);
//                if(root==null){
//                    root=cur;
//                }
//            } else{
//                cur.count++;
//                if(cur.val>val){
//                    cur.left=add(cur.left, val);
//                } else{
//                    cur.right=add(cur.right, val);
//                }
//            }
//            return cur;
//        }
//
//        private int search(TreeNode cur, int idx){
//            if(cur.count<idx){
//                return -1;
//            } else{
//                int rCount=cur.right==null?0:cur.right.count;
//                if(rCount+1<idx){
//                    return search(cur.left, idx-rCount-1);
//                } else if(rCount+1==idx){
//                    return cur.val;
//                } else{
//                    return search(cur.right, idx);
//                }
//            }
//        }
//    }
}
