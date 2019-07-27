package com.wen.EighthFifty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LQDesignHitCounter {
    class HitCounter{
        int[] times, hits;

        public HitCounter(){
            times=new int[300];
            hits=new int[300];
        }

        public void hit(int timestamp){
            int idx=timestamp%300;
            if(times[idx]!=timestamp){
                times[idx]=timestamp;
                hits[idx]=1;
            } else{
                hits[idx]++;
            }
        }

        public int getHits(int timestamp){
            int result=0;
            for(int i=0; i<300; i++){
                result+=hits[i];
            }
            return result;
        }
    }

//    class HitCounter{
//        Queue<Integer> q;
//
//        public HitCounter(){
//            q=new LinkedList<>();
//        }
//
//        public void hit(int timestamp){
//            q.offer(timestamp);
//        }
//
//        public int getHits(int timestamp){
//            while(!q.isEmpty() && timestamp-q.peek()>=300){
//                q.poll();
//            }
//            return q.size();
//        }
//    }
}
