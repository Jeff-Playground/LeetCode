package com.wen.TenthFifty;

import java.util.*;

public class IncreasingSubsequences {
    // BFS, can also solve by DFS
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        if(nums==null || nums.length<2){
            return result;
        }
        Queue<List<Integer>> q=new LinkedList<>();
        for(int i=0; i<nums.length-1; i++){
            List<Integer> seed=new ArrayList<>();
            seed.add(nums[i]);
            seed.add(i);
            q.offer(seed);
        }
        Set<List<Integer>> set=new HashSet<>();
        while(!q.isEmpty()){
            List<Integer> cur=q.poll();
            int last=cur.get(cur.size()-1);
            cur.remove(cur.size()-1);
            if(cur.size()>1){
                set.add(cur);
            }
            for(int i=last+1; i<nums.length; i++){
                if(nums[i]>=nums[last]){
                    List<Integer> copy=new ArrayList<>(cur);
                    copy.add(nums[i]);
                    copy.add(i);
                    q.offer(copy);
                }
            }
        }
        set.forEach(e->result.add(e));
        return result;
    }
}
