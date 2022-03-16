package com.wen.FifthFifty;

public class MaximalSquare {
//    // DP, bottom up
//    // dp[i][j] stands for the edge of the largest square ends at matrix[i][j]
//    public int maximalSquare(char[][] matrix) {
//        if(matrix==null || matrix.length==0 || matrix[0].length==0){
//            return 0;
//        }
//        int m=matrix.length, n=matrix[0].length;
//        int[][] dp=new int[m][n];
//        int result=0;
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(matrix[i][j]=='1'){
//                    if(i==0 || j==0){
//                        dp[i][j]=1;
//                    } else{
//                        // This can be thought of as adding 1 level to the minimum adjacent square
//                        dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
//                    }
//                }
//                result=Math.max(result, dp[i][j]);
//            }
//        }
//        return result*result;
//    }

    // DP, top down
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int[][] cache=new int[m][n];
        int[] max=new int[]{0};
        dp(matrix, cache, m-1, n-1, max);
        return max[0]*max[0];
    }

    private int dp(char[][] matrix, int[][] cache, int i, int j, int[] max){
        if(cache[i][j]==0){
            int min=Math.min(i>0 && j>0?dp(matrix, cache, i-1, j-1, max):0, Math.min(i>0?dp(matrix, cache, i-1, j, max):0, j>0?dp(matrix, cache, i, j-1, max):0));
            if(matrix[i][j]=='1'){
                cache[i][j]=min+1;
                max[0]=Math.max(max[0], cache[i][j]);
            }
        }
        return cache[i][j];
    }

//    // BFS
//    public static int maximalSquare(char[][] matrix) {
//        if(matrix==null || matrix.length==0 || matrix[0].length==0){
//            return 0;
//        }
//        int m=matrix.length, n=matrix[0].length;
//        int result=0;
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(matrix[i][j]=='1'){
//                    if(i+1>=m || j+1>=n){
//                        result=Math.max(result, 1*1);
//                        continue;
//                    }
//                    int size=1;
//                    while(i+size<m && j+size<n){
//                        boolean isSquare=true;
//                        for(int x=i; x<=i+size && x<m; x++){
//                            if(matrix[x][j+size]=='0'){
//                                isSquare=false;
//                                break;
//                            }
//                        }
//                        if(isSquare){
//                            for(int y=j; y<=j+size && y<n; y++){
//                                if(matrix[i+size][y]=='0'){
//                                    isSquare=false;
//                                    break;
//                                }
//                            }
//                        }
//                        if(isSquare){
//                            size++;
//                            result=Math.max(result, size*size);
//                        } else{
//                            result=Math.max(result, size*size);
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }
}
