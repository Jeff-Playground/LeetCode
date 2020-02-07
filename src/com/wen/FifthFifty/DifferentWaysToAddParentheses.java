package com.wen.FifthFifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {
    // Optimised to use Map to prevent duplicated calculations
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result=new ArrayList<>();
        if(input==null || input.length()==0){
            return result;
        } else{
            Map<String, List<Integer>> map=new HashMap<>();
            return diffWaysToComputeDFS(input, map);
        }
    }

    public List<Integer> diffWaysToComputeDFS(String input, Map<String, List<Integer>> map) {
        if(map.containsKey(input)){
            return map.get(input);
        }
        List<Integer> result=new ArrayList<>();
        int l=input.length();
        for(int i=0; i<l; i++){
            char c=input.charAt(i);
            if(c=='+' || c=='-' || c=='*'){
                List<Integer> leftResults=diffWaysToComputeDFS(input.substring(0, i), map);
                List<Integer> rightResults=diffWaysToComputeDFS(input.substring(i+1), map);
                for(int left: leftResults){
                    for(int right: rightResults){
                        if(c=='+'){
                            result.add(left+right);
                        } else if(c=='-'){
                            result.add(left-right);
                        } else if(c=='*'){
                            result.add(left*right);
                        }
                    }
                }
            }
        }
        if(result.size()==0){
            result.add(Integer.parseInt(input));
        }
        map.put(input, result);
        return result;
    }
}
