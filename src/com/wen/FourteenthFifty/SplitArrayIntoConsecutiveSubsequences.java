package com.wen.FourteenthFifty;

import java.util.*;

public class SplitArrayIntoConsecutiveSubsequences {
//    public static boolean isPossible(int[] nums) {
//        if(nums==null || nums.length<3){
//            return false;
//        }
//        int l=nums.length;
//        // Each PriorityQueue stores the lengths of the sequences containing a certain number, from small to big
//        Map<Integer, PriorityQueue<Integer>> map=new HashMap<>();
//        for(int num: nums){
//            PriorityQueue<Integer> last=getSeq(map, num-1);
//            int minLen=last.isEmpty()?0:last.poll();
//            PriorityQueue<Integer> cur=getSeq(map, num);
//            cur.offer(minLen+1);
//        }
//        for(int until: map.keySet()){
//            for(int len: map.get(until)){
//                if(len<3){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public static PriorityQueue<Integer> getSeq(Map<Integer, PriorityQueue<Integer>> map, int until){
//        PriorityQueue<Integer> result=map.get(until);
//        if(result==null){
//            result=new PriorityQueue<>();
//        }
//        map.put(until, result);
//        return result;
//    }

    public static boolean isPossible(int[] nums) {
        if(nums==null || nums.length<3){
            return false;
        }
        int l=nums.length;
        Integer prev=null;
        int prevCount=0, start=0;
        // Queue stores the starting point for the sequences
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<l; i++){
            int t=nums[i];
            if(i==l-1 || nums[i+1]!=t){
                int count=i-start+1;
                if(prev!=null && t-prev!=1){
                    while(prevCount-->0){
                        if(prev<q.poll()+2){
                            return false;
                        }
                    }
                    prev=null;
                }
                if(prev==null || t-prev==1){
                    while(prevCount>count){
                        prevCount--;
                        if(prev<q.poll()+2){
                            return false;
                        }
                    }
                    while(prevCount++<count){
                        q.offer(t);
                    }
                }
                prev=t;
                prevCount=count;
                start=i+1;
            }
        }
        while(prevCount-->0){
            if(prev<q.poll()+2){
                return false;
            }
        }
        return true;
    }

//    public static boolean isPossible(int[] nums) {
//        if(nums==null || nums.length<3){
//            return false;
//        }
//        int l=nums.length;
//        Map<Integer, Integer> freq=new HashMap<>();
//        Map<Integer, Integer> tail=new HashMap<>();
//        for(int num: nums){
//            freq.put(num, freq.getOrDefault(num, 0)+1);
//        }
//        for(int num: nums){
//            if(freq.get(num)==0){
//                continue;
//            } else if(tail.getOrDefault(num, 0)>0){
//                tail.put(num, tail.get(num)-1);
//                tail.put(num+1, tail.getOrDefault(num+1, 0)+1);
//            } else if(freq.getOrDefault(num+1, 0)>0 && freq.getOrDefault(num+2, 0)>0){
//                freq.put(num+1, freq.getOrDefault(num+1, 0)-1);
//                freq.put(num+2, freq.getOrDefault(num+2, 0)-1);
//                tail.put(num+3, tail.getOrDefault(num+3, 0)+1);
//            } else{
//                return false;
//            }
//            freq.put(num, freq.getOrDefault(num, 0)-1);
//        }
//        return true;
//    }
}
