package com.wen.FirstFifty;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    // Using hashset and loop 3 times
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<Character>();
        // Check for each row
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
            set.clear();
        }

        // Check for each column
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
            set.clear();
        }

        // Check for each sub-grid
        for (int k = 0; k < 9; k++) {
            for (int i = k/3*3; i < k/3*3+3; i++) {
                for (int j = (k%3)*3; j < (k%3)*3+3; j++) {
                    if (board[i][j] == '.')
                        continue;
                    if (set.contains(board[i][j]))
                        return false;
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }

        return true;
    }

//    // Loop once
//    public boolean isValidSudoku(char[][] board) {
//        if(board==null || board.length!=9 || board[0].length!=9){
//            return false;
//        }
//        int rowSize=9, columnSize=9;
//        boolean[][] rowFlag=new boolean[rowSize][columnSize];
//        boolean[][] columnFlag=new boolean[rowSize][columnSize];
//        boolean[][] cellFlag=new boolean[rowSize][columnSize];
//        for(int i=0; i<rowSize; i++){
//            for(int j=0; j<columnSize; j++){
//                if(board[i][j]>='1' && board[i][j]<='9'){
//                    int c=board[i][j]-'1';
//                    if(rowFlag[i][c] || columnFlag[c][j] || cellFlag[3*(i/3)+j/3][c]){
//                        return false;
//                    }
//                    rowFlag[i][c]=true;
//                    columnFlag[c][j]=true;
//                    cellFlag[3*(i/3)+j/3][c]=true;
//                }
//            }
//        }
//        return true;
//    }
}
