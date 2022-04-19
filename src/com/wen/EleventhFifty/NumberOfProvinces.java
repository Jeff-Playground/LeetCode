package com.wen.EleventhFifty;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    // BFS
    public int findCircleNum(int[][] M) {
        int N=M.length;
        int[] visited=new int[N];
        int result=0;
        for(int i=0; i<N; i++){
            if(visited[i]==0){
                visited[i]=1;
                result++;
                Queue<Integer> q=new LinkedList<>();
                q.offer(i);
                while(!q.isEmpty()){
                    int cur=q.poll();
                    for(int j=0; j<N; j++){
                        if(visited[j]==0 && M[cur][j]==1){
                            visited[j]=1;
                            q.offer(j);
                        }
                    }
                }
            }
        }
        return result;
    }

//    // DFS
//    public int findCircleNum(int[][] M) {
//        int N=M.length;
//        int[] visited=new int[N];
//        int result=0;
//        for(int i=0; i<N; i++){
//            if(visited[i]==0){
//                visited[i]=1;
//                result++;
//                fcnHelper(M, i, visited);
//            }
//        }
//        return result;
//    }
//
//    private void fcnHelper(int[][] M, int cur, int[] visited){
//        int N=M.length;
//        for(int i=0; i<N; i++){
//            if(visited[i]==0 && M[cur][i]==1){
//                visited[i]=1;
//                fcnHelper(M, i, visited);
//            }
//        }
//    }

//    // Union find
//    public int findCircleNum(int[][] M) {
//        int N=M.length;
//        UnionFind uf=new UnionFind(N);
//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                if(i!=j && M[i][j]==1){
//                    uf.union(i, j);
//                }
//            }
//        }
//        return uf.total;
//    }
//
//    private class UnionFind{
//        int[] root, count;
//        int total;
//
//        public UnionFind(int N){
//            root=new int[N];
//            count=new int[N];
//            for(int i=0; i<N; i++){
//                root[i]=i;
//                count[i]=1;
//            }
//            total=N;
//        }
//
//        public int findRoot(int cur){
//            while(root[cur]!=cur){
//                root[cur]=root[root[cur]];
//                cur=root[cur];
//            }
//            return cur;
//        }
//
//        public void union(int x, int y){
//            int xr=findRoot(x), yr=findRoot(y);
//            if(xr!=yr){
//                total--;
//                if(count[xr]>=count[yr]){
//                    root[yr]=xr;
//                    count[xr]+=count[yr];
//                } else{
//                    root[xr]=yr;
//                    count[yr]+=count[xr];
//                }
//            }
//        }
//    }
}
