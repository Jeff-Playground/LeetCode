package com.wen.TwentyFirstFifty;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        Stack<Character> stack=new Stack<>();
        for(char c: S.toCharArray()){
            if(stack.isEmpty() || c!=stack.peek()){
                stack.push(c);
            } else{
                stack.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
