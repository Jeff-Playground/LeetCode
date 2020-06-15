package com.wen.SeventhFifty;

import java.util.*;

public class LQShortestDistanceFromAllBuildings {
    // BFS, note grid is updated to act as visited, and each time the updates can ensure that the next iteration will
    // check for points reached on the last round
    public static int shortestDistance(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        List<List<Integer>> buildings=new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    buildings.add(Arrays.asList(i, j));
                }
            }
        }
        int count=buildings.size(), target=0, result=Integer.MAX_VALUE;
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int[][] dist=new int[m][n];
        for(int i=0; i<buildings.size(); i++){
            Queue<List<Integer>> q=new LinkedList<>();
            q.offer(buildings.get(i));
            int curDist=0;
            while(!q.isEmpty()){
                int size=q.size();
                for(int j=0; j<size; j++){
                    List<Integer> cur=q.poll();
                    int x=cur.get(0), y=cur.get(1);
                    for(int[] dir: dirs){
                        int newX=x+dir[0], newY=y+dir[1];
                        if(newX>=0 && newX<m && newY>=0 && newY<n && grid[newX][newY]==target){
                            grid[newX][newY]--;
                            dist[newX][newY]+=curDist+1;
                            q.offer(Arrays.asList(newX, newY));
                            if(count==(-target+1)){
                                result=Math.min(result, dist[newX][newY]);
                            }
                        }
                    }
                }
                curDist++;
            }
            target--;
        }
        return result;
    }
}
