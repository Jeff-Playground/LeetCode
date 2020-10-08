package com.wen.FourthFifty;

public class FactorialTrailingZeroes {
    // Because 10=2*5, and the number of 2 in a factorial is far more than the number of 5, so this problem is essentially
    // finding the number of 5 in n

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
