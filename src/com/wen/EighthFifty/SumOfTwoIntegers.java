package com.wen.EighthFifty;

public class SumOfTwoIntegers {
    // Bit manipulation, iterative
    public int getSum(int a, int b) {
        while(b!=0){
            int carry=(a&b)<<1;
            a=a^b;
            b=carry;
        }
        return a;
    }

//    // Bit manipulation, recursive
//    public int getSum(int a, int b) {
//        if(b==0){
//            return a;
//        }
//        int sumWithoutCarry=a^b, carry=(a&b)<<1;
//        return getSum(sumWithoutCarry, carry);
//    }

//    // Bit manipulation, recursive
//    public int getSum(int a, int b) {
//        return b==0?a:getSum(a^b, (a&b)<<1);
//    }
}
