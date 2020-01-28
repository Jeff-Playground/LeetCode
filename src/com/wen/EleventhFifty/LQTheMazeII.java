package com.wen.EleventhFifty;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LQTheMazeII {
//    // Dijkstra BFS
//    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
//        if(start[0]==destination[0] && start[1]==destination[1]){
//            return 0;
//        }
//        int result=Integer.MAX_VALUE;
//        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
//        int m=maze.length, n=maze[0].length;
//        int[][] min=new int[m][n];
//        for(int i=0; i<m; i++){
//            Arrays.fill(min[i], Integer.MAX_VALUE);
//        }
//        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->(a[2]-b[2]));
//        pq.offer(new int[]{start[0],start[1],0});
//        min[start[0]][start[1]]=0;
//        while(!pq.isEmpty()){
//            int[] cur=pq.poll();
//            for(int[] dir: dirs){
//                int x=cur[0], y=cur[1], step=cur[2];
//                while(x+dir[0]>=0 && x+dir[0]<m && y+dir[1]>=0 && y+dir[1]<n && maze[x+dir[0]][y+dir[1]]!=1){
//                    x+=dir[0];
//                    y+=dir[1];
//                    step++;
//                }
//                if(x==destination[0] && y==destination[1]){
//                    result=Math.min(result, step);
//                } else if(min[x][y]>step){
//                    min[x][y]=step;
//                    pq.offer(new int[]{x, y, step});
//                }
//            }
//        }
//        return result==Integer.MAX_VALUE?-1:result;
//    }

//    // DFS, note introduced array min[][] to avoid wrong pruning during the process
//    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
//        int[] result=new int[]{Integer.MAX_VALUE};
//        int m=maze.length, n=maze[0].length;
//        int[][] min=new int[m][n];
//        for(int i=0; i<m; i++){
//            Arrays.fill(min[i], Integer.MAX_VALUE);
//        }
//        min[start[0]][start[1]]=0;
//        shortestDistance(maze, min, start, destination, 0, result);
//        return result[0]==Integer.MAX_VALUE?-1:result[0];
//    }
//
//    public void shortestDistance(int[][] maze, int[][] min, int[] cur, int[] destination, int step, int[] result){
//        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
//        int m=maze.length, n=maze[0].length;
//        for(int[] dir: dirs){
//            int x=cur[0], y=cur[1], curStep=step;
//            while(x+dir[0]>=0 && x+dir[0]<m && y+dir[1]>=0 && y+dir[1]<n && maze[x+dir[0]][y+dir[1]]!=1){
//                x+=dir[0];
//                y+=dir[1];
//                curStep++;
//            }
//            if(x==destination[0] && y==destination[1]){
//                result[0]=Math.min(result[0], curStep);
//            } else if(min[x][y]>curStep){
//                 min[x][y]=curStep;
//                 shortestDistance(maze, min, new int[]{x, y}, destination, curStep, result);
//            }
//        }
//    }

    // BFS, note introduced array min[][] to avoid wrong pruning during the process. In this case, it's very similar to
    // Dijkstra because node can only keep travelling in one direction. Normally, Dijkstra works better with weighted
    // graph. Note Dijkstra is using a PriorityQueue while here it only used a Queue
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(start[0]==destination[0] && start[1]==destination[1]){
            return 0;
        }
        int result=Integer.MAX_VALUE;
        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m=maze.length, n=maze[0].length;
        int[][] min=new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{start[0],start[1],0});
        min[start[0]][start[1]]=0;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] dir: dirs){
                int x=cur[0], y=cur[1], step=cur[2];
                while(x+dir[0]>=0 && x+dir[0]<m && y+dir[1]>=0 && y+dir[1]<n && maze[x+dir[0]][y+dir[1]]!=1){
                    x+=dir[0];
                    y+=dir[1];
                    step++;
                }
                if(x==destination[0] && y==destination[1]){
                    result=Math.min(result, step);
                } else if(min[x][y]>step){
                    min[x][y]=step;
                    q.offer(new int[]{x, y, step});
                }
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}
