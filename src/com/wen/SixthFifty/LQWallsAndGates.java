package com.wen.SixthFifty;

/*

You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 2^(31-1)=2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.

Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example:

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4

 */

import java.util.LinkedList;
import java.util.Queue;

public class LQWallsAndGates {
    // BFS
    public void wallsAndGates(int[][] rooms) {
        if(rooms==null || rooms.length==0 || rooms[0].length==0){
            return;
        }
        int m=rooms.length, n=rooms[0].length;
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j]==0){
                    q.offer(i*n+j);
                }
            }
        }
        int dist=0;
        while(!q.isEmpty()){
            int size=q.size();
            dist++;
            while(size-->0){
                int cur=q.poll();
                int cx=cur/n, cy=cur%n;
                for(int[] dir: dirs){
                    int x=cx+dir[0], y=cy+dir[1];
                    if(x>=0 && x<m && y>=0 && y<n && rooms[x][y]==Integer.MAX_VALUE){
                        rooms[x][y]=dist;
                        q.offer(x*n+y);
                    }
                }
            }
        }
    }

//    // DFS
//    public static void wallsAndGates(int[][] rooms) {
//        if(rooms==null || rooms.length==0 || rooms[0].length==0){
//            return;
//        }
//        int m=rooms.length, n=rooms[0].length;
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(rooms[i][j]==0){
//                    int[][] dirs=new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
//                    for(int[] dir: dirs){
//                        wallsAndGatesDFS(rooms, i+dir[0], j+dir[1], 1);
//                    }
//                }
//            }
//        }
//    }
//
//    public static void wallsAndGatesDFS(int[][] rooms, int x, int y, int dist) {
//        int m=rooms.length, n=rooms[0].length;
//        if(x>=0 && x<m && y>=0 && y<n && rooms[x][y]>dist){
//            rooms[x][y]=dist;
//            int[][] dirs=new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
//            for(int[] dir: dirs){
//                wallsAndGatesDFS(rooms, x+dir[0], y+dir[1], dist+1);
//            }
//        }
//    }
}
