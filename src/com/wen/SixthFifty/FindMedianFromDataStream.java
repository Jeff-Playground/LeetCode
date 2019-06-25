package com.wen.SixthFifty;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    class MedianFinder {
        int length=0;
        PriorityQueue<Integer> right=new PriorityQueue<>((a, b)->a-b);
        PriorityQueue<Integer> left=new PriorityQueue<>((a,b)->b-a);

        /** initialize your data structure here. */
        public MedianFinder() {

        }

        public void addNum(int num) {
            if(length%2==0){
                if(!right.isEmpty() && num>right.peek()){
                    right.offer(num);
                    num=right.poll();
                }
                left.offer(num);
            } else{
                if(!left.isEmpty() && num<left.peek()){
                    left.offer(num);
                    num=left.poll();
                }
                right.offer(num);
            }
            length++;
        }

        public double findMedian() {
            if(length%2==1){
                return left.peek();
            } else{
                return (left.peek()+right.peek())/2.0;
            }
        }
    }
}
