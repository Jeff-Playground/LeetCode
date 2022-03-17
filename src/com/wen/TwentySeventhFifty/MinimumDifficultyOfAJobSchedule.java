package com.wen.TwentySeventhFifty;

import java.util.HashMap;
import java.util.Map;

public class MinimumDifficultyOfAJobSchedule {
    // DP, bottom up, dp.get(i).get(di) stands for the minimum difficulty when day di starts with task i
    public int minDifficulty(int[] jobDifficulty, int d) {
        int l=jobDifficulty.length;
        if(l<d){
            return -1;
        }
        Map<Integer, Map<Integer, Integer>> dp=new HashMap<>();
        int max=jobDifficulty[l-1];
        for(int i=l-1; i>=d-1; i--){
            max=Math.max(max, jobDifficulty[i]);
            dp.put(i, new HashMap<>());
            dp.get(i).put(d, max);
        }
        for(int di=d-1; di>=1; di--){
            for(int i=di-1; i<=l-d+di-1; i++){
                max=jobDifficulty[i];
                int min=Integer.MAX_VALUE;
                for(int j=i; j<=l-d+di-1; j++){
                    max=Math.max(max, jobDifficulty[j]);
                    min=Math.min(min, max+dp.get(j+1).get(di+1));
                }
                dp.putIfAbsent(i, new HashMap<>());
                dp.get(i).put(di, min);
            }
        }
        return dp.get(0).get(1);
    }

//    // DP, top down
//    public int minDifficulty(int[] jobDifficulty, int d) {
//        if(jobDifficulty.length<d){
//            return -1;
//        }
//        Map<Integer, Map<Integer, Integer>> memo=new HashMap<>();
//        int l=jobDifficulty.length, max=jobDifficulty[l-1];
//        for(int i=l-1; i>=d-1; i--){
//            max=Math.max(max, jobDifficulty[i]);
//            memo.put(i, new HashMap<>());
//            memo.get(i).put(d, max);
//        }
//        return dp(jobDifficulty, d, 0, 1, memo);
//    }
//
//    private int dp(int[] jobDifficulty, int d, int jIdx, int curD, Map<Integer, Map<Integer, Integer>> memo){
//        if(!memo.getOrDefault(jIdx, new HashMap<>()).containsKey(curD)){
//            memo.putIfAbsent(jIdx, new HashMap<>());
//            int min=Integer.MAX_VALUE, curEffort=jobDifficulty[jIdx], l=jobDifficulty.length;
//            for(int i=jIdx; i<l-d+curD; i++){
//                curEffort=Math.max(curEffort, jobDifficulty[i]);
//                min=Math.min(min, curEffort+dp(jobDifficulty, d, i+1, curD+1, memo));
//            }
//            memo.get(jIdx).put(curD, min);
//        }
//        return memo.get(jIdx).get(curD);
//    }
}
