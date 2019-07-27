package com.wen.SeventhFifty;

import java.util.LinkedList;
import java.util.Queue;

public class LQMovingAverageFromDataStream {
    // Note sum is double to prevent overflow
    public class MovingAverage {
        int size=0;
        double sum=0;
        Queue<Integer> q;
        /*
         * @param size: An integer
         */public MovingAverage(int size) {
            this.size=size;
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
