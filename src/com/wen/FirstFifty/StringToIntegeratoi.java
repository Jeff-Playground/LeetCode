package com.wen.FirstFifty;

public class StringToIntegeratoi {
    // Avoid/check overflow by using cur/10==prev
    public int myAtoi(String s) {
        if(s.trim().isEmpty()){
            return 0;
        }
        int sign=1;
        int i=0;
        int r=0;
        while(s.charAt(i)==' ') {
            i++;
        }
        if(s.charAt(i)=='+' || s.charAt(i)=='-') {
            sign=(s.charAt(i)=='+')?1:-1;
            i++;
        }
        while(i<s.length()&&(s.charAt(i)>='0' && s.charAt(i)<='9')) {
            int temp=r*10+s.charAt(i)-'0';
            if(temp/10!=r) {
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            } else {
                r=temp;
            }
            i++;
        }
        return r*sign;
    }

//    // Avoid/check overflow with a long cache
//    public int myAtoi(String s) {
//        long cache=0;
//        int sign=0;
//        s=s.trim();
//        for(char c: s.toCharArray()){
//            if(c=='+'){
//                if(sign==0){
//                    sign=1;
//                } else{
//                    return sign==-1?-(int)cache:(int)cache;
//                }
//            } else if(c=='-'){
//                if(sign==0){
//                    sign=-1;
//                } else{
//                    return sign==-1?-(int)cache:(int)cache;
//                }
//            } else if(c>='0' && c<='9'){
//                cache=cache*10+c-'0';
//                if(sign==0){
//                    sign=1;
//                }
//                if(sign!=-1 && cache>Integer.MAX_VALUE){
//                    return Integer.MAX_VALUE;
//                } else if(sign==-1 && cache-1>=Integer.MAX_VALUE){
//                    return Integer.MIN_VALUE;
//                }
//            } else{
//                return sign==-1?-(int)cache:(int)cache;
//            }
//        }
//        return sign==-1?-(int)cache:(int)cache;
//    }
}
