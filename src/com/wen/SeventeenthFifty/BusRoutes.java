package com.wen.SeventeenthFifty;

import java.util.*;

public class BusRoutes {
    // BFS
    public int numBusesToDestination(int[][] routes, int S, int T) {
        int l=routes.length, result=0;
        Map<Integer, Set<Integer>> stops=new HashMap<>();
        for(int i=0; i<l; i++){
            for(int stop: routes[i]){
                stops.putIfAbsent(stop, new HashSet<>());
                stops.get(stop).add(i);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        q.offer(S);
        visited.add(S);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                int cur=q.poll();
                if(cur==T){
                    return result;
                }
                for(int route: stops.get(cur)){
                    for(int stop: routes[route]){
                        if(!visited.contains(stop)){
                            visited.add(stop);
                            q.offer(stop);
                        }
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
