package com.wen.SeventeenthFifty;

import java.util.*;

public class SimilarStringGroups {
    // BFS
    public int numSimilarGroups(String[] A) {
        int l=A.length, result=0;
        Set<String> visited=new HashSet<>();
        for(int i=0; i<l; i++){
            if(!visited.contains(A[i])){
                result++;
                Queue<Integer> q=new LinkedList<>();
                q.offer(i);
                visited.add(A[i]);
                while(!q.isEmpty()){
                    int idx=q.poll();
                    for(int j=0; j<l; j++){
                        if(!visited.contains(A[j]) && isSimilar(A[j], A[idx])){
                            q.offer(j);
                            visited.add(A[j]);
                        }
                    }
                }
            }
        }
        return result;
    }

//    // DFS
//    public int numSimilarGroups(String[] A) {
//        int l=A.length, result=0;
//        Set<String> visited=new HashSet<>();
//        for(int i=0; i<l; i++){
//            if(!visited.contains(A[i])){
//                result+=1;
//                visited.add(A[i]);
//                visitAllSimilar(A, i, visited);
//            }
//        }
//        return result;
//    }
//
//    private void visitAllSimilar(String[] A, int idx, Set<String> visited){
//        String cur=A[idx];
//        for(int i=0; i<A.length; i++){
//            if(!visited.contains(A[i]) && isSimilar(A[i], cur)){
//                visited.add(A[i]);
//                visitAllSimilar(A, i, visited);
//            }
//        }
//    }

    private boolean isSimilar(String a, String b){
        int count=0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)){
                if(++count>2){
                    return false;
                }
            }
        }
        return true;
    }

//    // Union find
//    public int numSimilarGroups(String[] A) {
//        int l=A.length;
//        UnionFind uf=new UnionFind(l);
//        for(int i=1; i<l; i++){
//            for(int j=0; j<i; j++){
//                if(isSimilar(A[i], A[j])){
//                    uf.union(i, j);
//                }
//            }
//        }
//        return uf.total;
//    }
//
//    private class UnionFind{
//        int total=-1;
//        int[] root, count;
//
//        public UnionFind(int n){
//            total=n;
//            root=new int[n];
//            for(int i=0; i<n; i++){
//                root[i]=i;
//            }
//            count=new int[n];
//            Arrays.fill(count, 1);
//        }
//
//        public void union(int a, int b){
//            int rootA=find(a), rootB=find(b);
//            if(rootA!=rootB){
//                if(count[rootA]>count[rootB]){
//                    root[rootB]=root[rootA];
//                    count[rootA]+=count[rootB];
//                } else{
//                    root[rootA]=root[rootB];
//                    count[rootB]+=count[rootA];
//                }
//                total--;
//            }
//        }
//
//        public int find(int a){
//            int cur=a;
//            while(cur!=root[cur]){
//                root[cur]=root[root[cur]];
//                cur=root[cur];
//            }
//            return cur;
//        }
//    }
}
