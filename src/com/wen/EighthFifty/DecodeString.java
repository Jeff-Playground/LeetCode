package com.wen.EighthFifty;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        Stack<Integer> counts=new Stack<>();
        Stack<String> values=new Stack<>();
        String cur="";
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
                values.push(cur);
                cur="";
            } else if(c==']'){
                String temp="";
                int count=counts.pop();
                while(count-->0){
                    temp+=cur;
                }
                if(values.isEmpty()){
                    cur=temp;
                } else {
                    cur=values.pop()+temp;
                }
            } else{
                cur+=c;
            }
        }
        return cur;
    }
}
