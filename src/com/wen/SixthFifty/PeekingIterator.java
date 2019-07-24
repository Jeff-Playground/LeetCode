package com.wen.SixthFifty;

import java.util.Iterator;

public class PeekingIterator {
    class PeekingIteratorDesign implements Iterator<Integer> {
        Iterator<Integer> iterator;
        Integer cur=null;

        public PeekingIteratorDesign(Iterator<Integer> iterator) {
            this.iterator=iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if(cur==null){
                cur=iterator.next();
            }
            return cur;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if(cur==null){
                return iterator.next();
            } else{
                Integer result=cur;
                cur=null;
                return result;
            }
        }

        @Override
        public boolean hasNext() {
            return cur!=null || iterator.hasNext();
        }
    }
}
