package com.wen.TwentyFourthFifty;

/*
There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.

For each house i, we can either build a well inside it directly with cost wells[i - 1] (note the -1 due to 0-indexing),
or pipe in water from another well to it. The costs to lay pipes between houses are given by the array pipes where each
pipes[j] = [house1j, house2j, costj] represents the cost to connect house1j and house2j together using a pipe.
Connections are bidirectional, and there could be multiple valid connections between the same two houses with different
costs.

Return the minimum total cost to supply water to all houses.

Example 1:
Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
Output: 3
Explanation: The image shows the costs of connecting houses using pipes.
The best strategy is to build a well in the first house with cost 1 and connect the other houses to it with cost 2 so
the total cost is 3.

Example 2:
Input: n = 2, wells = [1,1], pipes = [[1,2,1],[1,2,2]]
Output: 2
Explanation: We can supply water with cost two using one of the three options:
Option 1:
  - Build a well inside house 1 with cost 1.
  - Build a well inside house 2 with cost 1.
The total cost will be 2.
Option 2:
  - Build a well inside house 1 with cost 1.
  - Connect house 2 with house 1 with cost 1.
The total cost will be 2.
Option 3:
  - Build a well inside house 2 with cost 1.
  - Connect house 1 with house 2 with cost 1.
The total cost will be 2.
Note that we can connect houses 1 and 2 with cost 1 or with cost 2 but we will always choose the cheapest option.


Constraints:
2 <= n <= 104
wells.length == n
0 <= wells[i] <= 105
1 <= pipes.length <= 104
pipes[j].length == 3
1 <= house1j, house2j <= n
0 <= costj <= 105
house1j != house2j
 */

import java.util.*;

public class LQOptimizeWaterDistributionInAVillage {
    // Kruskal's algorithm
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[2]-b[2]);
        for(int[] p: pipes){
            pq.offer(p);
        }
        // Create a virtual node 0, where every real node is connected to with an edge of wells[i], so including this
        // point ensures there's at least 1 well supply included in the MST
        for(int i=0; i<n; i++){
            pq.offer(new int[]{0, i+1, wells[i]});
        }
        int result=0;
        UnionFind uf=new UnionFind(n+1);
        while(!pq.isEmpty() && uf.count>1){
            int[] cur=pq.poll();
            int x=cur[0], y=cur[1], c=cur[2];
            if(uf.find(x)!=uf.find(y)){
                uf.union(x, y);
                result+=c;
            }
        }
        return result;
    }

    private class UnionFind{
        int[] root, rank;
        int count;

        public UnionFind(int l){
            root=new int[l];
            rank=new int[l];
            count=l;
            for(int i=0; i<l; i++){
                root[i]=i;
                rank[i]=1;
            }
        }

        public int find(int x){
            if(root[x]!=x){
                root[x]=find(root[x]);
            }
            return root[x];
        }

        public void union(int x, int y){
            int rx=find(x), ry=find(y);
            if(rx!=ry){
                if(rank[rx]>rank[ry]){
                    root[ry]=rx;
                } else if(rank[rx]<rank[ry]){
                    root[rx]=ry;
                } else{
                    root[rx]=ry;
                    rank[ry]++;
                }
                count--;
            }
        }
    }

//    // Prim's algorithm
//    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
//        Map<Integer, Map<Integer, Integer>> graph=new HashMap<>();
//        for(int[] p: pipes){
//            int x=p[0], y=p[1], c=p[2];
//            graph.putIfAbsent(x, new HashMap<>());
//            graph.putIfAbsent(y, new HashMap<>());
//            graph.get(x).put(y, Math.min(graph.get(x).getOrDefault(y, Integer.MAX_VALUE), c));
//            graph.get(y).put(x, Math.min(graph.get(y).getOrDefault(x, Integer.MAX_VALUE), c));
//        }
//        // Create a virtual node 0, where every real node is connected to with an edge of wells[i], so including this
//        // point ensures there's at least 1 well supply included in the MST
//        for(int i=0; i<n; i++){
//            graph.putIfAbsent(0, new HashMap<>());
//            graph.putIfAbsent(i+1, new HashMap<>());
//            graph.get(0).put(i+1, wells[i]);
//            graph.get(i+1).put(0, wells[i]);
//        }
//        int result=0;
//        Set<Integer> visited=new HashSet<>();
//        visited.add(0);
//        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[1]-b[1]);
//        for(int node: graph.getOrDefault(0, new HashMap<>()).keySet()){
//            pq.offer(new int[]{node, graph.get(0).get(node)});
//        }
//        while(visited.size()<n+1){
//            int[] cur=pq.poll();
//            if(!visited.contains(cur[0])){
//                visited.add(cur[0]);
//                result+=cur[1];
//                for(int node: graph.getOrDefault(cur[0], new HashMap<>()).keySet()){
//                    if(!visited.contains(node)){
//                        pq.offer(new int[]{node, graph.get(cur[0]).get(node)});
//                    }
//                }
//            }
//        }
//        return result;
//    }
}
