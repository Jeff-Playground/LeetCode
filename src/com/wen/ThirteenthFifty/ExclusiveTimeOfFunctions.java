package com.wen.ThirteenthFifty;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result=new int[n];
        Stack<Integer> stack=new Stack<>();
        int lastTs=-1;
        for(String s: logs){
            String[] splited=s.split(":");
            int id=Integer.valueOf(splited[0]);
            String status=splited[1];
            // Skew the end ts so both start and end are pointing to the start of a frame
            int ts=Integer.valueOf(splited[2])+(status.equals("start")?0:1);
            if(status.equals("start")){
                if(!stack.isEmpty()){
                    int lastId=stack.peek();
                    result[lastId]+=ts-lastTs;
                }
                stack.push(id);
            } else{
                stack.pop();
                result[id]+=ts-lastTs;
            }
            lastTs=ts;
        }
        return result;
    }
}
