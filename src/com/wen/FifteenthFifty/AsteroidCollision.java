package com.wen.FifteenthFifty;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids==null || asteroids.length==0){
            return new int[]{};
        }
        Stack<Integer> stack=new Stack<>();
        for(int a: asteroids){
            if(stack.isEmpty() || stack.peek()*a>0){
                stack.push(a);
            } else{
                while(a<0 && !stack.isEmpty() && stack.peek()>0){
                    int p=stack.pop();
                    a=p+a==0?0:(p+a>0?p:a);
                }
                if(a!=0){
                    stack.push(a);
                }
            }
        }
        int l=stack.size();
        int[] result=new int[l];
        for(int i=l-1; i>=0; i--){
            result[i]=stack.pop();
        }
        return result;
    }
}
