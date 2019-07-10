package com.wen.FifthFifty;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }

//    public boolean isPowerOfTwo(int n) {
//        while(n>1) {
//            if((n & 1)!=0) {
//                return false;
//            } else {
//                n>>=1;
//            }
//        }
//        return n==1;
//    }
}
