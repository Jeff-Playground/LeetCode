package com.wen.SecondFifty;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int row=-1;
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0]==target){
                return true;
            } else if(matrix[i][0]<target){
                row=i;
            } else{
                break;
            }
        }
        if(row<0){
            return false;
        } else{
            for(int j=1; j<matrix[row].length; j++){
                if(matrix[row][j]==target){
                    return true;
                } else if(matrix[row][j]>target){
                    return false;
                }
            }
            return false;
        }
    }
}
