package com.wen.EighthFifty;

public class SumOfTwoIntegers {
    // Bit manipulation, iterative
    // Time complexity: O(log(max(a,b)))
    // Since the time complexity depends on the number of loops executed, it is difficult to give the exact time
    // complexity of this question, but we can provide an estimated value. The number of loops executed is related
    // to the number of bits in the binary representation of a, b, and a rough upper bound is O(log(max(a,b))).
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
