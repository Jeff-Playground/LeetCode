package com.wen.EleventhFifty;

/*
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or
right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the
destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded)
to the destination (included). If the ball cannot stop at the destination, return -1.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders
of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

Example 1
Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: 12
Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
             The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.


Example 2

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: -1
Explanation: There is no way for the ball to stop at the destination.


Note:

There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border
of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 */

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
