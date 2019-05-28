package com.wen.FourteenthFifty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] ops) {
        Set<String> set=new HashSet<>(Arrays.asList("+","D","C"));
        Stack<Integer> stack=new Stack<>();
        for(String op: ops){
            if(!set.contains(op)){
                stack.push(Integer.parseInt(op));
            } else{
                if(op.equals("C")){
                    stack.pop();
                } else if(op.equals("D")){
                    stack.push(stack.peek()*2);
                } else{
                    int first=stack.pop();
                    int second=stack.pop();
                    stack.push(second);
                    stack.push(first);
                    stack.push(first+second);
                }
            }
        }
        int result=0;
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
}
