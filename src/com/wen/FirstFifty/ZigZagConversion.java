package com.wen.FirstFifty;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows<2) {
            return s;
        }
        String r="";
        int size=numRows*2-2;
        for(int i=0; i<numRows; i++) {
            for(int j=i; j<s.length(); j+=size) {
                r+=s.charAt(j);
                if(i!=0&&i!=(numRows-1)&&(j+size-2*i)<s.length()) {
                    r+=s.charAt(j+size-2*i);
                }
            }
        }
        return r;
    }
}
