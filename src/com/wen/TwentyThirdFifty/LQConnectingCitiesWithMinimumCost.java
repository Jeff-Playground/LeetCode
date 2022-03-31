package com.wen.TwentyThirdFifty;

/*
There are n cities labeled from 1 to n. You are given the integer n and an array connections where
connections[i] = [xi, yi, costi] indicates that the cost of connecting city xi and city yi (bidirectional connection) is
costi.

Return the minimum cost to connect all the n cities such that there is at least one path between each pair of cities. If
it is impossible to connect all the n cities, return -1,

The cost is the sum of the connections' costs used.



Example 1:
Input: n = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
Output: 6
Explanation: Choosing any 2 edges will connect all cities so we choose the minimum 2.


Example 2:
Input: n = 4, connections = [[1,2,3],[3,4,4]]
Output: -1
Explanation: There is no way to connect all cities even if all edges are used.


Constraints:
1 <= n <= 104
1 <= connections.length <= 104
connections[i].length == 3
1 <= xi, yi <= n
xi != yi
0 <= costi <= 105
 */

import java.util.*;

public class LQConnectingCitiesWithMinimumCost {
    // Prim's algo
    public int minimumCost(int n, int[][] connections) {
        Map<Integer, Map<Integer, Integer>> graph=new HashMap<>();
        for(int[] c: connections){
            int x=c[0], y=c[1], cost=c[2];
            graph.putIfAbsent(x, new HashMap<>());
            graph.putIfAbsent(y, new HashMap<>());
            // Note this is to consider when there're multiple edges between two vertices that have different costs
            graph.get(x).put(y, Math.min(graph.get(x).getOrDefault(y, Integer.MAX_VALUE), cost));
            graph.get(y).put(x, Math.min(graph.get(y).getOrDefault(x, Integer.MAX_VALUE), cost));
        }
        Set<Integer> v=new HashSet<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{1, 0});
        int result=0;
        while(v.size()<n && !pq.isEmpty()){
            int[] cur=pq.poll();
            int y=cur[0], c=cur[1];
            if(!v.contains(y)){
                v.add(y);
                result+=c;
                for(int k: graph.get(y).keySet()){
                    if(!v.contains(k)){
                        pq.offer(new int[]{k, graph.get(y).get(k)});
                    }
                }
            }
        }
        return v.size()==n?result:-1;
    }

//    // Kruskal's algo
//    public int minimumCost(int n, int[][] connections) {
//        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[2]-b[2]);
//        for(int[] c: connections){
//            pq.offer(c);
//        }
//        UnionFind uf=new UnionFind(n);
//        int result=0;
//        while(uf.count>1 && !pq.isEmpty()){
//            int[] cur=pq.poll();
//            int x=cur[0]-1, y=cur[1]-1, c=cur[2];
//            if(!uf.isConnected(x, y)){
//                uf.union(x, y);
//                result+=c;
//            }
//        }
//        return uf.count==1?result:-1;
//    }
//
//    private class UnionFind{
//        int[] root, rank;
//        int count;
//
//        public UnionFind(int n){
//            root=new int[n];
//            rank=new int[n];
//            for(int i=0; i<n; i++){
//                root[i]=i;
//                rank[i]=1;
//            }
//            count=n;
//        }
//
//        public int find(int x){
//            if(root[x]!=x){
//                root[x]=find(root[x]);
//            }
//            return root[x];
//        }
//
//        public void union(int x, int y){
//            int rx=find(x), ry=find(y);
//            if(rx!=ry){
//                if(rank[rx]>rank[ry]){
//                    root[ry]=rx;
//                } else if(rank[rx]<rank[ry]){
//                    root[rx]=ry;
//                } else{
//                    root[ry]=rx;
//                    rank[rx]++;
//                }
//                count--;
//            }
//        }
//
//        public boolean isConnected(int x, int y){
//            int rx=find(x), ry=find(y);
//            return rx==ry;
//        }
//    }
}
