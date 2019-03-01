package com.wen.ThirdFifty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    // Recursive
    public static int evalRPN(String[] tokens) {
        int[] maxIndex={tokens.length-1};
        return evalRPNHelper(tokens, maxIndex);
    }

    private static int evalRPNHelper(String[] tokens, int[] index) {
        String token=tokens[index[0]];
        if(!Arrays.asList("+","-","*","/").contains(token)){
            return Integer.parseInt(token);
        }
        index[0]--;
        int num2=evalRPNHelper(tokens, index);
        index[0]--;
        int num1=evalRPNHelper(tokens, index);
        if(token.equals("+")){
            return num1+num2;
        } else if(token.equals("-")){
            return num1-num2;
        } else if(token.equals("*")){
            return num1*num2;
        } else{
            return num1/num2;
        }
    }

//    // Iterative with Stack
//    public static int evalRPN(String[] tokens) {
//        Stack<Integer> stack=new Stack<>();
//        Set<String> operators=new HashSet<>(Arrays.asList("+","-","*","/"));
//        int i=0;
//        while(i<tokens.length){
//            if(operators.contains(tokens[i])){
//                int num2=stack.pop(), num1=stack.pop();
//                if(tokens[i].equals("+")){
//                    stack.push(num1+num2);
//                } else if(tokens[i].equals("-")){
//                    stack.push(num1-num2);
//                } else if(tokens[i].equals("*")){
//                    stack.push(num1*num2);
//                } else{
//                    stack.push(num1/num2);
//                }
//            } else{
//                stack.push(Integer.parseInt(tokens[i]));
//            }
//            i++;
//        }
//        return stack.pop();
//    }
}
