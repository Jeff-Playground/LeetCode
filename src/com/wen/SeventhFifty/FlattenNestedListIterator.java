package com.wen.SeventhFifty;

import java.util.*;

public class FlattenNestedListIterator {
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

//    // Flatten into Queue in constructor
//    public class NestedIterator implements Iterator<Integer> {
//        Queue<Integer> q;
//
//        public NestedIterator(List<NestedInteger> nestedList) {
//            q=new LinkedList<>();
//            flattenIntoQueue(nestedList, q);
//        }
//
//        private void flattenIntoQueue(List<NestedInteger> l, Queue<Integer> q){
//            for(int i=0; i<l.size(); i++){
//                if(l.get(i).isInteger()){
//                    q.offer(l.get(i).getInteger());
//                } else{
//                    flattenIntoQueue(l.get(i).getList(), q);
//                }
//            }
//        }
//
//        @Override
//        public Integer next() {
//            return q.poll();
//        }
//
//        @Override
//        public boolean hasNext() {
//            return !q.isEmpty();
//        }
//    }

    // Deque
    public class NestedIterator implements Iterator<Integer> {
        Deque<NestedInteger> dq;

        public NestedIterator(List<NestedInteger> nestedList) {
            dq=new LinkedList<>();
            for(int i=0; i<nestedList.size(); i++){
                dq.offerLast(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            NestedInteger cur=dq.pollFirst();
            return cur.getInteger();
        }

        @Override
        public boolean hasNext() {
            while(!dq.isEmpty()){
                NestedInteger cur=dq.peekFirst();
                if(cur.isInteger()){
                    return true;
                }
                dq.pollFirst();
                for(int i=cur.getList().size()-1; i>=0; i--){
                    dq.offerFirst(cur.getList().get(i));
                }
            }
            return false;
        }
    }

//    //  Stack
//    public class NestedIterator implements Iterator<Integer> {
//        Stack<NestedInteger> stack;
//
//        public NestedIterator(List<NestedInteger> nestedList) {
//            stack=new Stack<>();
//            for(int i=nestedList.size()-1; i>=0; i--){
//                stack.push(nestedList.get(i));
//            }
//        }
//
//        @Override
//        public Integer next() {
//            NestedInteger cur=stack.pop();
//            return cur.getInteger();
//        }
//
//        @Override
//        public boolean hasNext() {
//            while(!stack.isEmpty()){
//                NestedInteger cur=stack.peek();
//                if(cur.isInteger()){
//                    return true;
//                }
//                stack.pop();
//                for(int i=cur.getList().size()-1; i>=0; i--){
//                    stack.push(cur.getList().get(i));
//                }
//            }
//            return false;
//        }
//    }
}
