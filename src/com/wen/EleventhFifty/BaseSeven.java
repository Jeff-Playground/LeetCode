package com.wen.EleventhFifty;

public class BaseSeven {
    // Recursive
    public String convertToBase7(int num) {
        if(num<0){
            return "-"+convertToBase7(-num);
        } else if(num<7){
            return String.valueOf(num);
        } else{
            return convertToBase7(num/7)+num%7;
        }
    }

//    // Iterative
//    public String convertToBase7(int num) {
//        if(num==0){
//            return "0";
//        }
//        StringBuilder sb=new StringBuilder();
//        boolean isNeg=num<0;
//        num=isNeg?-num:num;
//        while(num>0){
//            int cur=num%7;
//            sb.append(String.valueOf(cur));
//            num/=7;
//        }
//        if(isNeg){
//            sb.append("-");
//        }
//        return sb.reverse().toString();
//    }
}
