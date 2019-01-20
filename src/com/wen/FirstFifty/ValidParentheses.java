package com.wen.FirstFifty;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Map<Character, Character> map=new HashMap<Character, Character>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        Stack<Character> stack=new Stack<Character>();
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                if(stack.size()>0 && stack.lastElement().equals(map.get(c))){
                    stack.pop();
                } else{
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        if(stack.size()==0){
            return true;
        }else{
            return false;
        }
    }
}
