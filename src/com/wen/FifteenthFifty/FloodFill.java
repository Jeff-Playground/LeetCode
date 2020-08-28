package com.wen.FifteenthFifty;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    // DFS
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int curColor=image[sr][sc];
        if(curColor==newColor){
            return image;
        } else{
            int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
            ffHelper(image, sr, sc, curColor, newColor, dirs);
            return image;
        }
    }

    private void ffHelper(int[][] image, int sr, int sc, int curColor, int newColor, int[][] dirs){
        int m=image.length, n=image[0].length;
        image[sr][sc]=newColor;
        for(int[] dir: dirs){
            int x=sr+dir[0], y=sc+dir[1];
            if(x>=0 && x<m && y>=0 && y<n && image[x][y]==curColor){
                ffHelper(image, x, y, curColor, newColor, dirs);
            }
        }
    }

//    // BFS
//    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        int curColor=image[sr][sc];
//        if(curColor==newColor){
//            return image;
//        } else{
//            int m=image.length, n=image[0].length;
//            Queue<Integer> q=new LinkedList<>();
//            int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//            q.offer(sr*n+sc);
//            image[sr][sc]=newColor;
//            while(!q.isEmpty()){
//                int cur=q.poll();
//                for(int[] dir: dirs){
//                    int x=cur/n+dir[0], y=cur%n+dir[1];
//                    if(x>=0 && x<m && y>=0 && y<n && image[x][y]==curColor){
//                        image[x][y]=newColor;
//                        q.offer(x*n+y);
//                    }
//                }
//            }
//            return image;
//        }
//    }
}
