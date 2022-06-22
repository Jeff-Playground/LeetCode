package com.wen.FifteenthFifty;

public class MinimumASCIIDeleteSumForTwoStrings {
//    // DP1, dp[i][j] stands for the largest common subsequence of s1.substring(0, i+1) and s2.substring(0, j+1)
//    public int minimumDeleteSum(String s1, String s2) {
//        int l1=s1.length(), l2=s2.length();
//        String[][] dp=new String[l1][l2];
//        for(int i=0; i<l1; i++){
//            if(s1.charAt(i)==s2.charAt(0) || (i>0 && !dp[i-1][0].isEmpty())){
//                dp[i][0]=""+s2.charAt(0);
//            } else{
//                dp[i][0]="";
//            }
//        }
//        for(int j=0; j<l2; j++){
//            if(s2.charAt(j)==s1.charAt(0) || (j>0 && !dp[0][j-1].isEmpty())){
//                dp[0][j]=""+s1.charAt(0);
//            } else{
//                dp[0][j]="";
//            }
//        }
//        for(int i=1; i<l1; i++){
//            for(int j=1; j<l2; j++){
//                if(s1.charAt(i)==s2.charAt(j)){
//                    dp[i][j]=dp[i-1][j-1]+s1.charAt(i);
//                } else{
//                    dp[i][j]=getValue(dp[i][j-1])>getValue(dp[i-1][j])?dp[i][j-1]:dp[i-1][j];
//                }
//            }
//        }
//        return getValue(s1)+getValue(s2)-2*getValue(dp[l1-1][l2-1]);
//    }

//    // Optimized DP1, where dp stores the int value of the largest common subsequence instead of the String
//    public int minimumDeleteSum(String s1, String s2) {
//        int l1=s1.length(), l2=s2.length();
//        int[][] dp=new int[l1][l2];
//        for(int i=0; i<l1; i++){
//            if(s1.charAt(i)==s2.charAt(0) || (i>0 && dp[i-1][0]>0)){
//                dp[i][0]=s2.charAt(0);
//            }
//        }
//        for(int j=0; j<l2; j++){
//            if(s2.charAt(j)==s1.charAt(0) || (j>0 && dp[0][j-1]>0)){
//                dp[0][j]=s1.charAt(0);
//            }
//        }
//        for(int i=1; i<l1; i++){
//            for(int j=1; j<l2; j++){
//                if(s1.charAt(i)==s2.charAt(j)){
//                    dp[i][j]=dp[i-1][j-1]+s1.charAt(i);
//                } else{
//                    dp[i][j]=dp[i][j-1]>dp[i-1][j]?dp[i][j-1]:dp[i-1][j];
//                }
//            }
//        }
//        return getValue(s1)+getValue(s2)-2*dp[l1-1][l2-1];
//    }
//
//    private int getValue(String s){
//        int result=0;
//        for(char c: s.toCharArray()){
//            result+=c;
//        }
//        return result;
//    }

    // DP2, dp[i][j] stands for the minimum delete sum for s1.substring(0, i) and s2.substring(0, j)
    public int minimumDeleteSum(String s1, String s2) {
        int l1=s1.length(), l2=s2.length();
        int[][] dp=new int[l1+1][l2+1];
        for(int i=1; i<=l1; i++){
            dp[i][0]=i>0?dp[i-1][0]+s1.charAt(i-1):s1.charAt(i-1);
        }
        for(int j=1; j<=l2; j++){
            dp[0][j]=j>0?dp[0][j-1]+s2.charAt(j-1):s2.charAt(j-1);
        }
        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                } else{
                    dp[i][j]=Math.min(dp[i-1][j]+s1.charAt(i-1), dp[i][j-1]+s2.charAt(j-1));
                }
            }
        }
        return dp[l1][l2];
    }
}
