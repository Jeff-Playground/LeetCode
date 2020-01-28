package com.wen.TenthFifty;

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
