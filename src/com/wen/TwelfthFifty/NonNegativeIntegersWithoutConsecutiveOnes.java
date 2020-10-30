package com.wen.TwelfthFifty;

public class NonNegativeIntegersWithoutConsecutiveOnes {
    // DP, dp[i] stands for the count for i digits of a number(binary)
    public int findIntegers(int num) {
        int[] dp=new int[31];
        dp[0]=1;
        dp[1]=2;
        for(int i=2; i<31; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        int pre=0, move=30, result=0;
        while(move>=0){
            if((num&(1<<move))>0){
                result+=dp[move];
                if(pre==1){
                    return result;
                } else{
                    pre=1;
                }
            } else{
                pre=0;
            }
            move--;
        }
        // Note here do +1 because if this is reachable, it means the num itself satisfies the condition where no 2
        // consecutive 1s
        return result+1;
    }

//    // DP, one[i] stands for the count when sb.charAt(i)=='1', and zero[i] stands for the count when sb.charAt(i)=='0'
//    public int findIntegers(int num) {
//        int length=0;
//        StringBuilder sb=new StringBuilder();
//        while(num>0){
//            sb.append((num&1)==1?'1':'0');
//            num>>=1;
//            length++;
//        }
//        int[] one=new int[length], zero=new int[length];
//        one[0]=1;
//        zero[0]=1;
//        for(int i=1; i<length; i++){
//            zero[i]=zero[i-1]+one[i-1];
//            one[i]=zero[i-1];
//        }
//        int result=zero[length-1]+one[length-1];
//        for(int i=length-2; i>=0; i--){
//            if(sb.charAt(i)=='1' && sb.charAt(i+1)=='1'){
//                break;
//            }
//            if(sb.charAt(i)=='0' && sb.charAt(i+1)=='0'){
//                result-=one[i];
//            }
//        }
//        return result;
//    }
}
