package com.wen.TenthFifty;

public class RepeatedSubstringPattern {
//    public static boolean repeatedSubstringPattern(String s) {
//        int l=s.length();
//        for(int i=1; i<=l/2; i++){
//            if(l%i==0){
//                String sub=s.substring(0, i);
//                int j=i;
//                while(j<l){
//                    if(!sub.equals(s.substring(j,j+i))){
//                        break;
//                    }
//                    j+=i;
//                }
//                if(j==l){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    // KMP
    // dp[i] stands for the length of the repeating chars in s.substring(0,i)
    public static boolean repeatedSubstringPattern(String s) {
        int l=s.length();
        int i=0, j=1;
        int[] dp=new int[l+1];
        while(j<l){
            if(s.charAt(i)==s.charAt(j)){
                dp[++j]=++i;
            } else if(i==0){
                j++;
            } else{
                i=dp[i];
            }
        }
        return dp[l]>0 && dp[l]%(l-dp[l])==0;
    }
}
