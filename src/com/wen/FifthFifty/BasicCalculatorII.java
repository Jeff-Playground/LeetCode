package com.wen.FifthFifty;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        int l=s.length();
        int result=0;
        Stack<Integer> stack=new Stack<>();
        int val=0, add=1;
        boolean calculate=false;
        char sign='*';
        for(int i=0; i<=l; i++) {
            char c=i<l?s.charAt(i):'$';
            if(c>='0' && c<='9') {
                val=val*10+(c-'0');
            } else if(c=='+' || c=='-' || c=='*' || c=='/' || c=='$') {
                stack.push(val);
                val=0;
                if(calculate) {
                    int num2=stack.pop(), num1=stack.pop();
                    if(sign=='*') {
                        stack.push(num1*num2);
                    } else {
                        stack.push(num1/num2);
                    }
                    calculate=false;
                }
                if(c=='+' || c=='-') {
                    add=c=='+'?1:-1;
                    stack.push(add);
                } else if(c=='*' || c=='/') {
                    calculate=true;
                    sign=c;
                }
            }
        }
        while(!stack.isEmpty()) {
            int num=stack.pop();
            if(!stack.isEmpty()) {
                num*=stack.pop();
            }
            result+=num;
        }
        return result;
    }

//    public int calculate(String s) {
//        int l=s.length();
//        int val=0, result=0, curResult=0;
//        char op='+';
//        for(int i=0; i<=l; i++) {
//            char c=i<l?s.charAt(i):'$';
//            if(c>='0' && c<='9') {
//                val=val*10+(c-'0');
//            } else if(c=='+' || c=='-' || c=='*' || c=='/' || c=='$') {
//                if(op=='+') {
//                    curResult+=val;
//                } else if(op=='-') {
//                    curResult-=val;
//                } else if(op=='*') {
//                    curResult*=val;
//                } else if(op=='/') {
//                    curResult/=val;
//                }
//                if(c=='+' || c=='-' || c=='$') {
//                    result+=curResult;
//                    curResult=0;
//                }
//                val=0;
//                op=c;
//            }
//        }
//        return result;
//    }
}
