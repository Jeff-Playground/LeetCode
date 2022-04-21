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
        return ((dividend>0)^(divisor>0))?-result:result;
    }

//    // Using a recursive call to replace the while loop
//    public int divide(int dividend, int divisor) {
//        if(dividend==Integer.MIN_VALUE && divisor==-1){
//            return Integer.MAX_VALUE;
//        }
//        long m=Math.abs((long)dividend), n=Math.abs((long)divisor);
//        if(m<n){
//            return 0;
//        } else if(m==n){
//            return (dividend>0)^(divisor>0)?-1:1;
//        } else{
//            int t=0;
//            while(m>(n<<t)){
//                t++;
//            }
//            t--;
//            int result=(1<<t)+divide((int)(m-(n<<t)), (int)n);
//            return (dividend>0)^(divisor>0)?-result:result;
//        }
//    }
}
