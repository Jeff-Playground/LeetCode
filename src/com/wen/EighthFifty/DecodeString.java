package com.wen.EighthFifty;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        int firstBracket=s.indexOf('[');
        if(firstBracket==-1) {
            return s;
        } else {
            StringBuilder result=new StringBuilder();
            int startNum=firstBracket-1;
            while(startNum>=0 && isNumber(s.charAt(startNum))) {
                startNum--;
            }
            if(startNum<firstBracket) {
                int count=Integer.parseInt(s.substring(startNum+1, firstBracket));
                int lastBracket=s.length()-1;
                while(s.charAt(lastBracket)!=']') {
                    lastBracket--;
                }
                int nextBracket=getNextBracket(s, firstBracket);
                if(lastBracket==nextBracket) {
                    String inBracket=decodeString(s.substring(firstBracket+1, lastBracket));
                    if(startNum>=0) {
                        result.append(s.substring(0, startNum+1));
                    }
                    while(count-->0) {
                        result.append(inBracket);
                    }
                    if(lastBracket<s.length()-1) {
                        result.append(s.substring(lastBracket+1));
                    }
                } else {
                    String inBracket=decodeString(s.substring(firstBracket+1, nextBracket));
                    if(startNum>=0) {
                        result.append(s.substring(0, startNum+1));
                    }
                    while(count-->0) {
                        result.append(inBracket);
                    }
                    result.append(decodeString(s.substring(nextBracket+1)));
                }
            }
            return result.toString();
        }
    }

    private int getNextBracket(String s, int start) {
        int count=0;
        for(int i=start; i<s.length(); i++) {
            if(s.charAt(i)=='[') {
                count++;
            } else if(s.charAt(i)==']') {
                count--;
                if(count==0) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean isNumber(char c) {
        return c>='0' && c<='9';
    }

//    public String decodeString(String s) {
//        if(s==null || s.length()==0){
//            return "";
//        }
//        Stack<Integer> counts=new Stack<>();
//        Stack<String> values=new Stack<>();
//        String cur="";
//        for(int i=0; i<s.length(); i++){
//            char c=s.charAt(i);
//            if(c>='0' && c<='9'){
//                int start=i;
//                while(s.charAt(i+1)!='['){
//                    i++;
//                }
//                int count=Integer.parseInt(s.substring(start, i+1));
//                counts.push(count);
//            } else if(c=='['){
//                values.push(cur);
//                cur="";
//            } else if(c==']'){
//                String temp="";
//                int count=counts.pop();
//                while(count-->0){
//                    temp+=cur;
//                }
//                if(values.isEmpty()){
//                    cur=temp;
//                } else {
//                    cur=values.pop()+temp;
//                }
//            } else{
//                cur+=c;
//            }
//        }
//        return cur;
//    }
}
