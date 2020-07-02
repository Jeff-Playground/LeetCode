package com.wen.EighthFifty;

import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK {
    // Optimized with DP, because row count is much larger than column count, do the sum based on rows so the eventual
    // time complexity is O(n*n*m*logm)
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m=matrix.length, n=matrix[0].length;
        int result=Integer.MIN_VALUE;
        for(int j=0; j<n; j++){
            int[] sum=new int[m];
            for(int c=j; c<n; c++){
                for(int i=0; i<m; i++){
                    sum[i]+=matrix[i][c];
                }
                int curSum=0;
                TreeSet<Integer> sortedSums=new TreeSet<>();
                sortedSums.add(0);
                for(int s: sum){
                    curSum+=s;
                    Integer preSum=sortedSums.ceiling(curSum-k);
                    if(preSum!=null){
                        result=Math.max(result, curSum-preSum);
                        if(result==k){
                            return result;
                        }
                    }
                    sortedSums.add(curSum);
                }
            }
        }
        return result;
    }

//    // Brute force with DP
//    public static int maxSumSubmatrix(int[][] matrix, int k) {
//        int m=matrix.length, n=matrix[0].length;
//        int[][] sum=new int[m][n];
//        int result=Integer.MIN_VALUE;
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                sum[i][j]=matrix[i][j];
//                if(i>0){
//                    sum[i][j]+=sum[i-1][j];
//                }
//                if(j>0){
//                    sum[i][j]+=sum[i][j-1];
//                }
//                if(i>0 && j>0){
//                    sum[i][j]-=sum[i-1][j-1];
//                }
//                for(int r=i; r>=0; r--){
//                    for(int c=j; c>=0; c--){
//                        int area=sum[i][j];
//                        if(r>0){
//                            area-=sum[r-1][j];
//                        }
//                        if(c>0){
//                            area-=sum[i][c-1];
//                        }
//                        if(r>0 && c>0){
//                            area+=sum[r-1][c-1];
//                        }
//                        if(area<=k){
//                            if(area==k){
//                                return area;
//                            }
//                            result=Math.max(result, area);
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }
}
