package com.wen.FifteenthFifty;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class NumberOfAtoms {
    // Iterative
    public String countOfAtoms(String formula) {
        int l=formula.length();
        Stack<int[]> range=new Stack<>();
        Stack<Map<String, Integer>> cache=new Stack<>();
        range.push(new int[]{0,l-1});
        cache.push(new HashMap<>());
        while(!range.isEmpty()){
            int[] cur=range.pop();
            Map<String, Integer> curResult=cache.peek();
            int start=cur[0], end=cur[1];
            for(int i=start; i<=end; i++){
                char c=formula.charAt(i);
                if(isUpperCaseChar(c)){
                    StringBuilder name=new StringBuilder(""+c);
                    int t=i+1;
                    while(t<=end && isLowerCaseChar(formula.charAt(t))){
                        name.append(formula.charAt(t++));
                    }
                    int count=1;
                    if(t<=end && isNumberChar(formula.charAt(t))){
                        StringBuilder tmp=new StringBuilder();
                        while(t<=end && isNumberChar(formula.charAt(t))){
                            tmp.append(formula.charAt(t++));
                        }
                        count=Integer.valueOf(tmp.toString());
                    }
                    String key=name.toString();
                    curResult.put(key, curResult.getOrDefault(key, 0)+count);
                    i=t-1;
                } else if(isNumberChar(c)){
                    StringBuilder tmp=new StringBuilder(""+c);
                    int t=i+1;
                    while(t<=end && isNumberChar(formula.charAt(t))){
                        tmp.append(formula.charAt(t++));
                    }
                    int count=Integer.valueOf(tmp.toString());
                    Map<String, Integer> lastResult=cache.pop();
                    curResult=cache.peek();
                    for(String key: lastResult.keySet()){
                        curResult.put(key, curResult.getOrDefault(key, 0)+lastResult.get(key)*count);
                    }
                    i=t-1;
                } else{
                    int count=1, t=i+1;
                    while(t<=end && count>0){
                        if(formula.charAt(t)=='('){
                            count++;
                        } else if(formula.charAt(t)==')'){
                            count--;
                        }
                        t++;
                    }
                    cur[0]=t;
                    range.push(new int[]{t, end});
                    range.push(new int[]{i+1, t-2});
                    cache.push(new HashMap<>());
                    break;
                }
            }
        }
        StringBuilder result=new StringBuilder();
        TreeMap<String, Integer> finalResult=new TreeMap<>();
        while(!cache.isEmpty()){
            Map<String, Integer> cur=cache.pop();
            for(String key: cur.keySet()){
                finalResult.put(key, finalResult.getOrDefault(key, 0)+cur.get(key));
            }
        }
        for(String key: finalResult.keySet()){
            result.append(key);
            if(finalResult.get(key)>1){
                result.append(finalResult.get(key));
            }
        }
        return result.toString();
    }

//    // Recursive
//    public String countOfAtoms(String formula) {
//        TreeMap<String, Integer> result=count(formula, 0, formula.length()-1);
//        StringBuilder sb=new StringBuilder();
//        for(String key: result.keySet()){
//            sb.append(key+(result.get(key)>1?result.get(key):""));
//        }
//        return sb.toString();
//    }
//
//    private TreeMap<String, Integer> count(String formula, int start, int end){
//        TreeMap<String, Integer> result=new TreeMap<>();
//        int l=formula.length();
//        for(int i=start; i<=end; i++){
//            char c=formula.charAt(i);
//            if(isUpperCaseChar(c)){
//                StringBuilder sb=new StringBuilder();
//                sb.append(c);
//                i++;
//                if(i<=end && isLowerCaseChar(formula.charAt(i))){
//                    while(i<=end && isLowerCaseChar(formula.charAt(i))){
//                        sb.append(formula.charAt(i++));
//                    }
//                }
//                String key=sb.toString();
//                sb.setLength(0);
//                int count=1;
//                while(i<=end && isNumberChar(formula.charAt(i))){
//                    sb.append(formula.charAt(i++));
//                }
//                if(sb.length()>0){
//                    count=Integer.valueOf(sb.toString());
//                }
//                result.put(key, result.getOrDefault(key, 0)+count);
//                i-=1;
//            } else{
//                int count=1;
//                int t=i+1;
//                while(count>0){
//                    if(formula.charAt(t)=='('){
//                        count++;
//                    } else if(formula.charAt(t)==')'){
//                        count--;
//                    }
//                    t++;
//                }
//                TreeMap<String, Integer> cur=count(formula, i+1, t-2);
//                if(t<=end && isNumberChar(formula.charAt(t))){
//                    StringBuilder sb=new StringBuilder();
//                    while(t<=end && isNumberChar(formula.charAt(t))){
//                        sb.append(formula.charAt(t++));
//                    }
//                    count=Integer.valueOf(sb.toString());
//                } else{
//                    count=1;
//                }
//                for(String key: cur.keySet()){
//                    result.put(key, result.getOrDefault(key, 0)+cur.get(key)*count);
//                }
//                i=t-1;
//            }
//        }
//        return result;
//    }

    private boolean isNumberChar(char c){
        return c>='0' && c<='9';
    }

    private boolean isUpperCaseChar(char c){
        return c>='A' && c<='Z';
    }

    private boolean isLowerCaseChar(char c){
        return c>='a' && c<='z';
    }
}
