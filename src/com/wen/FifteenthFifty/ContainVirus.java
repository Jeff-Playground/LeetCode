package com.wen.FifteenthFifty;

import java.util.*;
import java.util.stream.Collectors;

public class ContainVirus {
    // BFS and update the grid every time
    public int containVirus(int[][] isInfected) {
        int m=isInfected.length, n=isInfected[0].length;
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int result=0;
        List<List<List<Integer>>> cache=new ArrayList<>();
        do{
            cache.clear();
            int[][] visited=new int[m][n];
            List<List<Integer>> toBeProcessed=null;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(isInfected[i][j]==1 && visited[i][j]==0){
                        visited[i][j]=1;
                        Queue<Integer> q=new LinkedList<>();
                        q.offer(i*n+j);
                        List<Integer> virus=new ArrayList<>();
                        List<Integer> walls=Arrays.asList(0);
                        List<Integer> cells=new ArrayList<>();
                        virus.add(i*n+j);
                        while(!q.isEmpty()){
                            int cur=q.poll();
                            int cx=cur/n, cy=cur%n;
                            for(int[] dir: dirs){
                                int x=cx+dir[0], y=cy+dir[1];
                                if(x>=0 && x<m && y>=0 && y<n && visited[x][y]==0){
                                    if(isInfected[x][y]==1){
                                        visited[x][y]=1;
                                        q.offer(x*n+y);
                                        virus.add(x*n+y);
                                    } else if(isInfected[x][y]==0){
                                        walls.set(0, walls.get(0)+1);
                                        cells.add(x*n+y);
                                    }
                                }
                            }
                        }
                        List<List<Integer>> area=new ArrayList<>();
                        area.add(walls);
                        area.add(virus);
                        area.add(cells.stream().distinct().collect(Collectors.toList()));
                        if(toBeProcessed==null){
                            toBeProcessed=area;
                        } else if(toBeProcessed.get(2).size()>=area.get(2).size()){
                            cache.add(area);
                        } else{
                            cache.add(toBeProcessed);
                            toBeProcessed=area;
                        }
                    }
                }
            }
            if(toBeProcessed!=null){
                result+=toBeProcessed.get(0).get(0);
                for(int e: toBeProcessed.get(1)){
                    int i=e/n, j=e%n;
                    isInfected[i][j]=-1;
                }
            }
            for(List<List<Integer>> e: cache){
                for(int v: e.get(2)){
                    isInfected[v/n][v%n]=1;
                }
            }
        } while(!cache.isEmpty());
        return result;
    }

//    // Union find
//    public int containVirus(int[][] isInfected) {
//        int m=isInfected.length, n=isInfected[0].length;
//        UnionFind uf=new UnionFind(isInfected);
//            int[][] visited=new int[m][n];
//            for(int i=0; i<m; i++){
//                for(int j=0; j<n; j++){
//                    if(visited[i][j]==0 && isInfected[i][j]==1 && !uf.walled.contains(uf.find(i*n+j))){
//                        cvHelper(i, j, uf, visited);
//                    }
//                }
//            }
//        while(uf.willInfect.size()>0){
//            uf.addWall();
//        }
//        return uf.wallCount;
//    }
//
//    private void cvHelper(int i, int j, UnionFind uf, int[][] visited){
//        visited[i][j]=1;
//        int m=uf.status.length, n=uf.status[0].length;
//        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//        boolean canExtend=true;
//        for(int[] dir: dirs){
//            int x=i+dir[0], y=j+dir[1];
//            if(x>=0 && x<m && y>=0 && y<n && visited[x][y]==0 && uf.status[x][y]==1 && !uf.walled.contains(uf.find(x*n+y))){
//                uf.union(i*n+j, x*n+y);
//                cvHelper(x, y, uf, visited);
//                canExtend=false;
//            }
//        }
//        if(canExtend && uf.find(i*n+j)==i*n+j){
//            uf.willInfect.putIfAbsent(i*n+j, uf.canInfect(i*n+j));
//        }
//    }
//
//    private class UnionFind{
//        int[][] status;
//        int[][] uf;
//        Map<Integer, Set<Integer>> willInfect;
//        int wallCount;
//        Set<Integer> walled;
//        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//
//        public UnionFind(int[][] isInfected){
//            status=isInfected;
//            int m=isInfected.length, n=isInfected[0].length;
//            uf=new int[m][n];
//            for(int[] row: uf){
//                Arrays.fill(row, -1);
//            }
//            willInfect=new HashMap<>();
//            wallCount=0;
//            walled=new HashSet<>();
//        }
//
//        public void addWall(){
//            int m=status.length, n=status[0].length;
//            int maxr=-1;
//            for(int key: willInfect.keySet()){
//                if(maxr==-1 || willInfect.get(maxr).size()<willInfect.get(key).size()){
//                    maxr=key;
//                }
//            }
//            for(int next: willInfect.get(maxr)){
//                for(int[] dir: dirs){
//                    int i=next/n+dir[0], j=next%n+dir[1];
//                    if(i>=0 && i<m && j>=0 && j<n && status[i][j]==1){
//                        int cur=i*n+j, r=find(cur);
//                        if(r==maxr){
//                            wallCount++;
//                        }
//                    }
//                }
//            }
//            walled.add(maxr);
//            willInfect.remove(maxr);
//            Map<Integer, Set<Integer>> infected=new HashMap<>();
//            for(int key: willInfect.keySet()){
//                infected.put(key, new HashSet<>());
//                for(int next: willInfect.get(key)){
//                    status[next/n][next%n]=1;
//                    infected.get(key).add(next);
//                }
//                willInfect.get(key).clear();
//            }
//            for(int key: infected.keySet()){
//                for(int next: infected.get(key)){
//                    union(key, next);
//                    for(int[] dir: dirs){
//                        int i=next/n+dir[0], j=next%n+dir[1];
//                        if(i>=0 && i<m && j>=0 && j<n && status[i][j]==1){
//                            int r=find(i*n+j);
//                            if(r!=find(next) && !walled.contains(r)){
//                                union(r, next);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        public void union(int a, int b){
//            int n=status[0].length;
//            int ra=find(a), rb=find(b);
//            if(ra!=rb){
//                int rai=ra/n, raj=ra%n;
//                int rbi=rb/n, rbj=rb%n;
//                if(!willInfect.containsKey(ra)){
//                    willInfect.put(ra, canInfect(ra));
//                }
//                if(!willInfect.containsKey(rb)){
//                    willInfect.put(rb, canInfect(rb));
//                }
//                if(ra<rb){
//                    uf[rbi][rbj]=ra;
//                    willInfect.get(ra).addAll(willInfect.get(rb));
//                    willInfect.remove(rb);
//                } else{
//                    uf[rai][raj]=rb;
//                    willInfect.get(rb).addAll(willInfect.get(ra));
//                    willInfect.remove(ra);
//                }
//            }
//        }
//
//        private int find(int a){
//            int n=status[0].length;
//            int ai=a/n, aj=a%n;
//            if(uf[ai][aj]==-1){
//                uf[ai][aj]=a;
//            }
//            while(uf[ai][aj]!=a){
//                uf[ai][aj]=find(uf[ai][aj]);
//                a=uf[ai][aj];
//            }
//            return a;
//        }
//
//        private Set<Integer> canInfect(int a){
//            int m=status.length, n=status[0].length;
//            int ai=a/n, aj=a%n;
//            Set<Integer> result=new HashSet<>();
//            for(int[] dir: dirs){
//                int i=ai+dir[0], j=aj+dir[1];
//                if(i>=0 && i<m && j>=0 && j<n && status[i][j]==0){
//                    result.add(i*n+j);
//                }
//            }
//            return result;
//        }
//    }
}
