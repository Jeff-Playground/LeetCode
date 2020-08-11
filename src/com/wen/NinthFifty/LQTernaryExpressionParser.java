package com.wen.NinthFifty;

import java.util.Stack;

public class LQTernaryExpressionParser {
    public String parseTernary(String expression) {
        int l=expression.length();
        Stack<Character> stack=new Stack<>();
        for(int i=l-1; i>=0; i--){
            char c=expression.charAt(i);
            if(!stack.isEmpty() && stack.peek()=='?'){
                stack.pop();
                char first=stack.pop();
                stack.pop();
                char second=stack.pop();
                stack.push(c=='T'?first:second);
            } else{
                stack.push(c);
            }
        }
        return ""+stack.peek();
    }

//    public String parseTernary(String expression) {
//        int l=expression.length();
//        return parseTernary(expression, 0, l-1);
//    }
//
//    private String parseTernary(String exp, int start, int end){
//        if(end-start+1<5){
//            return exp.substring(start, end+1);
//        } else{
//            int idx=start+3, count=0;
//            while(idx<=end){
//                if(exp.charAt(idx)=='?'){
//                    count--;
//                } else if(exp.charAt(idx)==':'){
//                    count++;
//                }
//                if(count==1){
//                    break;
//                }
//                idx++;
//            }
//            if(exp.charAt(start)=='T'){
//                return parseTernary(exp, start+2, idx-1);
//            } else{
//                return parseTernary(exp, idx+1, end);
//            }
//        }
//    }
}
