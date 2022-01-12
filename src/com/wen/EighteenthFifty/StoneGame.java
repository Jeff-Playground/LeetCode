package com.wen.EighteenthFifty;

public class StoneGame {
    // DP1, dp[i][j] stands for the score Alice beat Bob by in range [i, j], note the piles has an even number of piles,
    // so when len is odd, it's Bob's turn and when len is even it's Alice's turn
    public boolean stoneGame(int[] piles) {
        int l=piles.length;
        int[][] dp=new int[l][l];
        for(int len=1; len<=l; len++){
            for(int start=0, end=start+len-1; end<l; start++, end++){
                if(len==1){
                    dp[start][end]=-piles[start];
                } else{
                    if(len%2==0){
                        dp[start][end]=Math.max(piles[start]+dp[start+1][end], piles[end]+dp[start][end-1]);
                    } else{
                        dp[start][end]=Math.min(-piles[start]+dp[start+1][end], -piles[end]+dp[start][end-1]);
                    }
                }
            }
        }
        return dp[0][l-1]>0;
    }

//    // DP1 recursively
//    public boolean stoneGame(int[] piles) {
//        int l=piles.length;
//        int[][] dp=new int[l][l];
//        return aliceBeatBobBy(piles, 0, l-1, dp)>0;
//    }
//
//    private int aliceBeatBobBy(int[] piles, int start, int end, int[][] dp){
//        int len=end-start+1;
//        if(len==1){
//            dp[start][end]=-piles[start];
//        } else{
//            if(len%2==1){
//                dp[start][end]=Math.min(-piles[start]+dp[start+1][end], -piles[end]+dp[start][end-1]);
//            } else{
//                dp[start][end]=Math.max(piles[start]+dp[start+1][end], piles[end]+dp[start][end-1]);
//            }
//        }
//        return dp[start][end];
//    }

//    // DP2, dp[i][j] stands for the general beat by score in range[i, j]. This is more general than DP1 as it doesn't
//    // care about whether the len is odd or even anymore
//    public boolean stoneGame(int[] piles) {
//        int l=piles.length;
//        int[][] dp=new int[l][l];
//        for(int len=1; len<=l; len++){
//            for(int start=0, end=start+len-1; end<l; start++, end++){
//                if(len==1){
//                    dp[start][end]=piles[start];
//                } else{
//                    dp[start][end]=Math.max(piles[start]-dp[start+1][end], piles[end]-dp[start][end-1]);
//                }
//            }
//        }
//        return dp[0][l-1]>0;
//    }

//    // DP2 recursively
//    public boolean stoneGame(int[] piles) {
//        int l=piles.length;
//        int[][] dp=new int[l][l];
//        return beatByScore(piles, 0, l-1, dp)>0;
//    }
//
//    private int beatByScore(int[] piles, int start, int end, int[][] dp){
//        int len=end-start+1;
//        if(len==1){
//            dp[start][end]=piles[start];
//        } else{
//            dp[start][end]=Math.max(piles[start]-dp[start+1][end], piles[end]-dp[start][end-1]);
//        }
//        return dp[start][end];
//    }
}
