package com.wen.NinthFifty;

import java.util.Stack;

public class RemoveKDigits {
    // Monotonous stack
    public static String removeKdigits(String num, int k) {
        if(k>=num.length()){
            return "0";
        } else{
            Stack<Character> stack=new Stack<>();
            int removed=0, last=-1;
            for(char c: num.toCharArray()){
                while(k>0 && !stack.isEmpty() && stack.peek()>c){
                    stack.pop();
                    k--;
                }
                if(!stack.isEmpty() || c!='0'){
                    stack.push(c);
                }
            }
            while(k>0 && !stack.isEmpty()){
                stack.pop();
                k--;
            }
            String result="";
            while(!stack.isEmpty()){
                result=stack.pop()+result;
            }
            return result.length()>0?result:"0";
        }
    }

//    // Greedy
//    public String removeKdigits(String num, int k) {
//        if(k>=num.length()){
//            return "0";
//        } else{
//            int start=0;
//            StringBuilder result=new StringBuilder();
//            while(k>0 && k<num.length()-start){
//                char min='9'+1;
//                int idx=-1;
//                for(int i=start; i<=start+k; i++){
//                    char c=num.charAt(i);
//                    if(c<min){
//                        min=c;
//                        idx=i;
//                    }
//                }
//                k-=idx-start;
//                if(result.length()>0 || min!='0'){
//                    result.append(min);
//                }
//                start=idx+1;
//            }
//            if(k==0 && start<num.length()){
//                result.append(num.substring(start));
//            }
//            return result.length()>0?result.toString():"0";
//        }
//    }
}
