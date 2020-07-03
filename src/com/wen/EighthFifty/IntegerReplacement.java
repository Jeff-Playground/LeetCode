package com.wen.EighthFifty;

public class IntegerReplacement {
    // Bit manipulation, if (n+1)%4==0, do n+=1, else do n-=1. Note n==3 need to be handled as a special case
    public int integerReplacement(int n) {
        int result=0;
        long t=n;
        while(t!=1){
            result++;
            if((t&1)==1){
                if((t&2)==2 && t!=3){
                    t+=1;
                } else{
                    t-=1;
                }
            } else{
                t/=2;
            }
        }
        return result;
    }

//    public static int integerReplacement(int n) {
//        int result=0;
//        if(n!=1){
//            if(n%2==0){
//                result+=1+integerReplacement(n/2);
//            } else{
//                long t=n;
//                result+=2+Math.min(integerReplacement((int)((t+1)/2)), integerReplacement((int)((t-1)/2)));
//            }
//        }
//        return result;
//    }
}
