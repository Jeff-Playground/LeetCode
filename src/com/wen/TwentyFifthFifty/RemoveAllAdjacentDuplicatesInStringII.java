package com.wen.TwentyFifthFifty;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack=new Stack<>();
        for(char c: s.toCharArray()){
            if(stack.isEmpty() || stack.peek().c!=c){
                stack.push(new Pair(c, 1));
            } else{
                if(stack.peek().count==k-1){
                    stack.pop();
                } else{
                    stack.peek().count+=1;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            Pair cur=stack.pop();
            while(cur.count-->0){
                sb.append(cur.c);
            }
        }
        return sb.reverse().toString();
    }

    class Pair{
        char c;
        int count;
        public Pair(char c, int count){
            this.c=c;
            this.count=count;
        }
    }
}
