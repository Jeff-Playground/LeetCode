package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] splited=path.split("/");
        Stack<String> stack=new Stack<>();
        for(String s: splited){
            if(!s.isEmpty()){
                if(s.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                } else if(s.equals(".")){
                    continue;
                } else{
                    stack.push(s);
                }
            }
        }
        String result="";
        while(!stack.isEmpty()){
            result="/"+stack.pop()+result;
        }
        return result.isEmpty()?"/":result;
    }
}
