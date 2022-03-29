package com.wen.TwentyFifthFifty;

/*
Given a string s and an integer k, return true if s is a k-palindrome.

A string is k-palindrome if it can be transformed into a palindrome by removing at most k characters from it.


Example 1:
Input: s = "abcdeca", k = 2
Output: true
Explanation: Remove 'b' and 'e' characters.


Example 2:
Input: s = "abbababa", k = 1
Output: true


Constraints:
1 <= s.length <= 1000
s consists of only lowercase English letters.
1 <= k <= s.length
 */

public class LQValidPalindromeIII {
    // DP, bottom up, dp[i][j] stands for the longest palindrome subsequence for s.substring(i,j+1)
    public boolean isValidPalindrome(String s, int k) {
        int l=s.length();
        int[][] dp=new int[l][l];
        for(int t=1; t<=l; t++){
            for(int i=0; i<=l-t; i++){
                for(int j=i; j<=l-1; j++){
                    if(i==j){
                        dp[i][j]=1;
                    } else{
                        if(s.charAt(i)==s.charAt(j)){
                            dp[i][j]=dp[i+1][j-1]+2;
                        } else{
                            dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
                        }
                    }
                }
            }
        }
        return dp[0][l-1]+k>=l;
    }

//    // DP, top down, much faster than bottom up because it doesn't need to compute every pair
//    public boolean isValidPalindrome(String s, int k) {
//        int l=s.length();
//        int[][] cache=new int[l][l];
//        return dp(s, 0, l-1, cache)>=l-k;
//    }
//
//    private int dp(String s, int start, int end, int[][] cache){
//        if(start>end){
//            return 0;
//        }
//        if(cache[start][end]==0){
//            if(start==end){
//                cache[start][end]=1;
//            } else{
//                if(s.charAt(start)==s.charAt(end)){
//                    cache[start][end]=dp(s, start+1, end-1, cache)+2;
//                } else{
//                    cache[start][end]=Math.max(dp(s, start, end-1, cache), dp(s, start+1, end, cache));
//                }
//            }
//        }
//        return cache[start][end];
//    }
}
