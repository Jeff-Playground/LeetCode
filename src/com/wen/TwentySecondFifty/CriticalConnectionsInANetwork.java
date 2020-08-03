package com.wen.TwentySecondFifty;

import java.util.*;

public class CriticalConnectionsInANetwork {
    // Tarjan's algorithm
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result=new ArrayList<>();
        Map<Integer, Set<Integer>> graph=new HashMap<>();
        for(List<Integer> e: connections){
            int v1=e.get(0), v2=e.get(1);
            Set<Integer> nb1=graph.getOrDefault(v1, new HashSet<>());
            nb1.add(v2);
            graph.put(v1, nb1);
            Set<Integer> nb2=graph.getOrDefault(v2, new HashSet<>());
            nb2.add(v1);
            graph.put(v2, nb2);
        }
        int[] ids=new int[n], low=new int[n];
        int[] id=new int[]{0};
        Arrays.fill(ids, -1);
        Arrays.fill(low, -1);
        tarjan(0, 0, graph, ids, low, id, result);
        return result;
    }

    private static void tarjan(int node, int parent, Map<Integer, Set<Integer>> graph, int[] ids, int[] low, int[] id, List<List<Integer>> result){
        ids[node]=id[0]++;
        low[node]=ids[node];
        for(int nb: graph.get(node)){
            if(nb!=parent){
                if(ids[nb]==-1){
                    tarjan(nb, node, graph, ids, low, id, result);
                    if(ids[node]<low[nb]){
                        result.add(Arrays.asList(node, nb));
                    }
                    low[node]=Math.min(low[node], low[nb]);
                } else{
                    low[node]=Math.min(low[node], ids[nb]);
                }
                // Note here it could simply be like below, only low[nb] at this point is not necessarily computed, but it doesn't affect the final result
//                if(ids[nb]==-1){
//                    tarjan(nb, node, graph, ids, low, cur, result);
//                    if(ids[node]<low[nb]){
//                        result.add(Arrays.asList(node, nb));
//                    }
//                }
//                low[node]=Math.min(low[node], low[nb]);
            }
        }
    }
}