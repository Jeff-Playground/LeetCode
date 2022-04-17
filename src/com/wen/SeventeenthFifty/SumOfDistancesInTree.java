package com.wen.SeventeenthFifty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumOfDistancesInTree {
    // Tree post-order traversal
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // If only 1 node, return 0 for the node
        if(n==1){
            return new int[]{0};
        }
        // Build an undirected graph
        Map<Integer, Set<Integer>> graph=new HashMap<>();
        for(int[] e: edges){
            int x=e[0], y=e[1];
            graph.putIfAbsent(x, new HashSet<>());
            graph.putIfAbsent(y, new HashSet<>());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        // nodeCount[i] is the number of nodes for the tree with root i
        // edgeCount[i] is the number of edges to all child nodes(including the indirect children) from root i
        int[] nodeCount=new int[n], edgeCount=new int[n];
        // Note in such a tree, any node can be the root, so here we can start from any node other than 0 also
        getChildCounts(graph, 0, -1, nodeCount, edgeCount);
        getParentCounts(graph, 0, -1, nodeCount, edgeCount);
        return edgeCount;
    }

    // This calculates the values only for the subtree with root cur but below cur
    private void getChildCounts(Map<Integer, Set<Integer>> graph, int cur, int pre, int[] nodeCount, int[] edgeCount){
        for(int child: graph.get(cur)){
            if(child!=pre){
                getChildCounts(graph, child, cur, nodeCount, edgeCount);
                nodeCount[cur]+=nodeCount[child];
                edgeCount[cur]+=edgeCount[child]+nodeCount[child];
            }
        }
        nodeCount[cur]+=1;
    }

    // This calculates the values based on previous recursion, and adds the values for the tree above the subtree with root cur
    private void getParentCounts(Map<Integer, Set<Integer>> graph, int cur, int pre, int[] nodeCount, int[] edgeCount){
        if(pre!=-1){
            edgeCount[cur]+=(edgeCount[pre]-edgeCount[cur]-nodeCount[cur])+(nodeCount[pre]-nodeCount[cur]);
            nodeCount[cur]+=nodeCount[pre]-nodeCount[cur];
        }
        for(int child: graph.get(cur)){
            if(child!=pre){
                getParentCounts(graph, child, cur, nodeCount, edgeCount);
            }
        }
    }
}
