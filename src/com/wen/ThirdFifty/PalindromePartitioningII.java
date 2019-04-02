package com.wen.ThirdFifty;

public class PalindromePartitioningII {
//    // Dynamic Programming
//    public static int minCut(String s) {
//        int len=s.length();
//        int[] dp=new int[len+1];
//        boolean[][] isPalindrome=new boolean[len][len];
//        for(int i=0; i<=len; i++){
//            dp[i]=len-i-1;
//        }
//        for(int i=len-1; i>=0; i--){
//            for(int j=i; j<len; j++){
//                if(s.charAt(i)==s.charAt(j) && (j-i<=1 || isPalindrome[i+1][j-1])){
//                    isPalindrome[i][j]=true;
//                    dp[i]=Math.min(dp[i], dp[j+1]+1);
//                }
//            }
//        }
//        return dp[0];
//    }

    public static int minCut(String s) {
        int len=s.length();
        int[] dp=new int[len];
        boolean[][] isPalindrome=new boolean[len][len];
        // substring(0,1) has a cut of 0, no need to assign value
        for(int j=1; j<len; j++){
            dp[j]=j;
        }
        for(int j=1; j<=len; j++){
            for(int i=0; i<=j; i++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=1 || isPalindrome[i+1][j-1])){
                    isPalindrome[i][j]=true;
                    // i==0 means the whole substring(i, j+1) is a palindrome, so cut is 0
                    dp[j]=(i==0)? 0 : Math.min(dp[j], dp[i-1]+1);
                }
            }
        }
        return dp[len-1];
    }
}
