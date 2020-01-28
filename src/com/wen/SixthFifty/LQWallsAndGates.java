package com.wen.SixthFifty;

import java.util.LinkedList;
import java.util.Queue;

public class LQWallsAndGates {
    // BFS
    public static void wallsAndGates(int[][] rooms) {
        if(rooms==null || rooms.length==0 || rooms[0].length==0){
            return;
        }
        int m=rooms.length, n=rooms[0].length;
        Queue<Integer> queue=new LinkedList<>();
        int[][] dirs=new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j]==0){
                    for(int[] dir: dirs){
                        if(i+dir[0]>=0 && i+dir[0]<m && j+dir[1]>=0 && j+dir[1]<n && rooms[i+dir[0]][j+dir[1]]>0) {
                            queue.offer((i + dir[0]) * n + j + dir[1]);
                        }
                    }
                    int dist=1;
                    while(!queue.isEmpty()){
                        int size=queue.size();
                        for(int k=0; k<size; k++){
                            int cur=queue.poll();
                            int x=cur/n, y=cur%n;
                            if(rooms[x][y]>dist){
                                rooms[x][y]=dist;
                                for(int[] dir: dirs){
                                    int newX=x+dir[0], newY=y+dir[1];
                                    if(newX>=0 && newX<m && newY>=0 && newY<n && rooms[newX][newY]>0) {
                                        queue.offer(newX * n + newY);
                                    }
                                }
                            }
                        }
                        dist++;
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
