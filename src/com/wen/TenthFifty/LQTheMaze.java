package com.wen.TenthFifty;

import java.util.LinkedList;
import java.util.Queue;

public class LQTheMaze {
    // BFS
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(start[0]==destination[0] && start[1]==destination[1]){
            return true;
        }
        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m=maze.length, n=maze[0].length;
        Queue<int[]> q=new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] dir: dirs){
                int x=cur[0], y=cur[1];
                while(x+dir[0]>=0 && x+dir[0]<m && y+dir[1]>=0 && y+dir[1]<n && maze[x+dir[0]][y+dir[1]]!=1){
                    x+=dir[0];
                    y+=dir[1];
                }
                if(x==destination[0] && y==destination[1]){
                    return true;
                }
                if(maze[x][y]==0){
                    maze[x][y]=2;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return false;
    }

//    // DFS
//    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
//        if(start[0]==destination[0] && start[1]==destination[1]){
//            return true;
//        }
//        boolean result=false;
//        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
//        int m=maze.length, n=maze[0].length;
//        for(int[] dir: dirs){
//            int x=start[0], y=start[1];
//            while(x+dir[0]>=0 && x+dir[0]<m && y+dir[1]>=0 && y+dir[1]<n && maze[x+dir[0]][y+dir[1]]!=1){
//                x+=dir[0];
//                y+=dir[1];
//            }
//            if(maze[x][y]==0){
//                maze[x][y]=2;
//                result|=hasPath(maze, new int[]{x,y}, destination);
//                if(result){
//                    return result;
//                }
//            }
//        }
//        return result;
//    }
}
