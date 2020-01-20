package com.wen.ThirdFifty;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
//    // BFS
//    public static void solve(char[][] board) {
//        if(board.length==0 || board[0].length==0){
//            return;
//        }
//        int m=board.length, n=board[0].length;
//        int[][] dirs=new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(i!=0 && i!=m-1 && j!=0 && j!=n-1){
//                    continue;
//                }
//                if(board[i][j]!='O'){
//                    continue;
//                }
//                board[i][j]='$';
//                Queue<Integer> queue=new LinkedList<>();
//                queue.offer(i*n+j);
//                while(!queue.isEmpty()){
//                    int temp=queue.poll(), x=temp/n, y=temp%n;
//                    for(int[] dir: dirs){
//                        int newX=x+dir[0], newY=y+dir[1];
//                        if(newX>=0 && newX<m && newY>=0 && newY<n && board[newX][newY]=='O'){
//                            board[newX][newY]='$';
//                            queue.offer(newX*n+newY);
//                        }
//                    }
//                }
//            }
//        }
//        for(int i=0; i<m; i++) {
//            for (int j=0; j<n; j++) {
//                if(board[i][j]=='O'){
//                    board[i][j]='X';
//                }
//                if(board[i][j]=='$'){
//                    board[i][j]='O';
//                }
//            }
//        }
//    }

    // DFS
    public static void solve(char[][] board) {
        if(board.length==0 || board[0].length==0){
            return;
        }
        int m=board.length, n=board[0].length;
        int[][] dirs=new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if((i==0 || i==m-1 || j==0 || j==n-1) && board[i][j]=='O'){
                    solveDFS(board, i, j, dirs);
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

    private static void solveDFS(char[][] board, int i, int j, int[][] dirs) {
        int m=board.length, n=board[0].length;
        if(board[i][j]=='O'){
            board[i][j]='$';
            for(int[] dir: dirs){
                int newX=i+dir[0], newY=j+dir[1];
                if(newX>=0 && newX<m && newY>=0 && newY<n && board[newX][newY]=='O'){
                    solveDFS(board, newX, newY, dirs);
                }
            }
        }
    }
}
