package com.wen.NinthFifty;

public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        if(s==null || s.length()==0){
            return 0;
        } else{
            int l=s.length(), result=0;
            for(int i=0; i<l; i++){
                if(s.charAt(i)==' '){
                    while(i+1<l && s.charAt(i+1)==' '){
                        i++;
                    }
                } else{
                    result++;
                    while(i+1<l && s.charAt(i+1)!=' '){
                        i++;
                    }
                }
            }
            return result;
        }
    }

//    public int countSegments(String s) {
//        if(s==null || s.length()==0){
//            return 0;
//        } else{
//            String[] splited=s.split("\\s+");
//            int result=0;
//            for(String e: splited){
//                if(!e.isEmpty()){
//                    result++;
//                }
//            }
//            return result;
//        }
//    }
}
