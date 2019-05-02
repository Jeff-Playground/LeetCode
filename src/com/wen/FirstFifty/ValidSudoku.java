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
//        int rowSize=9, columnSize=9, cellSize=9, numberCount=9;
//        boolean[][] validRow=new boolean[rowSize][numberCount];
//        boolean[][] validColumn=new boolean[columnSize][numberCount];
//        boolean[][] validCell=new boolean[cellSize][numberCount];
//        for(int i=0; i<rowSize; i++){
//            for(int j=0; j<columnSize; j++){
//                if(board[i][j]>='1' && board[i][j]<='9'){
//                    int num=board[i][j]-'1';
//                    if(validRow[i][num] || validColumn[j][num] || validCell[i/3*3+j/3][num]){
//                        return false;
//                    }
//                    validRow[i][num]=true;
//                    validColumn[j][num]=true;
//                    validCell[i/3*3+j/3][num]=true;
//                }
//            }
//        }
//        return true;
//    }
}
