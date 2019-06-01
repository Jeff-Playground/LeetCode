package com.wen.EleventhFifty;

import java.util.LinkedList;
import java.util.Queue;

public class Minesweeper {
    // BFS
    public char[][] updateBoard(char[][] board, int[] click) {
        int[][] dirs=new int[][]{{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(click);
        while(!queue.isEmpty()){
            int[] cell=queue.poll();
            int x=cell[0], y=cell[1];
            if(board[x][y]=='M'){
                board[x][y]='X';
                return board;
            } else {
                int mineCount=countMine(board, cell, dirs);
                if(mineCount>0){
                    // When mineCount is not 0, stop BFS
                    board[x][y]=(char)(mineCount+'0');
                } else{
                    board[x][y]='B';
                    for(int[] dir: dirs){
                        if(x+dir[0]>=0 && x+dir[0]<board.length && y+dir[1]>=0 && y+dir[1]<board[0].length && board[x+dir[0]][y+dir[1]]=='E'){
                            queue.offer(new int[]{x+dir[0], y+dir[1]});
                        }
                    }
                }
            }
        }
        return board;
    }

//    // DFS
//    public char[][] updateBoard(char[][] board, int[] click) {
//        int[][] dirs=new int[][]{{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
//        int x=click[0], y=click[1];
//        if(board[x][y]=='M'){
//            board[x][y]='X';
//        } else {
//            int mineCount=countMine(board, click, dirs);
//            if(mineCount>0){
//                // When mineCount is not 0, stop DFS
//                board[x][y]=(char)(mineCount+'0');
//            } else{
//                board[x][y]='B';
//                for(int[] dir: dirs){
//                    if(x+dir[0]>=0 && x+dir[0]<board.length && y+dir[1]>=0 && y+dir[1]<board[0].length && board[x+dir[0]][y+dir[1]]=='E'){
//                        updateBoard(board, new int[]{x+dir[0], y+dir[1]});
//                    }
//                }
//            }
//        }
//        return board;
//    }

    public int countMine(char[][] board, int[] click, int[][] dirs){
        int x=click[0], y=click[1];
        int count=0;
        for(int[] dir: dirs){
            if(x+dir[0]>=0 && x+dir[0]<board.length && y+dir[1]>=0 && y+dir[1]<board[0].length){
                if(board[x+dir[0]][y+dir[1]]=='M'){
                    count++;
                }
            }
        }
        return count;
    }
}
