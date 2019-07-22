package com.wen.FifthFifty;

public class NumberOfDigitOne {
    // Every 10 numbers has 1 number where 1 is in the ones place, every 100 numbers has 10 number where 1 is in the tens place...
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
