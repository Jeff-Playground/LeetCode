package com.wen.SeventeenthFifty;

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {
    // Union find, also solvable by DFS and BFS(start with each 0, make it 1 and get the island size)
    public int largestIsland(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            throw new IllegalArgumentException("Invalid input!");
        }
        int m=grid.length, n=grid[0].length;
        int[][] group=new int[m][n], count=new int[m][n];
        int islandCount=0, max=Integer.MIN_VALUE;
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    int[] total=new int[]{0};
                    findIsland(grid, i, j, i*n+j, dirs, total, group);
                    count[i][j]=total[0];
                    islandCount++;
                    max=Math.max(max, total[0]);
                }
            }
        }
        if(islandCount==0){
            return 1;
        } else if(islandCount==1){
            return max<m*n?max+1:max;
        } else{
            int result=Integer.MIN_VALUE;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    Set<Integer> roots=new HashSet<>();
                    for(int[] dir: dirs){
                        int x=i+dir[0], y=j+dir[1];
                        if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==-1){
                            int root=findRoot(group, x, y);
                            roots.add(root);
                        }
                        if(roots.size()==0){
                            continue;
                        } else{
                            int cur=0;
                            for(int r: roots){
                                cur+=count[r/n][r%n];
                            }
                            result=Math.max(result, cur+1);
                        }
                    }
                }
            }
            return result;
        }
    }

    private int findRoot(int[][] group, int x, int y){
        int n=group[0].length;
        while(group[x][y]!=x*n+y){
            int r=group[x][y];
            x=r/n;
            y=r%n;
        }
        return group[x][y];
    }

    private void findIsland(int[][] grid, int i, int j, int root, int[][] dirs, int[] total, int[][] group){
        int m=grid.length, n=grid[0].length;
        grid[i][j]=-1;
        group[i][j]=root;
        total[0]++;
        for(int[] dir: dirs){
            int x=i+dir[0], y=j+dir[1];
            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                findIsland(grid, x, y, root, dirs, total, group);
            }
        }
    }
}
