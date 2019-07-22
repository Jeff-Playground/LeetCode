package com.wen.SixthFifty;

import java.util.*;

public class LQGraphValidTree {
    // DFS
    public boolean validTree(int n, int[][] edges) {
        if(n==1 && edges.length==0){
            return true;
        }
        Set<Integer> visited=new HashSet<>();
        Map<Integer, Set<Integer>> graph=new HashMap<>();
        for(int[] edge: edges){
            Set<Integer> set0=graph.getOrDefault(edge[0], new HashSet<>());
            Set<Integer> set1=graph.getOrDefault(edge[1], new HashSet<>());
            set0.add(edge[1]);
            set1.add(edge[0]);
            graph.put(edge[0], set0);
            graph.put(edge[1], set1);
        }
        if(!validTreeDFS(0, graph, visited)){
            return false;
        }
        return visited.size()==n;
    }

    public boolean validTreeDFS(int node, Map<Integer, Set<Integer>> graph, Set<Integer> visited){
        if(visited.contains(node)){
            return false;
        } else{
            visited.add(node);
            if(graph.get(node)!=null){
                for(int neighbor: graph.get(node)){
                    graph.get(neighbor).remove(node);
                    if(!validTreeDFS(neighbor, graph, visited)){
                        return false;
                    }
                }
            }
            return true;
        }
    }

//    // BFS
//    public static boolean validTree(int n, int[][] edges) {
//        if(n==1 && edges.length==0){
//            return true;
//        }
//        Set<Integer> visited=new HashSet<>();
//        Map<Integer, Set<Integer>> graph=new HashMap<>();
//        for(int[] edge: edges){
//            Set<Integer> set0=graph.getOrDefault(edge[0], new HashSet<>());
//            Set<Integer> set1=graph.getOrDefault(edge[1], new HashSet<>());
//            set0.add(edge[1]);
//            set1.add(edge[0]);
//            graph.put(edge[0], set0);
//            graph.put(edge[1], set1);
//        }
//        Queue<Integer> q=new LinkedList<>();
//        q.offer(0);
//        visited.add(0);
//        while(!q.isEmpty()){
//            int cur=q.poll();
//            if(graph.get(cur)!=null){
//                for(int neighbor: graph.get(cur)){
//                    if(visited.contains(neighbor)){
//                        return false;
//                    } else{
//                        q.offer(neighbor);
//                        visited.add(neighbor);
//                        graph.get(neighbor).remove(cur);
//                    }
//                }
//            }
//        }
//        return visited.size()==n;
//    }

//    // UnionFind
//    public static boolean validTree(int n, int[][] edges) {
//        if(n==1 && edges.length==0){
//            return true;
//        }
//        UnionFind uf=new UnionFind(n);
//        for(int[] edge: edges){
//            int pre0=uf.findPre(edge[0]);
//            int pre1=uf.findPre(edge[1]);
//            if(pre0>=0 && pre0==pre1){
//                return false;
//            } else{
//                uf.add(edge[0]);
//                uf.add(edge[1]);
//                uf.union(edge[0], edge[1]);
//            }
//        }
//        for(int i=0; i<n; i++){
//            if(!uf.exists(i)){
//                return false;
//            }
//        }
//        return uf.total==1;
//    }
//
//    public static class UnionFind{
//        int[] pre;
//        int[] count;
//        public int total=0;
//
//        public UnionFind(int n){
//            pre=new int[n];
//            count=new int[n];
//            Arrays.fill(pre, -1);
//        }
//
//        public void add(int x){
//            if(exists(x)){
//                return;
//            }
//            pre[x]=x;
//            count[x]=1;
//            total++;
//        }
//
//        public int findPre(int x){
//            if(!exists(x)){
//                return -1;
//            } else{
//                int r=x;
//                while(pre[r]!=r){
//                    r=pre[r];
//                }
//                int cur=x;
//                while(pre[cur]!=r){
//                    int temp=pre[cur];
//                    pre[cur]=r;
//                    cur=temp;
//                }
//                return r;
//            }
//        }
//
//        public void union(int a, int b){
//            int preA=findPre(a), preB=findPre(b);
//            if(preA!=preB){
//                if(count[preA]<count[preB]){
//                    pre[preA]=preB;
//                    count[preB]+=count[preA];
//                } else{
//                    pre[preB]=preA;
//                    count[preA]+=count[preB];
//                }
//                total--;
//            }
//        }
//
//        public boolean exists(int x){
//            return pre[x]>=0;
//        }
//    }
}
