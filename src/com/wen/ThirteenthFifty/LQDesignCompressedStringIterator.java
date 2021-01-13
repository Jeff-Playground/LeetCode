package com.wen.ThirteenthFifty;

/*

Design and implement a data structure for a compressed string iterator. It should support the following operations: next
and hasNext.

The given compressed string will be in the form of each letter followed by a positive integer representing the number of
this letter existing in the original uncompressed string.

next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
hasNext() - Judge whether there is any letter needs to be uncompressed.

Note:
Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across
multiple test cases. Please see here for more details.

Example:
StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
iterator.next(); // return 'L'
iterator.next(); // return 'e'
iterator.next(); // return 'e'
iterator.next(); // return 't'
iterator.next(); // return 'C'
iterator.next(); // return 'o'
iterator.next(); // return 'd'
iterator.hasNext(); // return true
iterator.next(); // return 'e'
iterator.hasNext(); // return false
iterator.next(); // return ' '

 */

import java.util.LinkedList;
import java.util.Queue;

public class LQDesignCompressedStringIterator {
    // Use a Queue2
    class  StringIterator{
        private Queue<Character> q;

        public StringIterator(String compressedString){
            int idx=0;
            q=new LinkedList<>();
            while(idx<compressedString.length()){
                char c=compressedString.charAt(idx++);
                int count=0;
                while(compressedString.charAt(idx)>='0' && compressedString.charAt(idx)<='9'){
                    count=count*10+compressedString.charAt(idx++)-'0';
                }
                while(count-->0){
                    q.offer(c);
                }
            }
        }

        public char next(){
            if(hasNext()){
                return q.poll();
            } else{
                return ' ';
            }
        }

        public boolean hasNext(){
            return !q.isEmpty();
        }
    }

//    // Use a Queue
//    class  StringIterator{
//        private Queue<String> q;
//        char c;
//        int count=-1;
//
//        public StringIterator(String compressedString){
//            int idx=0;
//            q=new LinkedList<>();
//            while(idx<compressedString.length()){
//                q.offer(compressedString.charAt(idx++)+"");
//                StringBuilder count=new StringBuilder();
//                while(compressedString.charAt(idx)>='0' && compressedString.charAt(idx)<='9'){
//                    count.append(compressedString.charAt(idx++));
//                }
//                q.offer(count.toString());
//            }
//        }
//
//        public char next(){
//            if(hasNext()){
//                count--;
//                return c;
//            } else{
//                return ' ';
//            }
//        }
//
//        public boolean hasNext(){
//            if(count>0){
//                return true;
//            } else{
//                if(q.isEmpty()){
//                    return false;
//                } else{
//                    c=q.poll().charAt(0);
//                    count=Integer.valueOf(q.poll());
//                    return true;
//                }
//            }
//        }
//    }

//    // Maintain count and idx to track status
//    class StringIterator{
//        public int length=-1;
//        public int idx=-1;
//        public int count=-1;
//        public String compressedString="";
//        public char c=' ';
//
//        public StringIterator(String compressedString){
//            this.compressedString=compressedString;
//            this.length=compressedString.length();
//            this.idx=0;
//            this.count=0;
//            this.c=' ';
//        }
//
//        public char next(){
//            if(hasNext()){
//                count--;
//                return c;
//            } else{
//                return ' ';
//            }
//        }
//
//        public boolean hasNext(){
//            if(count>0){
//                return true;
//            } else{
//                if(length>0 && idx<length){
//                    c=compressedString.charAt(idx++);
//                    while(compressedString.charAt(idx)>='0' && compressedString.charAt(idx)<='9'){
//                        count=count*10+compressedString.charAt(idx++)-'0';
//                    }
//                    return true;
//                } else{
//                    return false;
//                }
//            }
//        }
//    }
}
