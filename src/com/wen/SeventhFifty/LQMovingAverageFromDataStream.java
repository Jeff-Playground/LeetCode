package com.wen.SeventhFifty;

/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:

MovingAverage(int size) Initializes the object with the size of the window size.
double next(int val) Returns the moving average of the last size values of the stream.


Example 1:
Input
["MovingAverage", "next", "next", "next", "next"]
[[3], [1], [10], [3], [5]]
Output
[null, 1.0, 5.5, 4.66667, 6.0]

Explanation
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // return 1.0 = 1 / 1
movingAverage.next(10); // return 5.5 = (1 + 10) / 2
movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3


Constraints:
1 <= size <= 1000
-105 <= val <= 105
At most 104 calls will be made to next.
 */

import java.util.LinkedList;
import java.util.Queue;

public class LQMovingAverageFromDataStream {
    // Note sum is double to prevent overflow
    public class MovingAverage {
        private int size;
        private double sum;
        private Queue<Integer> q;
        /*
         * @param size: An integer
         */
        public MovingAverage(int size) {
            this.size=size;
            sum=0;
            q=new LinkedList<>();
        }

        /*
         * @param val: An integer
         * @return:
         */
        public double next(int val) {
            sum+=val;
            q.offer(val);
            if(q.size()>size){
                sum-=q.poll();
            }
            return sum/q.size();
        }
    }
}
