package com.wen.SixthFifty;

public class GameOfLife {
    // 0: dead  1: live
    // 2: dead to dead      3: dead to live     4: live to dead     5: live to live
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0 || board[0].length==0){
            return;
        }
        int m=board.length, n=board[0].length;
        int[][] dirs=new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int live=0;
                for(int[] dir: dirs){
                    int x=i+dir[0], y=j+dir[1];
                    if(x>=0 && x<m && y>=0 && y<n){
                        if(board[x][y]==1 || board[x][y]==4 || board[x][y]==5){
                            live++;
                        }
                    }
                }
                if(board[i][j]==0){
                    if(live==3){
                        board[i][j]=3;
                    } else{
                        board[i][j]=2;
                    }
                } else{
                    if(live<2){
                        board[i][j]=4;
                    } else if(live==2 || live==3){
                        board[i][j]=5;
                    } else{
                        board[i][j]=4;
                    }
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==2 || board[i][j]==4){
                    board[i][j]=0;
                } else{
                    board[i][j]=1;
                }
            }
        }
    }
}
