package com.wen.ThirteenthFifty;

public class PalindromicSubstrings {
//    // Brute force, note the palindrome can be centered as one character or two characters
//    public int countSubstrings(String s) {
//        int l=s.length(), result=0;
//        for(int i=0; i<l; i++){
//            int cur=1;
//            for(int r=1; i-r>=0 && i+r<l; r++){
//                if(s.charAt(i-r)==s.charAt(i+r)){
//                    cur++;
//                } else{
//                    break;
//                }
//            }
//            for(int r=1; i-r>=0 && i+r-1<l; r++){
//                if(s.charAt(i-r)==s.charAt(i+r-1)){
//                    cur++;
//                } else{
//                    break;
//                }
//            }
//            result+=cur;
//        }
//        return result;
//    }

//    // DP1, dp[i][j] stands for whether s.substring(i, j+1) is palindrome or not
//    public static int countSubstrings(String s) {
//        int l=s.length(), result=0;
//        int[][] dp=new int[l][l];
//        for(int i=l-1; i>=0; i--){
//            for(int j=i; j<l; j++){
//                if(i==j){
//                    dp[i][j]=1;
//                    result++;
//                } else{
//                    if(s.charAt(i)==s.charAt(j) && (i+1>j-1 || dp[i+1][j-1]==1)){
//                        dp[i][j]=1;
//                        result++;
//                    }
//                }
//            }
//        }
//        return result;
//    }

    // DP2, dp[i][j] stands for whether s.substring(i, j+1) is palindrome or not
    public int countSubstrings(String s) {
        int l=s.length(), result=0;
        int[][] dp=new int[l][l];
        for(int k=1; k<=l; k++){
            for(int i=0; i<l; i++){
                int j=i+k-1;
                if(j<l){
                    if(i==j){
                        dp[i][j]=1;
                        result++;
                    } else{
                        if(s.charAt(i)==s.charAt(j)){
                            if((i+1<=j-1 && dp[i+1][j-1]==1) || i+1>j-1){
                                dp[i][j]=1;
                                result++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
