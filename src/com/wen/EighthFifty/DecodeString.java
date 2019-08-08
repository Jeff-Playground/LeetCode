package com.wen.EighthFifty;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        int[] idx=new int[] {0};
        return decodeStringHelper(s, idx);
    }

    private String decodeStringHelper(String s, int[] idx) {
        int count=-1;
        String result="", cur="";
        int numCount=0;
        while(idx[0]<s.length()) {
            char c=s.charAt(idx[0]);
            if(c>='0' && c<='9') {
                if(numCount==0) {
                    result+=cur;
                    cur="";
                    int i=idx[0];
                    while(s.charAt(i+1)!='[') {
                        i++;
                    }
                    count=Integer.parseInt(s.substring(idx[0], i+1));
                    idx[0]=i+1;
                    numCount++;
                } else {
                    cur+=decodeStringHelper(s, idx);
                }
            } else if(c=='[') {
                idx[0]++;
            } else if(c==']'){
                if(numCount==0) {
                    break;
                } else {
                    while(count-->0) {
                        result+=cur;
                    }
                    idx[0]++;
                    cur="";
                    numCount--;
                }
            } else {
                cur+=c;
                idx[0]++;
            }
        }
        return result+cur;
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
