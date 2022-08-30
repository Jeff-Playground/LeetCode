package com.wen.FifteenthFifty;

import java.util.TreeMap;

public class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> result=count(formula, 0, formula.length()-1);
        StringBuilder sb=new StringBuilder();
        for(String key: result.keySet()){
            sb.append(key+(result.get(key)>1?result.get(key):""));
        }
        return sb.toString();
    }

    private TreeMap<String, Integer> count(String formula, int start, int end){
        TreeMap<String, Integer> result=new TreeMap<>();
        int l=formula.length();
        for(int i=start; i<=end; i++){
            char c=formula.charAt(i);
            if(isUpperCaseChar(c)){
                StringBuilder sb=new StringBuilder();
                sb.append(c);
                i++;
                if(i<=end && isLowerCaseChar(formula.charAt(i))){
                    while(i<=end && isLowerCaseChar(formula.charAt(i))){
                        sb.append(formula.charAt(i++));
                    }
                }
                String key=sb.toString();
                sb.setLength(0);
                int count=1;
                while(i<=end && isNumber(formula.charAt(i))){
                    sb.append(formula.charAt(i++));
                }
                if(sb.length()>0){
                    count=Integer.valueOf(sb.toString());
                }
                result.put(key, result.getOrDefault(key, 0)+count);
                i-=1;
            } else{
                int count=1;
                int t=i+1;
                while(count>0){
                    if(formula.charAt(t)=='('){
                        count++;
                    } else if(formula.charAt(t)==')'){
                        count--;
                    }
                    t++;
                }
                TreeMap<String, Integer> cur=count(formula, i+1, t-2);
                if(t<=end && isNumber(formula.charAt(t))){
                    StringBuilder sb=new StringBuilder();
                    while(t<=end && isNumber(formula.charAt(t))){
                        sb.append(formula.charAt(t++));
                    }
                    count=Integer.valueOf(sb.toString());
                } else{
                    count=1;
                }
                for(String key: cur.keySet()){
                    result.put(key, result.getOrDefault(key, 0)+cur.get(key)*count);
                }
                i=t-1;
            }
        }
        return result;
    }

    private boolean isNumber(char c){
        return c>='0' && c<='9';
    }

    private boolean isUpperCaseChar(char c){
        return c>='A' && c<='Z';
    }

    private boolean isLowerCaseChar(char c){
        return c>='a' && c<='z';
    }
}
