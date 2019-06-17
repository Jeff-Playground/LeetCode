package com.wen.FifteenthFifty;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    class KthLargest {
        int size=-1;
        PriorityQueue<Integer> pq=null;

        public KthLargest(int k, int[] nums) {
            size=k;
            pq=new PriorityQueue<Integer>(new Comparator<Integer>(){
                @Override
                public int compare(Integer a, Integer b){
                    return a-b;
                }
            });
            for(int num: nums){
                pq.offer(num);
            }
            while(pq.size()>k){
                pq.poll();
            }
        }

        public int add(int val) {
            pq.offer(val);
            if(pq.size()>size){
                pq.poll();
            }
            return pq.peek();
        }
    }
}
