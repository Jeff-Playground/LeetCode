package com.wen.FirstFifty;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor==0||(divisor==-1 && dividend == Integer.MIN_VALUE)){
            return Integer.MAX_VALUE;
        }
        long m=Math.abs((long)dividend), n=Math.abs((long)divisor);
        int result=0;
        while(m>=n){
            long t=n, s=1;
            while(m>(t<<1)){
                t<<=1;
                s<<=1;
            }
            m-=t;
            result+=s;
        }
        return ((dividend>0)^(divisor>0))?result:-result;
    }
}
