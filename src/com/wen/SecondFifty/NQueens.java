package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<List<String>>();
        int[] columnPosition=new int[n];
        Arrays.fill(columnPosition, -1);
        solveNQueensDFS(columnPosition, 0, result);
        return result;
    }

    private void solveNQueensDFS(int[] columnPosition, int row, List<List<String>> result) {
        int n=columnPosition.length;
        if(row==n){
            List<String> solution=new ArrayList<String>();
            for(int i=0; i<n; i++){
                char[] temp=new char[n];
                Arrays.fill(temp, '.');
                temp[columnPosition[i]]='Q';
                String tempStr=new String(temp);
                solution.add(tempStr);
            }
            result.add(solution);
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
