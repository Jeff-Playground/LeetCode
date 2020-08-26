package com.wen.NineteenthFifty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {
    // Union-find
    public int removeStones(int[][] stones) {
        if(stones==null || stones.length<=1){
            return 0;
        }
        int l=stones.length;
        int[] root=new int[l];
        for(int i=0; i<l; i++){
            root[i]=i;
        }
        for(int i=0; i<l; i++){
            for(int j=i+1; j<l; j++){
                int[] s1=stones[i], s2=stones[j];
                if(s1[0]==s2[0] || s1[1]==s2[1]){
                    int r1=findRoot(root, i), r2=findRoot(root, j);
                    if(r1!=r2){
                        root[r2]=r1;
                    }
                }
            }
        }
        int rootCount=0;
        for(int i=0; i<l; i++){
            if(root[i]==i){
                rootCount++;
            }
        }
        return l-rootCount;
    }

    private int findRoot(int[] root, int cur){
        while(cur!=root[cur]){
            root[cur]=root[root[cur]];
            cur=root[cur];
        }
        return cur;
    }

//    // DFS
//    public int removeStones(int[][] stones) {
//        Map<Integer, Set<Integer>> xMap=new HashMap<>(), yMap=new HashMap<>();
//        for(int[] s: stones){
//            int x=s[0], y=s[1];
//            xMap.putIfAbsent(x, new HashSet<>());
//            yMap.putIfAbsent(y, new HashSet<>());
//            xMap.get(x).add(y);
//            yMap.get(y).add(x);
//        }
//        int result=0;
//        Set<Integer> visitedRows=new HashSet<>();
//        for(int x: xMap.keySet()){
//            if(!visitedRows.contains(x)){
//                result+=groupCount(xMap, yMap, x, visitedRows)-1;
//            }
//        }
//        return result;
//    }
//
//    private int groupCount(Map<Integer, Set<Integer>> xMap, Map<Integer, Set<Integer>> yMap, int row, Set<Integer> visitedRows){
//        if(visitedRows.contains(row)){
//            return 0;
//        } else{
//            int result=xMap.get(row).size();
//            visitedRows.add(row);
//            for(int y: xMap.get(row)){
//                for(int x: yMap.get(y)){
//                    result+=groupCount(xMap, yMap, x, visitedRows);
//                }
//            }
//            return result;
//        }
//    }
}
