package com.wen.FifteenthFifty;

import java.util.*;

public class LQMaxStack {
    // Use a Stack and a TreeMap, both stores the idx of the values, and use an additional HashMap to store the idx
    // value mapping info. This supports O(1) for each top call and O(logn) for each other call
    public static class MaxStack {
        Map<Integer, Integer> vMap;
        int key;
        Stack<Integer> value;
        TreeMap<Integer, List<Integer>> sorted;

        public MaxStack() {
            vMap=new HashMap<>();
            key=1;
            value=new Stack<>();
            sorted=new TreeMap<>();
        }

        public void push(int x) {
            value.push(key);
            vMap.put(key, x);
            sorted.putIfAbsent(x, new ArrayList<>());
            sorted.get(x).add(key++);
        }

        public int pop() {
            int remove=value.pop();
            while(!value.isEmpty() && !vMap.containsKey(value.peek())){
                value.pop();
            }
            int x=vMap.remove(remove);
            if(sorted.get(x).size()==1){
                sorted.remove(x);
            } else{
                sorted.get(x).remove(sorted.get(x).size()-1);
            }
            return x;
        }

        public int top() {
            return vMap.get(value.peek());
        }

        public int peekMax() {
            return sorted.lastKey();
        }

        public int popMax() {
            int x=sorted.lastKey();
            int remove=sorted.get(x).get(sorted.get(x).size()-1);
            if(sorted.get(x).size()==1){
                sorted.remove(x);
            } else{
                sorted.get(x).remove(sorted.get(x).size()-1);
            }
            if(value.peek()==remove){
                value.pop();
                while(!value.isEmpty() && !vMap.containsKey(value.peek())){
                    value.pop();
                }
            }
            vMap.remove(remove);
            return x;
        }
    }

//    // Use 2 Stacks, note how popMax updates the new max using a tmp Stack and push
//    class MaxStack {
//        Stack<Integer> value, max;
//
//        public MaxStack() {
//            value=new Stack<>();
//            max=new Stack<>();
//        }
//
//        public void push(int x) {
//            value.push(x);
//            if(max.isEmpty() || x>=max.peek()){
//                max.push(x);
//            }
//        }
//
//        public int pop() {
//            int v=value.pop();
//            if(v==max.peek()){
//                max.pop();
//            }
//            return v;
//        }
//
//        public int top() {
//            return value.peek();
//        }
//
//        public int peekMax() {
//            return max.peek();
//        }
//
//        public int popMax() {
//            int v=max.pop();
//            Stack<Integer> tmp=new Stack<>();
//            while(value.peek()!=v){
//                tmp.push(value.pop());
//            }
//            value.pop();
//            while(!tmp.isEmpty()){
//                push(tmp.pop());
//            }
//            return v;
//        }
//    }
}
