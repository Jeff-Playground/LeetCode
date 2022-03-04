package com.wen.TwentyFifthFifty;

import java.util.*;

public class SmallestStringWithSwaps {
    // DFS
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int l=s.length();
        Map<Integer, Set<Integer>> graph=new HashMap<>();
        for(List<Integer> p: pairs){
            int x=p.get(0), y=p.get(1);
            graph.putIfAbsent(x, new HashSet<>());
            graph.putIfAbsent(y, new HashSet<>());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int[] visited=new int[l];
        char[] result=new char[l];
        for(int i=0; i<l; i++){
            if(visited[i]!=1){
                List<Integer> indices=new ArrayList<>();
                List<Character> chars=new ArrayList<>();
                sswHelper(graph, visited, i, s, indices, chars);
                Collections.sort(indices);
                Collections.sort(chars);
                for(int j=0; j<indices.size(); j++){
                    result[indices.get(j)]=chars.get(j);
                }
            }
        }
        return new String(result);
    }

    private void sswHelper(Map<Integer, Set<Integer>> graph, int[] visited, int cur, String s, List<Integer> indices, List<Character> chars){
        if(visited[cur]==0){
            visited[cur]=1;
            indices.add(cur);
            chars.add(s.charAt(cur));
            for(int n: graph.getOrDefault(cur, new HashSet<>())){
                sswHelper(graph, visited, n, s, indices, chars);
            }
        }
    }

//    // Union find
//    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
//        int l=s.length();
//        UnionFind uf=new UnionFind(l);
//        for(List<Integer> p: pairs){
//            uf.union(p.get(0), p.get(1));
//        }
//        Map<Integer, PriorityQueue<Character>> groups=new HashMap<>();
//        for(int i=0; i<l; i++){
//            int ri=uf.find(i);
//            groups.putIfAbsent(ri, new PriorityQueue<>());
//            groups.get(ri).offer(s.charAt(i));
//        }
//        StringBuilder sb=new StringBuilder();
//        for(int i=0; i<l; i++){
//            sb.append(groups.get(uf.find(i)).poll());
//        }
//        return sb.toString();
//    }
//
//    // Union find implementation with path compression and union by rank optimizations
//    private class UnionFind{
//        int[] root, rank;
//
//        public UnionFind(int l){
//            root=new int[l];
//            rank=new int[l];
//            for(int i=0; i<l; i++){
//                root[i]=i;
//                rank[i]=1;
//            }
//        }
//
//        public int find(int x){
//            if(x!=root[x]){
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
//                    root[rx]=ry;
//                    rank[ry]++;
//                }
//            }
//        }
//    }
}
