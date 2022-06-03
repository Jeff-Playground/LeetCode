package com.wen.ThirtyFirstFifty;

import java.util.*;

public class PathWithMaximumProbability {
//    // Dijkstra, note here Dijkstra works because the graph edges are -log(p), and because p<1, -log(p)>0, in other words,
//    // this works because the graph edges are none negative
//    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
//        Map<Integer, Map<Integer, Double>> graph=new HashMap<>();
//        for(int i=0; i<edges.length; i++){
//            int[] e=edges[i];
//            double p=succProb[i];
//            graph.putIfAbsent(e[0], new HashMap<>());
//            graph.putIfAbsent(e[1], new HashMap<>());
//            graph.get(e[0]).put(e[1], -Math.log(p));
//            graph.get(e[1]).put(e[0], -Math.log(p));
//        }
//        if(graph.containsKey(start) && graph.containsKey(end)){
//            Map<Integer, Double> length=new HashMap<>();
//            length.put(start,0.0);
//            PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->length.get(a[0])+graph.get(a[0]).get(a[1])-length.get(b[0])-graph.get(b[0]).get(b[1])<0?-1:1);
//            for(int k: graph.get(start).keySet()){
//                pq.offer(new int[]{start, k});
//            }
//            while(!pq.isEmpty()){
//                int[] cur=pq.poll();
//                if(!length.containsKey(cur[1])){
//                    length.put(cur[1], length.get(cur[0])+graph.get(cur[0]).get(cur[1]));
//                    if(cur[1]==end){
//                        break;
//                    } else{
//                        for(int k: graph.get(cur[1]).keySet()){
//                            if(!length.containsKey(k)){
//                                pq.offer(new int[]{cur[1], k});
//                            }
//                        }
//                    }
//                }
//            }
//            if(length.containsKey(end)){
//                return Math.exp(-length.get(end));
//            } else{
//                return 0;
//            }
//        } else{
//            return 0;
//        }
//    }

    // SPFA, note the built graph edges are all guaranteed to be positive, otherwise will need extra count array to ensure
    // the path between the source and each node is relaxed no more than n-1 times
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> graph=new HashMap<>();
        for(int i=0; i<edges.length; i++){
            int[] e=edges[i];
            double p=succProb[i];
            graph.putIfAbsent(e[0], new HashMap<>());
            graph.putIfAbsent(e[1], new HashMap<>());
            graph.get(e[0]).put(e[1], -Math.log(p));
            graph.get(e[1]).put(e[0], -Math.log(p));
        }
        if(graph.containsKey(start) && graph.containsKey(end)){
            Map<Integer, Double> length=new HashMap<>();
            Queue<Integer> q=new LinkedList<>();
            q.offer(start);
            length.put(start, 0.0);
            while(!q.isEmpty()){
                int cur=q.poll();
                for(int k: graph.get(cur).keySet()){
                    if(!length.containsKey(k) || length.get(k)>length.get(cur)+graph.get(cur).get(k)){
                        length.put(k, length.get(cur)+graph.get(cur).get(k));
                        q.offer(k);
                    }
                }
            }
            if(length.containsKey(end)){
                return Math.exp(-length.get(end));
            } else{
                return 0;
            }
        } else{
            return 0;
        }
    }

//    // Bellman-Ford, note the built graph edges are all guaranteed to be positive, otherwise will need to ensure the path
//    // between the source and each node is relaxed no more than n-1 times by limiting the outer loop execution times
//    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
//        Map<Integer, Double> length=new HashMap<>();
//        length.put(start, 0.0);
//        boolean changed=true;
//        while(changed){
//            changed=false;
//            for(int i=0; i<edges.length; i++){
//                int[] e=edges[i];
//                int x=e[0], y=e[1];
//                double d=-Math.log(succProb[i]);
//                if(length.containsKey(x) && (!length.containsKey(y) || length.get(x)+d<length.get(y))){
//                    changed=true;
//                    length.put(y, length.get(x)+d);
//                } else if(length.containsKey(y) && (!length.containsKey(x) || length.get(y)+d<length.get(x))){
//                    changed=true;
//                    length.put(x, length.get(y)+d);
//                }
//            }
//        }
//        if(length.containsKey(end)){
//            return Math.exp(-length.get(end));
//        } else{
//            return 0;
//        }
//    }
}
