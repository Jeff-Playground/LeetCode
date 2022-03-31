package com.wen.NinthFifty;

import javafx.util.Pair;

import java.util.*;

public class FrogJump {
    // DFS, faster than BFS because in practice it could check less paths
    public boolean canCross(int[] stones) {
        Set<Integer> st=new HashSet<>();
        for(int s: stones){
            st.add(s);
        }
        Set<Pair<Integer, Integer>> tried=new HashSet<>();
        return ccHelper(stones, st, new int[]{-1,0,1}, stones[0], 0, tried);
    }

    private boolean ccHelper(int[] stones, Set<Integer> st, int[] diff, int idx, int jump, Set<Pair<Integer, Integer>> tried){
        Pair<Integer, Integer> cur=new Pair<>(idx, jump);
        if(tried.contains(cur)){
            return false;
        } else{
            tried.add(cur);
            boolean possible=false;
            for(int d: diff){
                int nJump=jump+d, nIdx=idx+nJump;
                if(nJump>0 && st.contains(nIdx)){
                    if(nIdx==stones[stones.length-1]){
                        return true;
                    }
                    possible=ccHelper(stones, st, diff, nIdx, nJump, tried);
                    if(possible){
                        break;
                    }
                }
            }
            return possible;
        }
    }

//    // BFS
//    public boolean canCross(int[] stones) {
//        Set<Integer> st=new HashSet<>();
//        for(int s: stones){
//            st.add(s);
//        }
//        int[] diff=new int[]{-1, 0, 1};
//        Pair<Integer, Integer> first=new Pair<>(stones[0], 0);
//        Queue<Pair<Integer, Integer>> q=new LinkedList<>();
//        q.offer(first);
//        Set<Pair<Integer, Integer>> visited=new HashSet<>();
//        visited.add(first);
//        while(!q.isEmpty()){
//            Pair<Integer, Integer> cur=q.poll();
//            int idx=cur.getKey(), jump=cur.getValue();
//            for(int d: diff){
//                int nJump=d+jump;
//                if(nJump>0){
//                    int nIdx=idx+nJump;
//                    Pair<Integer, Integer> next=new Pair<>(nIdx, nJump);
//                    if(nIdx==stones[stones.length-1]){
//                        return true;
//                    }
//                    if(st.contains(nIdx) && !visited.contains(next)){
//                        q.offer(next);
//                        visited.add(next);
//                    }
//                }
//            }
//        }
//        return false;
//    }
}
