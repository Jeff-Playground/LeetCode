package com.wen.EleventhFifty;

public class BaseSeven {
    // Recursive
    public String convertToBase7(int num) {
        if(num<0){
            return "-"+convertToBase7(-num);
        } else if(num<7){
            return String.valueOf(num);
        } else{
            return convertToBase7(num/7)+String.valueOf(num%7);
        }
    }

//    // Iterative
//    public String convertToBase7(int num) {
//        boolean isNeg=false;
//        if(num<0){
//            isNeg=true;
//            num=-num;
//        }
//        StringBuilder sb=new StringBuilder();
//        do {
//            int remainder=num%7;
//            num/=7;
//            sb.append(String.valueOf(remainder));
//        } while(num>0);
//        if(isNeg){
//            sb.append("-");
//        }
//        return sb.reverse().toString();
//    }
}
