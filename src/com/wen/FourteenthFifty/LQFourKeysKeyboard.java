package com.wen.FourteenthFifty;

/*
Imagine you have a special keyboard with the following keys:

A: Print one 'A' on the screen.
Ctrl-A: Select the whole screen.
Ctrl-C: Copy selection to buffer.
Ctrl-V: Print buffer on screen appending it after what has already been printed.

Given an integer n, return the maximum number of 'A' you can print on the screen with at most n presses on the keys.



Example 1:
Input: n = 3
Output: 3
Explanation: We can at most get 3 A's on screen by pressing the following key sequence:
A, A, A


Example 2:
Input: n = 7
Output: 9
Explanation: We can at most get 9 A's on screen by pressing following key sequence:
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V


Constraints:
1 <= n <= 50
 */

public class LQFourKeysKeyboard {
    // DP, dp[i] stands for the max when press i times on the keyboard
    public int maxA(int n) {
        int[] dp=new int[n+1];
        for(int i=1; i<=n; i++){
            if(i<=6){
                dp[i]=i;
            } else{
                for(int j=i-3; j>=0; j--){
                    if(dp[j]*(i-j-1)>=dp[i]){
                        dp[i]=dp[j]*(i-j-1);
                    } else{
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}
