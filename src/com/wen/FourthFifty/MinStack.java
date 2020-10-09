package com.wen.FourthFifty;

import java.util.Stack;

public class MinStack {
    // One stack and one int, the previous minimum value is pushed into stack before the actual value, so the previous
    // minimum value is not lost
    private Stack<Integer> stack=new Stack<>();
    private int min=Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int x) {
        if(x<=min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop()==min){
            min=stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

//    // Two stacks
//    private Stack<Integer> stack=new Stack<>();
//    private Stack<Integer> min=new Stack<>();
//
//    public MinStack() {
//
//    }
//
//    public void push(int x) {
//        stack.push(x);
//        if(min.isEmpty() || min.peek()>=x){
//            min.push(x);
//        }
//    }
//
//    public void pop() {
//        int x=stack.pop();
//        if(min.peek()==x){
//            min.pop();
//        }
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return min.peek();
//    }
}
