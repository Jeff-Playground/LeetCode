package com.wen.FourteenthFifty;

import java.util.*;

public class RedundantConnection {
    // BFS
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Set<Integer>> graph=new HashMap<>();
        for(int[] edge: edges){
            Queue<Integer> q=new LinkedList<>();
            q.offer(edge[0]);
            Set<Integer> visited=new HashSet<>();
            while(!q.isEmpty()){
                int cur=q.poll();
                visited.add(cur);
                if(graph.get(cur)!=null){
                    for(int nb: graph.get(cur)){
                        if(nb==edge[1]){
                            return edge;
                        } else{
                            if(!visited.contains(nb)){
                                q.offer(nb);
                            }
                        }
                    }
                }
            }
            Set<Integer> nb1=graph.getOrDefault(edge[0], new HashSet<>());
            nb1.add(edge[1]);
            Set<Integer> nb2=graph.getOrDefault(edge[1], new HashSet<>());
            nb2.add(edge[0]);
            graph.put(edge[0], nb1);
            graph.put(edge[1], nb2);
        }
        return new int[]{-1, -1};
    }

//    // DFS
//    public int[] findRedundantConnection(int[][] edges) {
//        Map<Integer, Set<Integer>> graph=new HashMap<>();
//        for(int[] edge: edges){
//            if(hasCycle(edge[0], edge[1], graph, -1)){
//                return edge;
//            } else{
//                Set<Integer> nb1=graph.getOrDefault(edge[0], new HashSet<>());
//                nb1.add(edge[1]);
//                Set<Integer> nb2=graph.getOrDefault(edge[1], new HashSet<>());
//                nb2.add(edge[0]);
//                graph.put(edge[0], nb1);
//                graph.put(edge[1], nb2);
//            }
//        }
//        return new int[]{-1 ,-1};
//    }
//
//    private boolean hasCycle(int from, int to, Map<Integer, Set<Integer>> graph, int last){
//        if(graph.containsKey(from)){
//            for(int nb: graph.get(from)){
//                if(nb!=last && (nb==to || hasCycle(nb, to, graph, from))){
//                    return true;
//                }
//            }
//            return false;
//        } else{
//            return false;
//        }
//    }

//    // Union find
//    public static int[] findRedundantConnection(int[][] edges) {
//        int N=edges.length;
//        UnionFind uf=new UnionFind(N);
//        for(int[] edge: edges){
//            int n1=edge[0], n2=edge[1];
//            uf.add(n1);
//            uf.add(n2);
//            if(!uf.union(n1, n2)){
//                return n1<n2?new int[]{n1, n2}:new int[]{n2, n1};
//            }
//        }
//        return new int[]{-1, -1};
//    }
//
//    public static class UnionFind{
//        int[] pre;
//        int[] cnt;
//
//        public UnionFind(int count){
//            pre=new int[count+1];
//            cnt=new int[count+1];
//        }
//
//        public void add(int node){
//            if(pre[node]==0){
//                pre[node]=node;
//                cnt[node]=1;
//            }
//        }
//
//        public int findPre(int node){
//            while(pre[node]!=node){
//                pre[node]=pre[pre[node]];
//                node=pre[node];
//            }
//            return pre[node];
//        }
//
//        public boolean union(int n1, int n2){
//            if(isConnected(n1, n2)){
//                return false;
//            } else{
//                int pre1=findPre(n1);
//                int pre2=findPre(n2);
//                if(cnt[pre1]>cnt[pre2]){
//                    pre[pre2]=pre1;
//                    cnt[pre1]+=cnt[pre2];
//                } else{
//                    pre[pre1]=pre2;
//                    cnt[pre2]+=cnt[pre1];
//                }
//                return true;
//            }
//        }
//
//        public boolean isConnected(int n1, int n2){
//            int pre1=findPre(n1);
//            int pre2=findPre(n2);
//            return pre1==pre2;
//        }
//    }
}
