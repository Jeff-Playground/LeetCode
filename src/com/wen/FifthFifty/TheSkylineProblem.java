package com.wen.FifthFifty;

import java.util.*;

public class TheSkylineProblem {
//    // Line sweep, and add tall first remove short first
//    public List<List<Integer>> getSkyline(int[][] buildings) {
//        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[0]!=b[0]?a[0]-b[0]:(a[2]!=b[2]?b[2]-a[2]:b[1]-a[1]));
//        TreeMap<Integer, Integer> cache=new TreeMap<>();
//        for(int[] b: buildings){
//            pq.offer(new int[]{b[0], b[2], 1});
//            pq.offer(new int[]{b[1], b[2], -1});
//        }
//        List<List<Integer>> result=new ArrayList<>();
//        int last=0;
//        while(!pq.isEmpty()){
//            int[] cur=pq.poll();
//            if(cur[2]==1){
//                int x=cur[0], h=cur[1];
//                cache.put(h, cache.getOrDefault(h, 0)+1);
//                if(h>last){
//                    result.add(Arrays.asList(x, h));
//                    last=h;
//                }
//            } else{
//                // Since the ordering in the PriorityQueue is tall first, use another Deque here to reverse process any
//                // points at the same location
//                Deque<int[]> remove=new LinkedList<>();
//                remove.offer(cur);
//                while(!pq.isEmpty() && pq.peek()[0]==cur[0]){
//                    remove.offerLast(pq.poll());
//                }
//                while(!remove.isEmpty()){
//                    cur=remove.pollLast();
//                    int x=cur[0], h=cur[1];
//                    if(cache.get(h)==1){
//                        cache.remove(h);
//                        if(h==last){
//                            last=cache.isEmpty()?0:cache.lastKey();
//                            result.add(Arrays.asList(x, last));
//                        }
//                    } else{
//                        cache.put(h, cache.get(h)-1);
//                    }
//                }
//            }
//        }
//        return result;
//    }
}