package com.wen.FifthFifty;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    // One queue, works better when mostly top and pop
    class MyStack {
        Queue<Integer> q;
        /** Initialize your data structure here. */
        public MyStack() {
            q=new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q.offer(x);
            int size=q.size();
            for(int i=1; i<q.size(); i++) {
                q.offer(q.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q.poll();
        }

        /** Get the top element. */
        public int top() {
            return q.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q.isEmpty();
        }
    }

//    // Two queues, works better when mostly push
//    class MyStack {
//        Queue<Integer> top;
//        Queue<Integer> q;
//        /** Initialize your data structure here. */
//        public MyStack() {
//            top=new LinkedList<>();
//            q=new LinkedList<>();
//        }
//
//        /** Push element x onto stack. */
//        public void push(int x) {
//            top.offer(x);
//            if(top.size()>1) {
//                q.offer(top.poll());
//            }
//        }
//
//        /** Removes the element on top of the stack and returns that element. */
//        public int pop() {
//            top();
//            return top.poll();
//        }
//
//        /** Get the top element. */
//        public int top() {
//            if(top.isEmpty()) {
//                for(int i=1; i<q.size(); i++) {
//                    q.offer(q.poll());
//                }
//                top.offer(q.poll());
//            }
//            return top.peek();
//        }
//
//        /** Returns whether the stack is empty. */
//        public boolean empty() {
//            return q.isEmpty() && top.isEmpty();
//        }
//    }
}
