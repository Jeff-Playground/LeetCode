package com.wen.ThirteenthFifty;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] result=new int[n];
        Stack<Integer> stack=new Stack<>();
        int lts=-1;
        for(String log: logs){
            String[] splited=log.split(":");
            int id=Integer.valueOf(splited[0]);
            String state=splited[1];
            int ts=Integer.valueOf(splited[2]);
            if(state.equals("start")){
                if(!stack.isEmpty()){
                    int last=stack.peek();
                    if(lts<ts){
                        result[last]+=ts-lts;
                    }
                }
                stack.push(id);
            } else{
                stack.pop();
                result[id]+=1;
                result[id]+=ts-lts+1;
            }
            lts=ts+1;
        }
        return result;
    }
}
