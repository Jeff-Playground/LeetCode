package com.wen.FifthFifty;

public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        int result=0;
        for(long base=1; base<=n; base*=10) {
            long a=n/base, b=n%base;
            // Here use +8 instead of +9, because the remaining 1 will be used with b to have number like 1-something
            result+=(a+8)/10*base+((a%10)==1?1*b+1:0);
        }
        return result;
    }
}
