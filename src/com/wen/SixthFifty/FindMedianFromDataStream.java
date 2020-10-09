package com.wen.SixthFifty;

/*

Follow-ups:
1. If all integer numbers from the stream are between 0 and 100, how would you optimize it?
We can maintain an integer array of length 100 to store the count of each number along with a total count. Then, we can
iterate over the array to find the middle value to get our median.

Time and space complexity would be O(100) = O(1).



2. If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
As 99% is between 0-100. So can keep a counter for less_than_hundred and greater_than_hundred.
As we know solution will be definitely in 0-100 we don't need to know those number which are >100 or <0, only knowing the
count of them will be enough.


 */

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    class MedianFinder {
        int length=0;
        PriorityQueue<Integer> left=new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> right=new PriorityQueue<>((a, b)->a-b);

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
