package com.wen.ThirdFifty;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    // BFS
    public static void solve(char[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(i!=0 && i!=board.length-1 && j!=0 && j!=board[0].length-1){
                    continue;
                }
                if(board[i][j]!='O'){
                    continue;
                }
                board[i][j]='$';
                Queue<Integer> queue=new LinkedList<>();
                queue.offer(i*board[0].length+j);
                while(!queue.isEmpty()){
                    int temp=queue.poll(), x=temp/board[0].length, y=temp%board[0].length;
                    if(x>0 && board[x-1][y]=='O'){
                        board[x-1][y]='$';
                        queue.offer(temp-board[0].length);
                    }
                    if(x<board.length-1 && board[x+1][y]=='O'){
                        board[x+1][y]='$';
                        queue.offer(temp+board[0].length);
                    }
                    if(y>0 && board[x][y-1]=='O'){
                        board[x][y-1]='$';
                        queue.offer(temp-1);
                    }
                    if(y<board[0].length-1 && board[x][y+1]=='O'){
                        board[x][y+1]='$';
                        queue.offer(temp+1);
                    }
                }
            }
        }
        for(int i=0; i<board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='$'){
                    board[i][j]='O';
                }
            }
        }
    }

//    // DFS
//    public static void solve(char[][] board) {
//        for(int i=0; i<board.length; i++){
//            for(int j=0; j<board[0].length; j++){
//                if((i==0 || i==board.length-1 || j==0 || j==board[0].length-1) && board[i][j]=='O'){
//                    solveDFS(board, i, j);
//                }
//            }
//        }
//        for(int i=0; i<board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if(board[i][j]=='O'){
//                    board[i][j]='X';
//                }
//                if(board[i][j]=='$'){
//                    board[i][j]='O';
//                }
//            }
//        }
//    }
//
//    private static void solveDFS(char[][] board, int i, int j) {
//        if(board[i][j]=='O'){
//            board[i][j]='$';
//            if(i>0 && board[i-1][j]=='O'){
//                solveDFS(board, i-1, j);
//            }
//            if(i<board.length-1 && board[i+1][j]=='O'){
//                solveDFS(board, i+1, j);
//            }
//            if(j>0 && board[i][j-1]=='O'){
//                solveDFS(board, i, j-1);
//            }
//            if(j<board[0].length-1 && board[i][j+1]=='O'){
//                solveDFS(board, i, j+1);
//            }
//        }
//    }
}
