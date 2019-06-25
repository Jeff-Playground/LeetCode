package com.wen.SeventhFifty;

public class RangeSumQuery2DMutable {
    // Binary indexed tree
    public static class NumMatrix {
        int[][] matrix=null;
        int[][] biTree=null;

        public NumMatrix(int[][] matrix) {
            int m=matrix.length, n=matrix[0].length;
            this.matrix=new int[m][n];
            this.biTree=new int[m+1][n+1];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    update(i, j, matrix[i][j]);
                }
            }
        }

        public void update(int row, int col, int val) {
            int m=matrix.length, n=matrix[0].length;
            int diff=val-matrix[row][col];
            for(int i=row+1; i<m+1; i+=i&(-i)){
                for(int j=col+1; j<n+1; j+=j&(-j)){
                    biTree[i][j]+=diff;
                }
            }
            matrix[row][col]=val;
        }

        public int getSum(int row, int col){
            int result=0;
            for(int i=row+1; i>0; i-=i&(-i)){
                for(int j=col+1; j>0; j-=j&(-j)){
                    result+=biTree[i][j];
                }
            }
            return result;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if(row1==0 && col1==0){
                return getSum(row2, col2);
            } else if(row1==0){
                return getSum(row2, col2)-getSum(row2, col1-1);
            } else if(col1==0){
                return getSum(row2, col2)-getSum(row1-1, col2);
            } else{
                return getSum(row2, col2)-getSum(row2, col1-1)-getSum(row1-1, col2)+getSum(row1-1, col1-1);
            }
        }
    }
}
