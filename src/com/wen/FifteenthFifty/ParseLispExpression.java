package com.wen.FifteenthFifty;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParseLispExpression {
    public int evaluate(String expression) {
        return calculate(expression, new HashMap<>());
    }

    private int calculate(String s, Map<String, Integer> values){
        int l=s.length();
        if(s.startsWith("let")){
            Stack<Pair<String, Integer>> stack=new Stack<>();
            StringBuilder var=new StringBuilder();
            int i=4, last=4;
            boolean odd=true;
            int count=0;
            while(i<l){
                char c=s.charAt(i++);
                if(c==' ' && count==0){
                    if(odd){
                        var.append(s.substring(last, i-1));
                    } else{
                        if(values.containsKey(var.toString())){
                            stack.push(new Pair<>(var.toString(), values.get(var.toString())));
                        }
                        values.put(var.toString(), calculate(s.substring(last, i-1), values));
                        var.setLength(0);
                    }
                    odd=!odd;
                    last=i;
                } else if(c=='('){
                    count++;
                } else if(c==')'){
                    count--;
                }
            }
            int result=calculate(s.substring(last), values);
            while(!stack.isEmpty()){
                Pair<String, Integer> cur=stack.pop();
                values.put(cur.getKey(), cur.getValue());
            }
            return result;
        } else if(s.startsWith("add")){
            int count=0, i=4;
            while(i<l){
                char c=s.charAt(i++);
                if(c==' ' && count==0){
                    break;
                } else if(c=='('){
                    count++;
                } else if(c==')'){
                    count--;
                }
            }
            return calculate(s.substring(4, i-1), values)+calculate(s.substring(i), values);
        } else if(s.startsWith("mult")){
            int count=0, i=5;
            while(i<l){
                char c=s.charAt(i++);
                if(c==' ' && count==0){
                    break;
                } else if(c=='('){
                    count++;
                } else if(c==')'){
                    count--;
                }
            }
            return calculate(s.substring(5, i-1), values)*calculate(s.substring(i), values);
        } else if(s.startsWith("(")){
            return calculate(s.substring(1, l-1), values);
        } else if(isNumber(s)){
            return Integer.valueOf(s);
        } else{
            return values.get(s);
        }
    }

    private boolean isNumber(String s){
        for(char c: s.toCharArray()){
            if((c<'0' || c>'9') && c!='-'){
                return false;
            }
        }
        return true;
    }
}
