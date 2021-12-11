package com.wen.FifthFifty;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    // Heap with PriorityQueue, time complexity O(nlogn)
    private class Node{
        int val, idx;
        public Node(int val, int idx){
            this.val=val;
            this.idx=idx;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int l=nums.length;
        int[] result=new int[l-k+1];
        PriorityQueue<Node> pq=new PriorityQueue<>((a, b)->a.val!=b.val?b.val-a.val:a.idx-b.idx);
        for(int i=0; i<l; i++){
            Node cur=new Node(nums[i], i);
            if(i>k-1){
                Node remove=new Node(nums[i-k], i-k);
                while(!pq.isEmpty() && pq.peek().idx<=remove.idx){
                    pq.poll();
                }
            }
            pq.offer(cur);
            if(i>=k-1){
                result[i-k+1]=pq.peek().val;
            }
        }
        return result;
    }

//    // Deque, time complexity O(n)
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int l=nums.length;
//        int[] result=new int[l-k+1];
//        Deque<Integer> dq=new LinkedList<>();
//        for(int i=0; i<l; i++){
//            if(i>k-1 && dq.peekFirst()==nums[i-k]){
//                dq.pollFirst();
//            }
//            while(!dq.isEmpty() && dq.peekLast()<nums[i]){
//                dq.pollLast();
//            }
//            dq.offerLast(nums[i]);
//            if(i>=k-1){
//                result[i-k+1]=dq.peekFirst();
//            }
//        }
//        return result;
//    }
}
