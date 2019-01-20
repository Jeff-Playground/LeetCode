package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        // Stack
        Stack<String> simplifiedComponents=new Stack<String>();
        String[] components=path.split("/");
        for(String component: components){
            if(!simplifiedComponents.isEmpty() && component.equals("..")){
                simplifiedComponents.pop();
            } else if(!component.equals(".") && !component.equals("") && !component.equals("..")){
                simplifiedComponents.push(component);
            }
        }
        List<String> list=new ArrayList<String>(simplifiedComponents);
        return "/"+String.join("/", list);
    }
}
