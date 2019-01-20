package com.wen.FirstFifty;

public class StringToIntegeratoi {
    public int myAtoi(String str) {
        if(str.trim().isEmpty()) {
            return 0;
        }
        int sign=1;
        int i=0;
        int r=0;
        while(str.charAt(i)==' ') {
            i++;
        }
        if(str.charAt(i)=='+' || str.charAt(i)=='-') {
            sign=(str.charAt(i)=='+')?1:-1;
            i++;
        }
        while(i<str.length()&&(str.charAt(i)>='0' && str.charAt(i)<='9')) {
            int temp=r*10+str.charAt(i)-'0';
            if(temp/10!=r) {
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            } else {
                r=temp;
            }
            i++;
        }
        return r*sign;
    }
}
