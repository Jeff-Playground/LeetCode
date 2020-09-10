package com.wen.TenthFifty;

/*
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up (u), down (d),
left (l) or right (r), but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next
direction. There is also a hole in this maze. The ball will drop into the hole if it rolls on to the hole.

Given the ball position, the hole position and the maze, find out how the ball could drop into the hole by moving the
shortest distance. The distance is defined by the number of empty spaces traveled by the ball from the start position
(excluded) to the hole (included). Output the moving directions by using 'u', 'd', 'l' and 'r'. Since there could be
several different shortest ways, you should output the lexicographically smallest way. If the ball cannot reach the hole,
output "impossible".

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the
borders of the maze are all walls. The ball and the hole coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0

Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (0, 1)

Output: "lul"
Explanation: There are two shortest ways for the ball to drop into the hole.
The first way is left -> up -> left, represented by "lul".
The second way is up -> left, represented by 'ul'.
Both ways have shortest distance 6, but the first way is lexicographically smaller because 'l' < 'u'. So the output is "lul".




Example 2

Input 1: a maze represented by a 2D array

0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0

Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (3, 0)
Output: "impossible"
Explanation: The ball cannot reach the hole.




Note:
There is only one ball and one hole in the maze.
Both the ball and hole exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border
of the maze are all walls.
The maze contains at least 2 empty spaces, and the width and the height of the maze won't exceed 30.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LQTheMazeIII {
    // BFS
    public static String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m=maze.length, n=maze[0].length;
        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        String[] dirsMove=new String[]{"u", "d", "l", "r"};
        // min has value in format "stepCount-stepMove", it's also acting as visited in this case
        String[] min=new String[m*n];
        min[ball[0]*n+ball[1]]=0+"-"+"";
        Queue<int[]> q=new LinkedList<>();
        q.offer(ball);
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int i=0; i<dirs.length; i++){
                int[] dir=dirs[i];
                int x=cur[0], y=cur[1];
                int step=Integer.parseInt(min[x*n+y].substring(0, min[x*n+y].indexOf("-")));
                String curMove=min[x*n+y].substring(min[x*n+y].indexOf("-")+1);
                int curStep=step;
                while(x+dir[0]>=0 && x+dir[0]<m && y+dir[1]>=0 && y+dir[1]<n && maze[x+dir[0]][y+dir[1]]!=1){
                    if(x==hole[0] && y==hole[1]){
                        break;
                    }
                    x+=dir[0];
                    y+=dir[1];
                    curStep++;
                }
                // curStep>step means the ball has moved at least 1 distance
                if(curStep>step){
                    curMove+=dirsMove[i];
                    int minStep=min[x*n+y]==null?Integer.MAX_VALUE:Integer.parseInt(min[x*n+y].substring(0,min[x*n+y].indexOf("-")));
                    String minPath=min[x*n+y]==null?"Z":min[x*n+y].substring(min[x*n+y].indexOf("-")+1);
                    if(minStep>curStep || (minStep==curStep && minPath.compareTo(curMove)>0)){
                        min[x*n+y]=curStep+"-"+curMove;
                        if(x!=hole[0] || y!=hole[1]){
                            if(minStep>curStep){
                                q.offer(new int[]{x, y});
                            }
                        }
                    }
                    curMove=curMove.substring(0, curMove.length()-1);
                }
            }
        }
        return min[hole[0]*n+hole[1]]==null?"impossible":min[hole[0]*n+hole[1]].substring(min[hole[0]*n+hole[1]].indexOf("-")+1);
    }

//    // DFS
//    public static String findShortestWay(int[][] maze, int[] ball, int[] hole) {
//        int m=maze.length, n=maze[0].length;
//        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
//        String[] dirsMove=new String[]{"u", "d", "l", "r"};
//        String[] min=new String[m*n];
//        min[ball[0]*n+ball[1]]=0+"-"+"Z";
//        shortestDistance(maze, dirs, dirsMove, min, ball, hole, 0, "");
//        return min[hole[0]*n+hole[1]]==null?"impossible":min[hole[0]*n+hole[1]].substring(min[hole[0]*n+hole[1]].indexOf("-")+1);
//    }
//
//    public static void shortestDistance(int[][] maze, int[][] dirs, String[] dirsMove, String[] min, int[] cur, int[] hole, int step, String curMove){
//        int m=maze.length, n=maze[0].length;
//        for(int i=0; i<dirs.length; i++){
//            int[] dir=dirs[i];
//            int x=cur[0], y=cur[1], curStep=step;
//            while(x+dir[0]>=0 && x+dir[0]<m && y+dir[1]>=0 && y+dir[1]<n && maze[x+dir[0]][y+dir[1]]!=1){
//                if(x==hole[0] && y==hole[1]){
//                    break;
//                }
//                x+=dir[0];
//                y+=dir[1];
//                curStep++;
//            }
//            if(curStep>step){
//                curMove+=dirsMove[i];
//                int minStep=min[x*n+y]==null?Integer.MAX_VALUE:Integer.parseInt(min[x*n+y].substring(0,min[x*n+y].indexOf("-")));
//                String minPath=min[x*n+y]==null?"Z":min[x*n+y].substring(min[x*n+y].indexOf("-")+1);
//                if(minStep>curStep || (minStep==curStep && minPath.compareTo(curMove)>0)){
//                    min[x*n+y]=curStep+"-"+curMove;
//                    if(x!=hole[0] || y!=hole[1]){
//                        if(minStep>curStep){
//                            shortestDistance(maze, dirs, dirsMove, min, new int[]{x, y}, hole, curStep, curMove);
//                        }
//                    }
//                }
//                curMove=curMove.substring(0, curMove.length()-1);
//            }
//        }
//    }
}
