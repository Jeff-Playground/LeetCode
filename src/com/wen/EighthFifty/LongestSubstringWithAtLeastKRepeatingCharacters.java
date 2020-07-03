package com.wen.EighthFifty;

import java.util.*;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    // Divide and conquer
    public int longestSubstring(String s, int k) {
        return lsHelper(s, 0, s.length()-1, k);
    }

    private int lsHelper(String s, int start, int end, int k){
        if(start>end){
            return 0;
        }
        Map<Character, List<Integer>> idx=new HashMap<>();
        for(int i=start; i<=end; i++){
            char c=s.charAt(i);
            List<Integer> cur=idx.getOrDefault(c, new ArrayList<>());
            cur.add(i);
            idx.put(c, cur);
        }
        TreeSet<Integer> brokenIdx=new TreeSet<>();
        for(List<Integer> cur: idx.values()){
            if(cur.size()<k){
                brokenIdx.addAll(cur);
            }
        }
        if(brokenIdx.isEmpty()){
            return end-start+1;
        } else{
            int max=0;
            int last=start;
            for(int bi: brokenIdx){
                max=Math.max(max, lsHelper(s, last, bi-1, k));
                last=bi+1;
            }
            max=Math.max(max, lsHelper(s, last, end, k));
            return max;
        }
    }
}
