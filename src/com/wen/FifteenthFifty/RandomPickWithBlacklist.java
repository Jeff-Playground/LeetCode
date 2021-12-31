package com.wen.FifteenthFifty;

import java.util.*;

public class RandomPickWithBlacklist {
//    // Plain rejection sampling, will TLE
//    class Solution {
//        Set<Integer> blackSet;
//        int n;
//        Random r;
//
//        public Solution(int n, int[] blacklist) {
//            blackSet=new HashSet<>();
//            for(int num: blacklist){
//                blackSet.add(num);
//            }
//            this.n=n;
//            r=new Random();
//        }
//
//        public int pick() {
//            int result=r.nextInt(n);
//            while(blackSet.contains(result)){
//                result=r.nextInt(n);
//            }
//            return result;
//        }
//    }

//    // will MLE
//    class Solution {
//        int[] nums;
//        Random r;
//
//        public Solution(int n, int[] blacklist) {
//            int[] nums=new int[n-blacklist.length];
//            Set<Integer> blackSet=new HashSet<>();
//            for(int num: blacklist){
//                blackSet.add(num);
//            }
//            int index=0;
//            for(int i=0; i<n; i++){
//                if(!blackSet.contains(i)){
//                    nums[index++]=i;
//                }
//            }
//            r=new Random();
//        }
//
//        public int pick() {
//            return nums[r.nextInt(nums.length)];
//        }
//    }

    // Optimized by only storing the items where its index is changed
    public static class Solution {
        Map<Integer, Integer> altered;
        Random r;
        int size;

        public Solution(int n, int[] blacklist) {
            altered=new HashMap<>();
            r=new Random();
            size=n-blacklist.length;
            Set<Integer> possible=new HashSet<>();
            for(int i=size; i<n; i++){
                possible.add(i);
            }
            for(int num: blacklist){
                possible.remove(num);
            }
            Iterator<Integer> it=possible.iterator();
            for(int num: blacklist){
                if(num<size){
                    altered.put(num, it.next());
                }
            }
        }

        public int pick() {
            int index=r.nextInt(size);
            return altered.containsKey(index)?altered.get(index):index;
        }
    }
}
