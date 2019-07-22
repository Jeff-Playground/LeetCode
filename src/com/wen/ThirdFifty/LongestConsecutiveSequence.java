package com.wen.ThirdFifty;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestConsecutiveSequence {
    // UnionFind, not O(n)

    public class UnionFind{
        Map<Integer, Integer> components;
        Map<Integer, Integer> counts;

        public UnionFind(){
            components=new HashMap<>();
            counts=new HashMap<>();
        }

        public int add(int val){
            if(!components.containsKey(val)){
                components.put(val, val);
                counts.put(val, 1);
                union(val, val-1);
                union(val, val+1);
            }
            return counts.get(findComp(val));
        }

        public int findComp(int val){
            int result=val;
            while(components.get(result)!=result){
                result=components.get(result);
            }
            int cur=val;
            while(components.get(cur)!=result){
                int next=components.get(cur);
                components.put(cur, result);
                cur=next;
            }
            return result;
        }

        public void union(int val1, int val2){
            if(components.containsKey(val1) && components.containsKey(val2)){
                int comp1=findComp(val1);
                int comp2=findComp(val2);
                if(comp1!=comp2){
                    if(counts.get(comp1)>counts.get(comp2)){
                        components.put(comp2, comp1);
                        counts.put(comp1, counts.get(comp1)+counts.get(comp2));
                    } else{
                        components.put(comp1, comp2);
                        counts.put(comp2, counts.get(comp2)+counts.get(comp1));
                    }
                }
            }
        }
    }

    public int longestConsecutive(int[] nums) {
        UnionFind uf=new UnionFind();
        int result=0;
        for(int num: nums){
            result=Math.max(result, uf.add(num));
        }
        return result;
    }

//    public int longestConsecutive(int[] nums) {
//        int result=0;
//        Map<Integer, Integer> map=new HashMap<>();
//        for(int num: nums){
//            if(map.containsKey(num)){
//                continue;
//            }
//            int left=map.containsKey(num-1)?map.get(num-1):0;
//            int right=map.containsKey(num+1)?map.get(num+1):0;
//            int sum=left+right+1;
//            map.put(num, sum);
//            result=Math.max(result, sum);
//            map.put(num-left, sum);
//            map.put(num+right, sum);
//        }
//        return result;
//    }

//    public int longestConsecutive(int[] nums) {
//        int result=0;
//        Set<Integer> set=new HashSet<>();
//        set.addAll(IntStream.of(nums).boxed().collect(Collectors.toList()));
//        for(int num: nums){
//            if(set.contains(num)){
//                set.remove(num);
//                int pre=num-1, next=num+1;
//                while(set.contains(pre)){
//                    set.remove(pre);
//                    pre--;
//                }
//                while(set.contains(next)){
//                    set.remove(next);
//                    next++;
//                }
//                result=Math.max(result, next-pre-1);
//            }
//        }
//        return result;
//    }
}
