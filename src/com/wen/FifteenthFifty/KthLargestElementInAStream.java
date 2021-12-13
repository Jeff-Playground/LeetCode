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
}
