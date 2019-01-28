package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<List<String>>();
        int[] columnPosition=new int[n];
        Arrays.fill(columnPosition, -1);
        int upperLimit=(1<<n)-1;
        helper(upperLimit,0, 0, 0, columnPosition, 0, result);
        return result;
    }

    private static void helper(int upperLimit, int rowLimit, int leftDiagonalLimit, int rightDiagnalLimit, int[] columnPosition, int row, List<List<String>> result) {
        if(rowLimit!=upperLimit){
            int availablePos=upperLimit & (~(rowLimit | leftDiagonalLimit | rightDiagnalLimit));
            while(availablePos>0){
                int pos=availablePos & (~availablePos + 1); // This will make only the first non-zero digit from right to be 1
                availablePos-=pos; // Get rid of current position from available positions
                int index=posToIndex(pos);
                columnPosition[row]=index;
                helper(upperLimit,rowLimit | pos, (leftDiagonalLimit | pos) << 1, (rightDiagnalLimit | pos) >>1, columnPosition, row+1, result);
                columnPosition[row]=-1;
            }
        } else{
            int n=columnPosition.length;
            List<String> solution=new ArrayList<>();
            for(int i=0; i<n; i++){
                char[] temp=new char[n];
                Arrays.fill(temp, '.');
                temp[columnPosition[i]]='Q';
                String tempStr=new String(temp);
                solution.add(tempStr);
            }
            result.add(solution);
        }
    }

    private static int posToIndex(int pos) {
        int index=0;
        while((pos & 1)==0){
            pos>>=1;
            index++;
        }
        return index;
    }

//    // Iterative
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> result=new ArrayList<List<String>>();
//        int[] columnPosition=new int[n];
//        Arrays.fill(columnPosition, -1);
//        for(int row=0; ;){
//            int col=-1;
//            for(col=columnPosition[row]+1; col<n; col++){
//                if(validMove(columnPosition, row, col)){
//                    columnPosition[row]=col;
//                    if(row==n-1){
//                        List<String> solution=new ArrayList<>();
//                        for(int i=0; i<n; i++){
//                            char[] temp=new char[n];
//                            Arrays.fill(temp, '.');
//                            temp[columnPosition[i]]='Q';
//                            String tempStr=new String(temp);
//                            solution.add(tempStr);
//                        }
//                        result.add(solution);
//                    } else{
//                        row++;
//                        break;
//                    }
//                }
//            }
//            if(col==n){
//                if(row==0){
//                    break;  // This is when been keeping doing row-- from below and things didn't work out
//                } else{
//                    columnPosition[row]=-1;
//                    row--;
//                }
//            }
//        }
//        return result;
//    }
//
//    private boolean validMove(int[] columnPosition, int row, int column) {
//        for(int i=0; i<row; i++){
//            if(columnPosition[i]==column || Math.abs(columnPosition[i]-column)==Math.abs(i-row)){
//                return false;
//            }
//        }
//        return true;
//    }

//    // Resursive
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> result=new ArrayList<List<String>>();
//        int[] columnPosition=new int[n];
//        Arrays.fill(columnPosition, -1);
//        solveNQueensDFS(columnPosition, 0, result);
//        return result;
//    }
//
//    private void solveNQueensDFS(int[] columnPosition, int row, List<List<String>> result) {
//        int n=columnPosition.length;
//        if(row==n){
//            List<String> solution=new ArrayList<String>();
//            for(int i=0; i<n; i++){
//                char[] temp=new char[n];
//                Arrays.fill(temp, '.');
//                temp[columnPosition[i]]='Q';
//                String tempStr=new String(temp);
//                solution.add(tempStr);
//            }
//            result.add(solution);
//        } else{
//            for(int i=0; i<n; i++){
//                if(validMove(columnPosition, row, i)){
//                    columnPosition[row]=i;
//                    solveNQueensDFS(columnPosition, row+1, result);
//                    columnPosition[row]=-1;
//                }
//            }
//        }
//    }
//
//    private boolean validMove(int[] columnPosition, int row, int column) {
//        for(int i=0; i<row; i++){
//            if(columnPosition[i]==column || Math.abs(columnPosition[i]-column)==Math.abs(i-row)){
//                return false;
//            }
//        }
//        return true;
//    }
}
