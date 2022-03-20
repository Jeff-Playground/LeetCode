package com.wen.ThirtythFifty;

import java.util.HashMap;
import java.util.Map;

public class PaintHouseIII {
    // DP, bottom up
    // dp.get(h).get(c).get(t) stands for the minimum cost for house h to be painted color c forming total t communities
    public static int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        Map<Integer, Map<Integer, Map<Integer, Integer>>> dp=new HashMap<>();
        for(int h=0; h<m; h++){
            dp.put(h, new HashMap<>());
            if(h==0){
                if(houses[h]==0){
                    for(int c=1; c<=n; c++){
                        dp.get(h).put(c, new HashMap<>());
                        dp.get(h).get(c).put(1, cost[h][c-1]);
                    }
                } else{
                    dp.get(h).put(houses[h], new HashMap<>());
                    dp.get(h).get(houses[h]).put(1, 0);
                }
            } else{
                if(houses[h]==0){
                    for(int c=1; c<=n; c++){
                        dp.get(h).put(c, new HashMap<>());
                        for(int cl: dp.get(h-1).keySet()){
                            if(c==cl){
                                for(int tl: dp.get(h-1).get(cl).keySet()){
                                    dp.get(h).get(c).put(tl, Math.min(dp.get(h).get(c).getOrDefault(tl, Integer.MAX_VALUE), dp.get(h-1).get(cl).get(tl)+cost[h][c-1]));
                                }
                            } else{
                                for(int tl: dp.get(h-1).get(cl).keySet()){
                                    dp.get(h).get(c).put(tl+1, Math.min(dp.get(h).get(c).getOrDefault(tl+1, Integer.MAX_VALUE), dp.get(h-1).get(cl).get(tl)+cost[h][c-1]));
                                }
                            }
                        }
                    }
                } else{
                    dp.get(h).put(houses[h], new HashMap<>());
                    int c=houses[h];
                    for(int cl: dp.get(h-1).keySet()){
                        if(c==cl){
                            for(int tl: dp.get(h-1).get(cl).keySet()){
                                dp.get(h).get(c).put(tl, Math.min(dp.get(h).get(c).getOrDefault(tl, Integer.MAX_VALUE), dp.get(h-1).get(cl).get(tl)));
                            }
                        } else{
                            for(int tl: dp.get(h-1).get(cl).keySet()){
                                dp.get(h).get(c).put(tl+1, Math.min(dp.get(h).get(c).getOrDefault(tl+1, Integer.MAX_VALUE), dp.get(h-1).get(cl).get(tl)));
                            }
                        }
                    }
                }
            }
        }
        int result=Integer.MAX_VALUE;
        for(int c: dp.get(m-1).keySet()){
            for(int t: dp.get(m-1).get(c).keySet()){
                if(t==target){
                    result=Math.min(result, dp.get(m-1).get(c).get(t));
                }
            }
        }
        return result!=Integer.MAX_VALUE?result:-1;
    }

//    // DP, top down
//    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
//        Map<Integer, Map<Integer, Map<Integer, Integer>>> memo=new HashMap<>();
//        int result=Integer.MAX_VALUE;
//        for(int c=1; c<=n; c++){
//            result=Math.min(result, dp(houses, cost, m-1, target, c, memo));
//        }
//        return result!=Integer.MAX_VALUE?result:-1;
//    }
//
//    private int dp(int[] houses, int[][] cost, int h, int t, int c, Map<Integer, Map<Integer, Map<Integer, Integer>>> memo){
//        memo.putIfAbsent(h, new HashMap<>());
//        Map<Integer, Map<Integer, Integer>> hMap=memo.get(h);
//        hMap.putIfAbsent(t, new HashMap<>());
//        Map<Integer, Integer> htMap=hMap.get(t);
//        if(!htMap.containsKey(c)){
//            if(t>h+1 || t<1 || (houses[h]>0 && houses[h]!=c)){
//                htMap.put(c, Integer.MAX_VALUE);
//            } else{
//                if(h==0){
//                    htMap.put(c, houses[h]==0?cost[0][c-1]:0);
//                } else{
//                    int min=Integer.MAX_VALUE;
//                    int sameLastMin=dp(houses, cost, h-1, t, c, memo);
//                    if(sameLastMin!=Integer.MAX_VALUE){
//                        min=Math.min(min, sameLastMin+(houses[h]==c?0:cost[h][c-1]));
//                    }
//                    int diffLastMin=Integer.MAX_VALUE;
//                    for(int i=1; i<=cost[0].length; i++){
//                        if(i!=c){
//                            diffLastMin=Math.min(diffLastMin, dp(houses, cost, h-1, t-1, i, memo));
//                        }
//                    }
//                    if(diffLastMin!=Integer.MAX_VALUE){
//                        min=Math.min(min, diffLastMin+(houses[h]==c?0:cost[h][c-1]));
//                    }
//                    htMap.put(c, min);
//                }
//            }
//        }
//        return htMap.get(c);
//    }
}
