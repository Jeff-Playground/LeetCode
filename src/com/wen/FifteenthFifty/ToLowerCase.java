package com.wen.FifteenthFifty;

public class ToLowerCase {
    public String toLowerCase(String s) {
        StringBuilder sb=new StringBuilder();
        for(char c: s.toCharArray()){
            if(c>='A' && c<='Z'){
                c+='a'-'A';
            }
            sb.append(c);
        }
        return sb.toString();
    }

//    public String toLowerCase(String s) {
//        StringBuilder sb=new StringBuilder();
//        for(char c: s.toCharArray()){
//            if(c>='A' && c<='Z'){
//                c=(char)('a'+c-'A');
//            }
//            sb.append(c);
//        }
//        return sb.toString();
//    }
}
