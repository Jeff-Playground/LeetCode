package com.wen.SecondFifty;

public class SearchA2DMatrix {
    // Search in order
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

//    // Single binary search
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if(matrix==null || matrix.length==0 || matrix[0].length==0){
//            return false;
//        }
//        int m=matrix.length, n=matrix[0].length;
//        if(target<matrix[0][0] || target>matrix[m-1][n-1]){
//            return false;
//        }
//        int left=0, right=(m-1)*n+n-1;
//        while(left<=right){
//            int mid=left+(right-left)/2;
//            int x=mid/n, y=mid%n;
//            if(matrix[x][y]==target){
//                return true;
//            } else if(matrix[x][y]>target){
//                right=mid-1;
//            } else{
//                left=mid+1;
//            }
//        }
//        return false;
//    }
}
