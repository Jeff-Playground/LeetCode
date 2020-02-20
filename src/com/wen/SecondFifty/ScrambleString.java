package com.wen.SecondFifty;

import java.util.Arrays;

public class ScrambleString {
    // Dynamic Programming, boolean dp[i][j][k] stands for whether the s1.substring(i, i+k) and s2.substring(j, j+k) is
    // scrambled string
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        if(s1.length()==0 || s1.equals(s2)){
            return true;
        }
        int n=s1.length();
        boolean[][][] dp=new boolean[n][n][n+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dp[i][j][1]=s1.charAt(i)==s2.charAt(j);
            }
        }
        for(int len=2; len<=n; len++){
            for(int i=0; i<=n-len; i++) {
                for(int j=0; j<=n-len; j++) {
                    for(int k=1; k<len; k++){
                        if(!dp[i][j][len]){
                            if((dp[i][j][k] && dp[i+k][j+k][len-k]) || (dp[i+k][j][len-k] && dp[i][j+len-k][k])){
                                dp[i][j][len]=true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }

//    // Recursive
//    public static boolean isScramble(String s1, String s2) {
//        if(s1.length()!=s2.length()){
//            return false;
//        }
//        if(s1.equals(s2)){
//            return true;
//        }
//        char[] t1=s1.toCharArray();
//        Arrays.sort(t1);
//        char[] t2=s2.toCharArray();
//        Arrays.sort(t2);
//        String ss1= new String(t1);
//        String ss2= new String(t2);
//        if(!ss1.equals(ss2)){
//            return false;
//        }
//
//        for(int split=1; split<s1.length(); split++){
//            String s11=s1.substring(0, split);
//            String s12=s1.substring(split);
//            String s21=s2.substring(0, split);
//            String s22=s2.substring(split);
//            if(isScramble(s11, s21) &&  isScramble(s12, s22)){
//                return true;
//            }
//
//            s21=s2.substring(0, s2.length()-split);
//            s22=s2.substring(s2.length()-split);
//            if(isScramble(s11, s22) &&  isScramble(s12, s21)){
//                return true;
//            }
//        }
//        return false;
//    }
}
