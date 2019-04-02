package com.wen.FourthFifty;

public class FactorialTrailingZeroes {
    // Recursive
    public int trailingZeroes(int n) {
        return n>=5?n/5+trailingZeroes(n/5):0;
    }

//    // Iterative
//    public int trailingZeroes(int n) {
//        int result=0;
//        while(n>0){
//            result+=n/5;
//            n/=5;
//        }
//        return result;
//    }
}
