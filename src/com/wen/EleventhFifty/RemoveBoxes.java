package com.wen.EleventhFifty;

public class RemoveBoxes {
    // DP2, dp[i][j][k] stands for the maximum score for range [i, j] when there're k numbers on the left that's same to
    // the number at boxes[i]
    public int removeBoxes(int[] boxes) {
        int l=boxes.length;
        int[][][] dp=new int[l][l][l];
        for(int i=0; i<l; i++){
            for(int k=0; k<=i; k++){
                dp[i][i][k]=(k+1)*(k+1);
            }
        }
        for(int length=2; length<=l; length++){
            for(int j=length-1; j<l; j++){
                int i=j-length+1;
                for(int k=0; k<=i; k++){
                    int cur=(k+1)*(k+1)+dp[i+1][j][0];
                    for(int m=i+1; m<=j; m++){
                        if(boxes[m]==boxes[i]){
                            cur=Math.max(cur, (i+1<=m-1?dp[i+1][m-1][0]:0)+dp[m][j][k+1]);
                        }
                    }
                    dp[i][j][k]=cur;
                }
            }
        }
        return l==0?0:dp[0][l-1][0];
    }

//    // DP, dp[i][j][k] stands for the maximum score for range [i, j] when there're k numbers on the left that's same to
//    // the number at boxes[i]
//    public int removeBoxes(int[] boxes) {
//        int l=boxes.length;
//        int[][][] dp=new int[l][l][l];
//        return rbHelper(boxes, 0, l-1, 0, dp);
//    }
//
//    private int rbHelper(int[] boxes, int start, int end, int sameOnLeft, int[][][] dp){
//        if(start>end){
//            return 0;
//        }
//        if(dp[start][end][sameOnLeft]>0){
//            return dp[start][end][sameOnLeft];
//        }
//        int result=(sameOnLeft+1)*(sameOnLeft+1)+rbHelper(boxes, start+1, end, 0, dp);
//        for(int i=start+1; i<=end; i++){
//            if(boxes[i]==boxes[start]){
//                result=Math.max(result, rbHelper(boxes, start+1, i-1, 0, dp)+rbHelper(boxes, i, end, sameOnLeft+1, dp));
//            }
//        }
//        dp[start][end][sameOnLeft]=result;
//        return result;
//    }
}
