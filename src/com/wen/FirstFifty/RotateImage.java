package com.wen.FirstFifty;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        for(int i=0; i<size/2; i++){
            for(int j=i; j<size-1-i; j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[size-1-j][i];
                matrix[size-1-j][i]=matrix[size-1-i][size-1-j];
                matrix[size-1-i][size-1-j]=matrix[j][size-1-i];
                matrix[i][j]=temp;
            }
        }
    }

//    // First transpose the array, then swap the elements in each row
//    public void rotate(int[][] matrix) {
//        int size=matrix.length;
//        for(int i=0; i<size; i++){
//            for(int j=i+1; j<size; j++){
//                int temp=matrix[i][j];
//                matrix[i][j]=matrix[j][i];
//                matrix[j][i]=temp;
//            }
//        }
//        for(int i=0; i<size; i++){
//            for(int j=0; j<size/2; j++){
//                int temp=matrix[i][j];
//                matrix[i][j]=matrix[i][size-1-j];
//                matrix[i][size-1-j]=temp;
//            }
//        }
//    }
}
