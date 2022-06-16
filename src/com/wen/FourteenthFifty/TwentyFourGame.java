package com.wen.FourteenthFifty;

import java.util.*;

public class TwentyFourGame {
    // DFS and backtracking
    public boolean judgePoint24(int[] cards) {
        List<Double> nums=new ArrayList<>();
        for(int e: cards){
            nums.add((double)e);
        }
        return judgePoint24Helper(nums);
    }

    private boolean judgePoint24Helper(List<Double> nums){
        int l=nums.size();
        if(l==1){
            return Math.abs(nums.get(0)-24)<0.001;
        } else{
            for(int i=0; i<l; i++){
                for(int j=i+1; j<l; j++){
                    double a=nums.get(i), b=nums.get(j);
                    nums.remove(j);
                    nums.remove(i);
                    nums.add(0, a+b);
                    if(judgePoint24Helper(nums)){
                        return true;
                    }
                    nums.remove(0);
                    nums.add(0, a-b);
                    if(judgePoint24Helper(nums)){
                        return true;
                    }
                    nums.remove(0);
                    nums.add(0, b-a);
                    if(judgePoint24Helper(nums)){
                        return true;
                    }
                    nums.remove(0);
                    nums.add(0, a*b);
                    if(judgePoint24Helper(nums)){
                        return true;
                    }
                    nums.remove(0);
                    if(b!=0){
                        nums.add(0, a/b);
                        if(judgePoint24Helper(nums)){
                            return true;
                        }
                        nums.remove(0);
                    }
                    if(a!=0){
                        nums.add(0, b/a);
                        if(judgePoint24Helper(nums)){
                            return true;
                        }
                        nums.remove(0);
                    }
                    nums.add(i, a);
                    nums.add(j, b);
                }
            }
            return false;
        }
    }

//    // DP like
//    public boolean judgePoint24(int[] cards) {
//        Map<Integer, Set<Double>> cache=new HashMap<>();
//        dp(cards, 15, cache);
//        for(double e: cache.get(15)){
//            if(Math.abs(e-24)<0.001){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private Set<Double> dp(int[] cards, int flag, Map<Integer, Set<Double>>cache){
//        if(!cache.containsKey(flag)){
//            cache.put(flag, new HashSet<>());
//            List<List<Integer>> subFlags=getSubFlags(flag);
//            if(subFlags.size()==1 && subFlags.get(0).size()==1){
//                int idx=subFlags.get(0).get(0);
//                cache.get(flag).add((double)cards[idx]);
//            } else{
//                for(List<Integer> e: subFlags){
//                    int subFlag1=e.get(0), subFlag2=e.get(1);
//                    Set<Double> s1=dp(cards, subFlag1, cache), s2=dp(cards, subFlag2, cache);
//                    for(double v1: s1){
//                        for(double v2: s2){
//                            cache.get(flag).add(v1+v2);
//                            cache.get(flag).add(v1-v2);
//                            cache.get(flag).add(v2-v1);
//                            cache.get(flag).add(v1*v2);
//                            if(v2!=0){
//                                cache.get(flag).add(v1/v2);
//                            }
//                            if(v1!=0){
//                                cache.get(flag).add(v2/v1);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return cache.get(flag);
//    }
//
//    private List<List<Integer>> getSubFlags(int flag){
//        List<List<Integer>> result=new ArrayList<>();
//        int count=0, idx=-1;
//        for(int i=0; i<4; i++){
//            if((flag&(1<<i))!=0){
//                count++;
//                idx=i;
//            }
//        }
//        if(count==1){
//            result.add(Arrays.asList(idx));
//        } else{
//            Set<Integer> visited=new HashSet<>();
//            visited.add(0);
//            visited.add(flag);
//            Queue<Integer> q=new LinkedList<>();
//            q.offer(0);
//            for(int i=0; i<4; i++){
//                if((flag&(1<<i))!=0){
//                    int size=q.size();
//                    while(size-->0){
//                        int cur=q.poll();
//                        q.offer(cur);
//                        q.offer(cur|(1<<i));
//                    }
//                }
//            }
//            while(!q.isEmpty()){
//                int cur=q.poll();
//                if(!visited.contains(cur)){
//                    visited.add(cur);
//                    visited.add(flag-cur);
//                    result.add(Arrays.asList(cur, flag-cur));
//                }
//            }
//        }
//        return result;
//    }
}
