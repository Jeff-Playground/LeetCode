package com.wen.TwentyFirstFifty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] result=new int[N];
        int[] colors=new int[]{1, 2, 3, 4};
        Map<Integer, Set<Integer>> graph=new HashMap<>();
        for(int[] path: paths){
            int x=path[0], y=path[1];
            graph.putIfAbsent(x, new HashSet<>());
            graph.putIfAbsent(y, new HashSet<>());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        for(int i=0; i<N; i++){
            int[] cur=new int[4];
            if(graph.containsKey(i+1)){
                for(int n: graph.get(i+1)){
                    if(result[n-1]!=0){
                        cur[result[n-1]-1]=1;
                    }
                }
            }
            for(int k=0; k<4; k++){
                if(cur[k]==0){
                    result[i]=colors[k];
                    break;
                }
            }
        }
        return result;
    }
}
