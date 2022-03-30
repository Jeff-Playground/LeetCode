package com.wen.EighthFifty;

/*
Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the
system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp
starts at 1.

It is possible that several hits arrive roughly at the same time.

Example:

HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3.
counter.getHits(301);


Follow up:
What if the number of hits per second could be very large? Does your design scale?
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LQDesignHitCounter {
//    // With ReadWriteLock
//    class HitCounter{
//        ReentrantReadWriteLock lock;
//        Lock rLock;
//        Lock wLock;
//
//        int[] times, hits;
//
//        public HitCounter(){
//            times=new int[300];
//            hits=new int[300];
//            lock=new ReentrantReadWriteLock();
//            rLock=lock.readLock();
//            wLock=lock.writeLock();
//        }
//
//        public void hit(int timestamp){
//            wLock.lock();
//            try {
//                int idx = timestamp % 300;
//                if (times[idx] == timestamp) {
//                    hits[idx]++;
//                } else {
//                    times[idx] = timestamp;
//                    hits[idx] = 1;
//                }
//            } finally {
//                wLock.unlock();
//            }
//        }
//
//        public int getHits(int timestamp){
//            rLock.lock();
//            try{
//                int result=0;
//                for(int i=0; i<300; i++){
//                    if(timestamp-times[i]<300) {
//                        result += hits[i];
//                    }
//                }
//                return result;
//            } finally{
//                rLock.unlock();
//            }
//        }
//    }

//    class HitCounter{
//        int[] times, hits;
//
//        public HitCounter(){
//            times=new int[300];
//            hits=new int[300];
//        }
//
//        public void hit(int timestamp){
//            int idx=timestamp%300;
//            if(times[idx]!=timestamp){
//                times[idx]=timestamp;
//                hits[idx]=1;
//            } else{
//                hits[idx]++;
//            }
//        }
//
//        public int getHits(int timestamp){
//            int result=0;
//            for(int i=0; i<300; i++){
//                if(timestamp-times[i]<300) {
//                    result += hits[i];
//                }
//            }
//            return result;
//        }
//    }

    class HitCounter{
        Queue<Integer> q;

        public HitCounter(){
            q=new LinkedList<>();
        }

        public void hit(int timestamp){
            q.offer(timestamp);
        }

        public int getHits(int timestamp){
            while(!q.isEmpty() && timestamp-q.peek()>=300){
                q.poll();
            }
            return q.size();
        }
    }
}
