package com.wen.FirstFifty;

import java.util.Arrays;

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

//    public String convert(String s, int numRows) {
//        if(s==null || s.length()==0 || numRows<=1){
//            return s;
//        }
//        String[] converted=new String[numRows];
//        Arrays.fill(converted, "");
//        int size=numRows*2-2;
//        for(int i=0; i<s.length(); i++){
//            if(i%size<numRows){
//                converted[i%size]+=s.charAt(i);
//            } else {
//                converted[size-i%size]+=s.charAt(i);
//            }
//        }
//        String result="";
//        for(int i=0; i<numRows; i++){
//            result+=converted[i];
//        }
//        return result;
//    }
}
