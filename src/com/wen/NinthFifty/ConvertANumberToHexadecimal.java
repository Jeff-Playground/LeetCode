package com.wen.NinthFifty;

public class ConvertANumberToHexadecimal {
    // Bit manipulation
    public String toHex(int num) {
        char[] symbol=new char[]{'a','b','c','d','e','f'};
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<8; i++){
            int cur=num&0b1111;
            if(cur<10){
                sb.append(String.valueOf(cur));
            } else{
                sb.append(symbol[cur-10]);
            }
            num>>>=4;
        }
        while(sb.length()>1){
            if(sb.charAt(sb.length()-1)=='0'){
                sb.setLength(sb.length()-1);
            } else{
                break;
            }
        }
        return sb.reverse().toString();
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
