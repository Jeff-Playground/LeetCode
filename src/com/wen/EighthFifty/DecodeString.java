package com.wen.EighthFifty;

import java.util.Stack;

public class DecodeString {
//    public String decodeString(String s) {
//        if(s==null || s.length()==0){
//            return s;
//        }
//        int[] index=new int[]{0};
//        return decode(s, index);
//    }
//
//    private String decode(String s, int[] index){
//        StringBuilder result=new StringBuilder();
//        int l=s.length();
//        while(index[0]<l && s.charAt(index[0])!=']'){
//            char c=s.charAt(index[0]);
//            if(!isNumber(c)){
//                result.append(c);
//                index[0]++;
//            } else{
//                int count=c-'0';
//                while(s.charAt(++index[0])!='['){
//                    count=count*10+s.charAt(index[0])-'0';
//                }
//                index[0]++;
//                String t=decode(s, index);
//                index[0]++;
//                while(count-->0){
//                    result.append(t);
//                }
//            }
//        }
//        return result.toString();
//    }
//
//    private boolean isNumber(char c){
//        return c>='0' && c<='9';
//    }

    public String decodeString(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        Stack<Integer> counts=new Stack<>();
        Stack<String> values=new Stack<>();
        StringBuilder result=new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(c>='0' && c<='9'){
                int start=i;
                while(s.charAt(i+1)!='['){
                    i++;
                }
                int count=Integer.parseInt(s.substring(start, i+1));
                counts.push(count);
            } else if(c=='['){
                values.push(result.toString());
                result.setLength(0);
            } else if(c==']'){
                String temp=result.toString();
                result.setLength(0);
                int count=counts.pop();
                while(count-->0){
                    result.append(temp);
                }
                if(!values.isEmpty()){
                    result.insert(0, values.pop());
                }
            } else{
                result.append(c);
            }
        }
        return result.toString();
    }
}
