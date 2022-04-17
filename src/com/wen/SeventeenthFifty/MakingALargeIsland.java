package com.wen.SeventeenthFifty;

import java.util.*;

public class MakingALargeIsland {
//    // Naive BFS, will TLE in JAVA, also solvable by DFS(start with each 0, make it 1 and get the island size)
//    public int largestIsland(int[][] grid) {
//        int m=grid.length, n=grid[0].length;
//        int max=1;
//        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//        boolean noWater=true;
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(grid[i][j]==0){
//                    noWater=false;
//                    grid[i][j]=1;
//                    Set<Integer> visited=new HashSet<>();
//                    int total=1;
//                    visited.add(i*n+j);
//                    Queue<Integer> q=new LinkedList<>();
//                    q.offer(i*n+j);
//                    while(!q.isEmpty()){
//                        int cur=q.poll();
//                        int x=cur/n, y=cur%n;
//                        for(int[] d: dirs){
//                            int nx=x+d[0], ny=y+d[1];
//                            if(nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny]==1 && !visited.contains(nx*n+ny)){
//                                visited.add(nx*n+ny);
//                                q.offer(nx*n+ny);
//                                total++;
//                            }
//                        }
//                    }
//                    max=Math.max(max, total);
//                    grid[i][j]=0;
//                }
//            }
//        }
//        return noWater?m*n:max;
//    }

    // Union find
    public int largestIsland(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        Map<Integer, Integer> root=new HashMap<>();
        Map<Integer, Integer> count=new HashMap<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    int r=i*n+j;
                    int total=0;
                    Queue<Integer> q=new LinkedList<>();
                    q.offer(r);
                    grid[i][j]=-1;
                    total++;
                    root.put(r, r);
                    while(!q.isEmpty()){
                        int cur=q.poll();
                        int x=cur/n, y=cur%n;
                        for(int[] d:dirs){
                            int nx=x+d[0], ny=y+d[1];
                            if(nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny]==1){
                                grid[nx][ny]=-1;
                                total++;
                                q.offer(nx*n+ny);
                                root.put(nx*n+ny, r);
                            }
                        }
                    }
                    count.put(r, total);
                }
            }
        }
        if(count.isEmpty()){
            return 1;
        } else if(count.size()==1){
            int area=count.values().iterator().next();
            return area<m*n?area+1:area;
        } else{
            int max=0;
            Set<String> combined=new HashSet<>();
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(grid[i][j]==0){
                        TreeSet<Integer> combine=new TreeSet<>();
                        int total=1;
                        for(int[] d: dirs){
                            int x=i+d[0], y=j+d[1];
                            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==-1){
                                combine.add(root.get(x*n+y));
                            }
                        }
                        StringBuilder sb=new StringBuilder();
                        for(int c: combine){
                            sb.append(c+",");
                            total+=count.get(c);
                        }
                        if(!combined.contains(sb.toString())){
                            combined.add(sb.toString());
                            max=Math.max(max, total);
                        }
                    }
                }
            }
            return max;
        }
    }
}
