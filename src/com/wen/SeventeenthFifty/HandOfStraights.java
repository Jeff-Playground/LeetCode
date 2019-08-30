package com.wen.SeventeenthFifty;

import java.util.*;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        int l=hand.length;
        if(l%W!=0){
            return false;
        }
        TreeMap<Integer, Integer> sortedHand=new TreeMap<>();
        for(int num: hand){
            sortedHand.put(num, sortedHand.getOrDefault(num, 0)+1);
        }
        for(int first: sortedHand.keySet()){
            int firstCount=sortedHand.get(first);
            if(firstCount==0){
                continue;
            }
            for(int i=0; i<W; i++){
                if(!sortedHand.containsKey(first+i) || sortedHand.get(first+i)<firstCount){
                    return false;
                } else{
                    sortedHand.put(first+i, sortedHand.get(first+i)-firstCount);
                }
            }
        }
        return true;
    }

//    public boolean isNStraightHand(int[] hand, int W) {
//        int l=hand.length;
//        if(l%W!=0){
//            return false;
//        }
//        TreeMap<Integer, Integer> sortedHand=new TreeMap<>();
//        for(int num: hand){
//            sortedHand.put(num, sortedHand.getOrDefault(num, 0)+1);
//        }
//        while(!sortedHand.isEmpty()){
//            int first=sortedHand.firstKey();
//            for(int i=0; i<W; i++){
//                if(!sortedHand.containsKey(first+i)){
//                    return false;
//                } else{
//                    int count=sortedHand.get(first+i);
//                    if(count==1){
//                        sortedHand.remove(first+i);
//                    } else{
//                        sortedHand.put(first+i, count-1);
//                    }
//                }
//            }
//        }
//        return true;
//    }

//    public boolean isNStraightHand(int[] hand, int W) {
//        int l=hand.length;
//        if(W==1){
//            return true;
//        }
//        if(l%W!=0){
//            return false;
//        }
//        Map<Integer, PriorityQueue<Integer>> groups=new HashMap<>();
//        Arrays.sort(hand);
//        for(int num: hand){
//            if(!groups.containsKey(num-1)){
//                groups.putIfAbsent(num, new PriorityQueue<>((a, b)->(b-a)));
//                groups.get(num).offer(1);
//            } else{
//                PriorityQueue<Integer> existingCounts=groups.get(num-1);
//                int count=existingCounts.poll();
//                if(count<W-1){
//                    groups.putIfAbsent(num, new PriorityQueue<>((a, b)->(b-a)));
//                    groups.get(num).offer(count+1);
//                }
//                if(existingCounts.isEmpty()){
//                    groups.remove(num-1);
//                }
//            }
//        }
//        return groups.isEmpty();
//    }
}
