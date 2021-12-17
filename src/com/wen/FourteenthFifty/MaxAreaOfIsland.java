package com.wen.FourteenthFifty;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {
    // Union find
    private class UnionFind{
        int[] root;
        int[] count;
        int max;

        public UnionFind(int l){
            root=new int[l];
            count=new int[l];
            Arrays.fill(root, -1);
            max=0;
        }

        public void add(int x){
            root[x]=x;
            count[x]=1;
            if(max==0){
                max=1;
            }
        }

        public void union(int x, int y){
            int rx=find(x), ry=find(y);
            if(rx!=ry){
                if(count[rx]>=count[ry]){
                    root[ry]=rx;
                    count[rx]+=count[ry];
                    max=Math.max(max, count[rx]);
                } else{
                    root[rx]=ry;
                    count[ry]+=count[rx];
                    max=Math.max(max, count[ry]);
                }
            }
        }

        public int find(int x){
            int cur=x;
            while(root[cur]!=cur){
                root[cur]=root[root[cur]];
                cur=root[cur];
            }
            return cur;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        UnionFind uf=new UnionFind(m*n);
        int[][] dirs=new int[][]{{-1,0}, {0,-1}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    uf.add(i*n+j);
                    for(int[] dir: dirs){
                        int x=i+dir[0], y=j+dir[1];
                        if(x>=0 && y>=0 && grid[x][y]==1){
                            uf.union(i*n+j, x*n+y);
                        }
                    }
                }
            }
        }
        return uf.max;
    }

//    // DFS
//    public int maxAreaOfIsland(int[][] grid) {
//        int m=grid.length, n=grid[0].length, result=0;
//        int[][] visited=new int[m][n];
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(grid[i][j]==1 && visited[i][j]==0){
//                    int[] area=new int[]{0};
//                    maoiHelper(i, j, grid, visited, area);
//                    result=Math.max(result, area[0]);
//                }
//            }
//        }
//        return result;
//    }
//
//    private void maoiHelper(int x, int y, int[][] grid, int[][] visited, int[] area){
//        int m=grid.length, n=grid[0].length;
//        int[][] dirs=new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        visited[x][y]=1;
//        area[0]++;
//        for(int[] dir: dirs){
//            int nx=x+dir[0], ny=y+dir[1];
//            if(nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny]==1 && visited[nx][ny]==0){
//                maoiHelper(nx, ny, grid, visited, area);
//            }
//        }
//    }

//    // BFS
//    public int maxAreaOfIsland(int[][] grid) {
//        int m=grid.length, n=grid[0].length, result=0;
//        int[][] visited=new int[m][n];
//        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
//        Queue<Integer> q=new LinkedList<>();
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(grid[i][j]==1 && visited[i][j]==0){
//                    q.offer(i*n+j);
//                    visited[i][j]=1;
//                    int area=0;
//                    while(!q.isEmpty()){
//                        int cur=q.poll();
//                        int x=cur/n, y=cur%n;
//                        area++;
//                        for(int[] dir: dirs){
//                            int nx=x+dir[0], ny=y+dir[1];
//                            if(nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny]==1 && visited[nx][ny]==0){
//                                visited[nx][ny]=1;
//                                q.offer(nx*n+ny);
//                            }
//                        }
//                    }
//                    result=Math.max(result, area);
//                }
//            }
//        }
//        return result;
//    }
}
