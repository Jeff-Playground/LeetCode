package com.wen.NinthFifty;

import java.util.*;

public class FrogJump {
    // DFS, note introduced a Map checked to avoid duplicated checking
    public boolean canCross(int[] stones) {
        int l=stones.length;
        Map<Integer, Integer> index=new HashMap<>();
        for(int i=0; i<l; i++){
            index.put(stones[i], i);
        }
        return canCrossDFS(stones, index, 0, 0, new HashMap<>());
    }

    public boolean canCrossDFS(int[] stones, Map<Integer, Integer> index, int cur, int last, Map<List<Integer>, Boolean> checked){
        if(cur==stones.length-1){
            return true;
        } else{
            List<Integer> key=Arrays.asList(cur, last);
            if(checked.containsKey(key)){
                return checked.get(key);
            }
            int jump=stones[cur]-stones[last];
            int[] diffs=new int[]{-1, 0, 1};
            boolean result=false;
            for(int diff: diffs){
                int reach=stones[cur]+jump+diff;
                if(reach>stones[cur] && index.containsKey(reach)){
                    if(canCrossDFS(stones, index, index.get(reach), cur, checked)){
                        result=true;
                        break;
                    }
                }
            }
            checked.put(key, result);
            return result;
        }
    }

//    // DP with BFS, slower than DFS generally because it needs to traverse almost every possible path
//    public boolean canCross(int[] stones) {
//        int l=stones.length;
//        Map<Integer, Integer> index=new HashMap<>();
//        for(int i=0; i<l; i++){
//            index.put(stones[i], i);
//        }
//        Map<Integer, Set<Integer>> reachedFrom=new HashMap<>();
//        reachedFrom.put(0, new HashSet<>());
//        reachedFrom.get(0).add(0);
//        int[] diffs=new int[]{-1, 0, 1};
//        for(int i=0; i<l-1; i++){
//            if(reachedFrom.get(i)!=null){
//                for(int last: reachedFrom.get(i)){
//                    int jump=stones[i]-stones[last];
//                    for(int diff: diffs){
//                        int reach=stones[i]+jump+diff;
//                        if(reach>stones[i] && index.containsKey(reach)){
//                            reachedFrom.putIfAbsent(index.get(reach), new HashSet<>());
//                            reachedFrom.get(index.get(reach)).add(i);
//                        }
//                    }
//                }
//            }
//        }
//        return reachedFrom.get(l-1)!=null;
//    }
}
