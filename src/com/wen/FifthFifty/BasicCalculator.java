package com.wen.FifthFifty;

import java.util.Stack;

public class BasicCalculator {
    public static int calculate(String s) {
        int l=s.length();
        int result=0;
        int val=0, sign=1;
        for(int i=0; i<=l; i++) {
            char c=i<l?s.charAt(i):'$';
            if(c>='0' && c<='9') {
                val=val*10+(c-'0');
            } else if(c=='+' || c=='-' || c=='(' || c==')' || c=='$'){
                result+=val*sign;
                val=0;
                if(c=='(') {
                    int count=1;
                    for(int j=i+1; j<l; j++) {
                        char cj=s.charAt(j);
                        if(cj=='(') {
                            count++;
                        } else if(cj==')') {
                            count--;
                        }
                        if(count==0) {
                            val=calculate(s.substring(i+1, j));
                            result+=val*sign;
                            val=0;
                            sign=1;
                            i=j;
                            break;
                        }
                    }
                } else if(c=='+' || c=='-') {
                    sign=c=='+'?1:-1;
                }
            }
        }
        return result;
    }

//    public int calculate(String s) {
//        int l=s.length();
//        Stack<Integer> stack=new Stack<>();
//        int sign=1, val=0;
//        int result=0;
//        for(int i=0; i<=l; i++) {
//            char c=i<l?s.charAt(i):'$';
//            if(c>='0' && c<='9') {
//                val=val*10+(c-'0');
//            } else if(c=='+' || c=='-' || c=='(' || c==')' || c=='$'){
//                result+=val*sign;
//                val=0;
//                if(c=='+' || c=='-') {
//                    sign=c=='+'?1:-1;
//                } else if(c=='(') {
//                    stack.push(result);
//                    stack.push(sign);
//                    result=0;
//                    sign=1;
//                } else if(c==')') {
//                    sign=stack.pop();
//                    result=stack.pop()+sign*result;
//                }
//            }
//        }
//        return result;
//    }
}
