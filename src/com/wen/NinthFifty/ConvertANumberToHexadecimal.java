package com.wen.NinthFifty;

public class ConvertANumberToHexadecimal {
    // Bit manipulation
    public String toHex(int num) {
        char[] cs=new char[]{'a' ,'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<8; i++){
            int cur=num&0b1111;
            if(cur<10){
                sb.insert(0, String.valueOf(cur));
            } else{
                sb.insert(0, cs[cur-10]);
            }
            num>>>=4;
        }
        for(int i=0; i<7; i++){
            if(sb.charAt(0)=='0'){
                sb.deleteCharAt(0);
            } else{
                break;
            }
        }
        return sb.toString();
    }

//    public static String toHex(int num) {
//        long numLong=num<0?-2l*Integer.MIN_VALUE+num:num;
//        return toHex(numLong);
//    }
//
//    private static String toHex(long num){
//        if(num==0){
//            return "0";
//        } else{
//            StringBuilder sb=new StringBuilder();
//            char[] cs=new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
//            while(num>0){
//                int remainder=(int)(num%16);
//                if(remainder<10){
//                    sb.insert(0, String.valueOf(remainder));
//                } else{
//                    sb.insert(0, cs[remainder-10]);
//                }
//                num/=16;
//            }
//            return sb.toString();
//        }
//    }
}
