package com.wen.FirstFifty;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){
                    for(int k=1; k<=9; k++){
                        board[i][j] = (char) (k+'0');
                        if(isValid(board, i, j) && solve(board)){
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int i, int j){
        Set<Character> set = new HashSet<>();
        for(int k=0; k<9; k++){
            if(set.contains(board[i][k])){
                return false;
            }
            if(board[i][k]!='.' ){
                set.add(board[i][k]);
            }
        }
        set.clear();

        for(int k=0; k<9; k++){
            if(set.contains(board[k][j])){
                return false;
            }
            if(board[k][j]!='.' ){
                set.add(board[k][j]);
            }
        }
        set.clear();

        int row=i/3*3, col=j/3*3;
        for(int m=0; m<3; m++){
            for(int n=0; n<3; n++){
                int x=row+m;
                int y=col+n;
                if(set.contains(board[x][y])){
                    return false;
                }
                if(board[x][y]!='.'){
                    set.add(board[x][y]);
                }
            }
        }
        return true;
    }
}
