package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensII {
    public int totalNQueens(int n) {
        int[] result=new int[1];
        int[] columnPosition=new int[n];
        Arrays.fill(columnPosition, -1);
        solveNQueensDFS(columnPosition, 0, result);
        return result[0];
    }

    private void solveNQueensDFS(int[] columnPosition, int row, int[] result) {
        int n=columnPosition.length;
        if(row==n){
            result[0]++;
        } else{
            for(int i=0; i<n; i++){
                if(validMove(columnPosition, row, i)){
                    columnPosition[row]=i;
                    solveNQueensDFS(columnPosition, row+1, result);
                    columnPosition[row]=-1;
                }
            }
        }
    }

    private boolean validMove(int[] columnPosition, int row, int column) {
        for(int i=0; i<row; i++){
            if(columnPosition[i]==column || Math.abs(columnPosition[i]-column)==Math.abs(i-row)){
                return false;
            }
        }
        return true;
    }
}
