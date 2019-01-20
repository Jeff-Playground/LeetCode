package com.wen.SecondFifty;

public class SpiralMatrixII {
    // Using circle count
    public int[][] generateMatrix(int n) {
        int[][] result=new int[n][n];
        int m=1, p=n;
        for(int r=0; r<n/2; r++, p-=2) {
            for(int col=r; col<r+p; col++) {
                result[r][col]=m++;
            }
            for(int row=r+1; row<r+p; row++) {
                result[row][r+p-1]=m++;
            }
            for(int col=r+p-2; col>=r; col--) {
                result[r+p-1][col]=m++;
            }
            for(int row=r+p-2; row>r; row--) {
                result[row][r]=m++;
            }
        }
        if(n%2!=0) {
            result[n/2][n/2]=m;
        }
        return result;
    }

//    // Normal way
//    public int[][] generateMatrix(int n) {
//        int[][] result=new int[n][n];
//        int firstRow=0, firstColumn=0;
//        int lastRow=n-1, lastColumn=n-1;
//        int m=1;
//        while(firstRow<=lastRow && firstColumn<=lastColumn) {
//            int i=firstRow, j=firstColumn;
//            for(j=firstColumn; j<=lastColumn; j++) {
//                result[i][j]=m++;
//            }
//            j--;
//            firstRow++;
//            if(firstRow>lastRow) {
//                break;
//            }
//            for(i=firstRow; i<=lastRow; i++) {
//                result[i][j]=m++;
//            }
//            i--;
//            lastColumn--;
//            if(firstColumn>lastColumn) {
//                break;
//            }
//            for(j=lastColumn; j>=firstColumn; j--) {
//                result[i][j]=m++;
//            }
//            j++;
//            lastRow--;
//            if(firstRow>lastRow) {
//                break;
//            }
//            for(i=lastRow; i>=firstRow; i--) {
//                result[i][j]=m++;
//            }
//            i++;
//            firstColumn++;
//            if(firstColumn>lastColumn) {
//                break;
//            }
//        }
//        return result;
//    }
}
