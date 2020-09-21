package com.wen.EleventhFifty;

import java.util.*;

public class FreedomTrail {
    // DP, dp[i][j] stands for the steps taken when ring char is at i and got key char at j
    public int findRotateSteps(String ring, String key) {
        char[] r=ring.toCharArray();
        int rl=r.length, kl=key.length();
        Map<Character, Set<Integer>> idx=new HashMap<>();
        for(int i=0; i<rl; i++){
            char c=r[i];
            idx.putIfAbsent(c, new HashSet<>());
            idx.get(c).add(i);
        }
        int[][] dp=new int[rl][kl];
        for(int i=0; i<rl; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for(int i: idx.get(key.charAt(0))){
            int dist=getDist(rl, 0, i);
            dp[i][0]=dist+1;
        }
        int result=Integer.MAX_VALUE;
        for(int j=1; j<kl; j++){
            char kc=key.charAt(j);
            for(int cur: idx.get(kc)){
                for(int prev: idx.get(key.charAt(j-1))){
                    dp[cur][j]=Math.min(dp[cur][j], getDist(rl, prev, cur)+1+dp[prev][j-1]);
                    if(j==kl-1){
                        result=Math.min(result, dp[cur][j]);
                    }
                }
            }
        }
        return result;
    }

    private int getDist(int l, int cur, int next){
        if(next==cur){
            return 0;
        } else if(next<cur){
            return Math.min(cur-next, l-cur+next);
        } else{
            return Math.min(next-cur, l-next+cur);
        }
    }

//    // DFS, note brings in a tried Map to avoid repeating calculated steps
//    public static int findRotateSteps(String ring, String key) {
//        char[] r=ring.toCharArray();
//        int rl=r.length;
//        Map<Character, Set<Integer>> idx=new HashMap<>();
//        for(int i=0; i<rl; i++){
//            char c=r[i];
//            idx.putIfAbsent(c, new HashSet<>());
//            idx.get(c).add(i);
//        }
//        return frsHelper(rl, idx, 0, key, 0, new HashMap<>();
//    }
//
//    private static int frsHelper(int rl, Map<Character, Set<Integer>> idx, int cur, String key, int kNext, Map<List<Integer>, Integer> tried){
//        if(kNext==key.length()){
//            return 0;
//        } else{
//            List<Integer> k=Arrays.asList(cur, kNext);
//            if(tried.containsKey(k)){
//                return tried.get(k);
//            } else{
//                char nc=key.charAt(kNext);
//                int result=Integer.MAX_VALUE;
//                for(int i: idx.get(nc)){
//                    result=Math.min(result, getDist(rl, cur, i)+1+frsHelper(rl, idx, i, key, kNext+1, tried));
//                }
//                tried.put(k, result);
//                return result;
//            }
//        }
//    }
//
//    private static int getDist(int l, int cur, int next){
//        if(next==cur){
//            return 0;
//        } else if(next<cur){
//            return Math.min(cur-next, l-cur+next);
//        } else{
//            return Math.min(next-cur, l-next+cur);
//        }
//    }
}
