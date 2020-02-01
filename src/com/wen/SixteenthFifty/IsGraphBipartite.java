package com.wen.SixteenthFifty;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class IsGraphBipartite {
//    // DFS, recursive
//    public boolean isBipartite(int[][] graph) {
//        int l=graph.length;
//        int[] color=new int[l];
//        for(int i=0; i<l; i++){
//            if(color[i]!=0){
//                continue;
//            } else{
//                color[i]=1;
//                if(!isBipartiteDFS(graph, color, i)){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public boolean isBipartiteDFS(int[][] graph, int[] color, int last){
//        for(int node: graph[last]){
//            if(color[node]!=0 && color[node]==color[last]){
//                return false;
//            } else{
//                if(color[node]==0){
//                    color[node]=color[last]*(-1);
//                    if(!isBipartiteDFS(graph, color, node)){
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }

//    // DFS, iterative
//    public boolean isBipartite(int[][] graph) {
//        int l=graph.length;
//        int[] color=new int[l];
//        for(int i=0; i<l; i++){
//            if(color[i]!=0){
//                continue;
//            } else{
//                color[i]=1;
//                Queue<Integer> q=new LinkedList<>();
//                q.offer(i);
//                while(!q.isEmpty()){
//                    int cur=q.poll();
//                    for(int node: graph[cur]){
//                        if(color[node]==color[cur]){
//                            return false;
//                        } else{
//                            if(color[node]==0){
//                                color[node]=color[cur]*-1;
//                                q.offer(node);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return true;
//    }

    // Union find
    public boolean isBipartite(int[][] graph) {
        int l=graph.length;
        int[] group=new int[l];
        int[] count=new int[l];
        for(int i=0; i<l; i++){
            group[i]=i;
            count[i]=1;
        }
        for(int i=0; i<l; i++){
            if(graph[i]==null || graph[i].length==0){
                continue;
            }
            int x=findGroup(group, i), y=findGroup(group, graph[i][0]);
            if(x==y){
                return false;
            } else{
                for(int j=1; j<graph[i].length; j++){
                    int z=findGroup(group, graph[i][j]);
                    if(z==x){
                        return false;
                    } else{
                        unionGroup(group, count, z, y);
                    }
                }
            }
        }
        return true;
    }

    private void unionGroup(int[] group, int[] count, int a, int b){
        int groupA=findGroup(group, a), groupB=findGroup(group, b);
        if(groupA!=groupB){
            if(count[groupA]>count[groupB]){
                group[groupB]=groupA;
                count[groupA]+=count[groupB];
            } else{
                group[groupA]=groupB;
                count[groupB]+=count[groupA];
            }
        }
    }

    private int findGroup(int[] group, int cur){
        while(cur!=group[cur]){
            group[cur]=group[group[cur]];
            cur=group[cur];
        }
        return cur;
    }
}
