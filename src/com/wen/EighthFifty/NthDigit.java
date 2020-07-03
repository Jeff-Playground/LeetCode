package com.wen.EighthFifty;

public class NthDigit {
    public static int findNthDigit(int n) {
        int range=9, base=10, digit=1;
        while(n>range*Math.pow(base, digit-1)*digit){
            n-=range*Math.pow(base, digit-1)*digit;
            digit++;
        }
        int start=(int)Math.pow(base, digit-1);
        int count=n/digit+(n%digit==0?0:1);
        return String.valueOf(start+count-1).charAt(n%digit==0?digit-1:n%digit-1)-'0';
    }
}
