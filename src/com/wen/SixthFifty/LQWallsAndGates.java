package com.wen.SixthFifty;

import java.util.LinkedList;
import java.util.Queue;

public class LQWallsAndGates {
    // BFS, note no visited needed
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
                        if(i+dir[0]>=0 && i+dir[0]<m && j+dir[1]>=0 && j+dir[1]<n) {
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
                                    if(x+dir[0]>=0 && x+dir[0]<m && y+dir[1]>=0 && y+dir[1]<n) {
                                        queue.offer((x + dir[0]) * n + y + dir[1]);
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

//    // DFS, note no visited needed
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
