package com.wen.SecondFifty;

public class DecodeWays {
    public static int numDecodings(String s) {
        if(s==null || s.length()==0 || s.startsWith("0")){
            return 0;
        }
        int curCount=1, beforeCount=1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)=='0'){
                curCount=0;
            }
            if(s.charAt(i-1)=='1' || (s.charAt(i-1)=='2' && (s.charAt(i)>='0' && s.charAt(i)<='6'))){
                curCount=curCount+beforeCount;
                beforeCount=curCount-beforeCount;
            } else {
                beforeCount=curCount;
            }
        }
        return curCount;
    }

//    // Dynamic Programming
//    public static int numDecodings(String s) {
//        if(s==null || s.length()==0){
//            return 0;
//        }
//        int[] dp=new int[s.length()+1];
//        dp[0]=1;
//        if(s.charAt(0)=='0'){
//            return 0;
//        } else{
//            dp[1]=1;
//        }
//        for(int i=1; i<s.length(); i++){
//            // when the added char is treated as a single char
//            if(s.charAt(i)>='1' && s.charAt(i)<='9'){
//                dp[i+1]=dp[i];
//            } else{
//                dp[i+1]=0;
//            }
//            // when the added char can be combined with the previous char
//            if(s.charAt(i-1)=='1' || (s.charAt(i-1)=='2'&& (s.charAt(i)>='0' && s.charAt(i)<='6'))){
//                dp[i+1]=dp[i+1]+dp[i-1];
//            }
//        }
//        return dp[s.length()];
//    }
}
