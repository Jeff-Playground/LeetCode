package com.wen.SixthFifty;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LQZigzagIterator {
    public class ZigzagIterator {
        List<Integer> v1;
        List<Integer> v2;
        int idx1=-1;
        int idx2=-1;
        /*
         * @param v1: A 1d vector
         * @param v2: A 1d vector
         */public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            this.v1=v1;
            this.v2=v2;
            idx1=0;
            idx2=0;
        }

        /*
         * @return: An integer
         */
        public int next() {
            if(hasNext()){
                if(idx1==v1.size()){
                    return v2.get(idx2++);
                } else if(idx2==v2.size()){
                    return v1.get(idx1++);
                } else{
                    return idx1==idx2?v1.get(idx1++):v2.get(idx2++);
                }
            } else {
                return Integer.MIN_VALUE;
            }
        }

        /*
         * @return: True if has next
         */
        public boolean hasNext() {
            return idx1<v1.size() || idx2<v2.size();
        }
    }

//    public class ZigzagIterator {
//        Queue<List<Integer>> q=new LinkedList<>();
//        /*
//         * @param v1: A 1d vector
//         * @param v2: A 1d vector
//         */public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
//            if(v1!=null && v1.size()>0){
//                q.offer(v1);
//            }
//            if(v2!=null && v2.size()>0){
//                q.offer(v2);
//            }
//        }
//
//        /*
//         * @return: An integer
//         */
//        public int next() {
//            if(hasNext()){
//                List<Integer> cur=q.poll();
//                int result=cur.get(0);
//                cur.remove(0);
//                if(cur.size()>0){
//                    q.offer(cur);
//                }
//                return result;
//            } else {
//                return Integer.MIN_VALUE;
//            }
//        }
//
//        /*
//         * @return: True if has next
//         */
//        public boolean hasNext() {
//            return !q.isEmpty();
//        }
//    }
}
