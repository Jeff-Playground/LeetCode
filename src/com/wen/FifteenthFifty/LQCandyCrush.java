package com.wen.FifteenthFifty;

import java.util.HashSet;
import java.util.Set;

public class LQCandyCrush {
    public int[][] candyCrush(int[][] board) {
        boolean crushed=crush(board);
        while(crushed){
            fall(board);
            crushed=crush(board);
        }
        return board;
    }

    private void fall(int[][] board){
        int m=board.length, n=board[0].length;
        for(int j=0; j<n; j++){
            int t=-1;
            for(int i=m-1; i>=0; i--){
                if(board[i][j]==0){
                    if(t==-1){
                        t=i-1;
                    }
                    while(t>=0 && board[t][j]==0){
                        t--;
                    }
                    if(t<0){
                        break;
                    } else{
                        board[i][j]=board[t][j];
                        board[t][j]=0;
                    }
                }
            }
        }
    }

    private boolean crush(int[][] board){
        int m=board.length, n=board[0].length;
        Set<Integer> shouldCrush=new HashSet<>();
        for(int i=0; i<m; i++){
            int last=0, count=0;
            for(int j=0; j<=n; j++){
                if(j==n || board[i][j]==0 || board[i][j]!=last){
                    if(count>=3){
                        while(count>0){
                            shouldCrush.add(i*n+j-(count--));
                        }
                    }
                    if(j<n && board[i][j]!=0){
                        last=board[i][j];
                        count=1;
                    } else{
                        last=0;
                        count=0;
                    }
                } else{
                    count++;
                }
            }
        }
        for(int j=0; j<n; j++){
            int last=0, count=0;
            for(int i=0; i<=m; i++){
                if(i==m || board[i][j]==0 || board[i][j]!=last){
                    if(count>=3){
                        while(count>0){
                            shouldCrush.add((i-(count--))*n+j);
                        }
                    }
                    if(i<m && board[i][j]!=0){
                        last=board[i][j];
                        count=1;
                    } else{
                        last=0;
                        count=0;
                    }
                } else{
                    count++;
                }
            }
        }
        for(int cur: shouldCrush){
            int i=cur/n, j=cur%n;
            board[i][j]=0;
        }
        return shouldCrush.size()>0;
    }
}
