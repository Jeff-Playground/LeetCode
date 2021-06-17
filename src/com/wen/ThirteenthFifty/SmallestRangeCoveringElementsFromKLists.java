package com.wen.ThirteenthFifty;

import java.util.*;

public class SmallestRangeCoveringElementsFromKLists {
    // Sliding window with PriorityQueue
    public static int[] smallestRange(List<List<Integer>> nums) {
        int k=nums.size();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[0]-b[0]);
        for(int i=0; i<k; i++){
            for(int num: nums.get(i)){
                pq.offer(new int[]{num, i});
            }
        }
        int[] count=new int[k], result=new int[]{0, Integer.MAX_VALUE};
        int total=0;
        Queue<int[]> q=new LinkedList<>();
        while(!pq.isEmpty()){
            int[] end=pq.poll();
            int eVal=end[0], eIdx=end[1];
            q.offer(end);
            if(count[eIdx]++==0){
                total++;
                while(total==k){
                    int[] start=q.poll();
                    int sVal=start[0], sIdx=start[1];
                    if(eVal-sVal<result[1]-result[0]){
                        result[0]=sVal;
                        result[1]=eVal;
                    }
                    if(--count[sIdx]==0){
                        total--;
                    }
                }
            }
        }
        return result;
    }

//    // Sliding window with TreeMap
//    public static int[] smallestRange(List<List<Integer>> nums) {
//        int k=nums.size();
//        TreeMap<Integer, Set<Integer>> numIndex=new TreeMap<>();
//        for(int i=0; i<k; i++){
//            for(int num: nums.get(i)){
//                numIndex.putIfAbsent(num, new HashSet<>());
//                numIndex.get(num).add(i);
//            }
//        }
//        Map<Integer, Set<Integer>> indexNum=new HashMap<>();
//        int[] result=new int[]{0, Integer.MAX_VALUE};
//        Integer start=numIndex.firstKey(), end=start;
//        while(end!=null){
//            for(int idx: numIndex.get(end)){
//                indexNum.putIfAbsent(idx, new HashSet<>());
//                indexNum.get(idx).add(end);
//            }
//            while(indexNum.size()==k){
//                if(end-start<result[1]-result[0]){
//                    result[0]=start;
//                    result[1]=end;
//                }
//                for(int idx: numIndex.get(start)){
//                    indexNum.get(idx).remove(start);
//                    if(indexNum.get(idx).isEmpty()){
//                        indexNum.remove(idx);
//                    }
//                }
//                start=numIndex.higherKey(start);
//                if(start==null){
//                    return result;
//                }
//            }
//            end=numIndex.higherKey(end);
//        }
//        return result;
//    }
}
