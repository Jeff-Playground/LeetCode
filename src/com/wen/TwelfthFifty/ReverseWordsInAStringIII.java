package com.wen.TwelfthFifty;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        String[] split=s.split("\\s");
        StringBuilder sb=new StringBuilder();
        for(String e: split){
            sb.append(new StringBuilder(e).reverse().toString());
            sb.append(" ");
        }
        if(sb.length()>0){
            sb.setLength(sb.length()-1);
        }
        return sb.toString();
    }

//    public String reverseWords(String s) {
//        String rs=new StringBuilder(s).reverse().toString();
//        String[] split=rs.split("\\s");
//        StringBuilder sb=new StringBuilder();
//        for(int i=split.length-1; i>=0; i--){
//            sb.append(split[i]);
//            sb.append(" ");
//        }
//        if(sb.length()>0){
//            sb.setLength(sb.length()-1);
//        }
//        return sb.toString();
//    }
}
