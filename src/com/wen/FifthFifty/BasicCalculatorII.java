package com.wen.FifthFifty;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        int l=s.length();
        int result=0;
        int val=0;
        char preOp='+';
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<=l; i++){
            char c=i<l?s.charAt(i):'$';
            if(c==' '){
                continue;
            }
            if(c>='0' && c<='9'){
                val=val*10+c-'0';
            } else{
                if(preOp=='+'){
                    stack.push(val);
                } else if(preOp=='-'){
                    stack.push(-val);
                } else {
                    int pre=stack.pop();
                    if(preOp=='*'){
                        stack.push(pre*val);
                    } else if(preOp=='/'){
                        stack.push(pre/val);
                    }
                }
                preOp=c;
                val=0;
            }
        }
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }

//    public int calculate(String s) {
//        int l=s.length();
//        int val=0, result=0, curResult=0;
//        char preOp='+';
//        for(int i=0; i<=l; i++) {
//            char c=i<l?s.charAt(i):'$';
//            if(c>='0' && c<='9') {
//                val=val*10+(c-'0');
//            } else if(c=='+' || c=='-' || c=='*' || c=='/' || c=='$') {
//                if(preOp=='+') {
//                    curResult+=val;
//                } else if(preOp=='-') {
//                    curResult-=val;
//                } else if(preOp=='*') {
//                    curResult*=val;
//                } else if(preOp=='/') {
//                    curResult/=val;
//                }
//                if(c=='+' || c=='-' || c=='$') {
//                    result+=curResult;
//                    curResult=0;
//                }
//                val=0;
//                preOp=c;
//            }
//        }
//        return result;
//    }
}
