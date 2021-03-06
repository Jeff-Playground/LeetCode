package com.wen.FourthFifty;

import java.util.LinkedList;
import java.util.Queue;

public class LQReadNCharactersGivenRead4IICallMultipleTimes {
    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

    private int read4(char[] buffer) {
        return 0;
    }

//    private Queue<Character> queue=new LinkedList<>();
//    private boolean eof=false;
//
//    public int read(char[] buf, int n) {
//        if(n==0){
//            return 0;
//        }
//        int charRead=0;
//        char[] buffer=new char[4];
//        while(queue.size()<n && !eof){
//            int size=read4(buffer);
//            if(size<4){
//                eof=true;
//            }
//            for(int i=0; i<size; i++){
//                queue.offer(buffer[i]);
//            }
//        }
//        int length=Math.min(n, queue.size());
//        for(int i=0; i<length; i++){
//            buf[i]=queue.poll();
//            charRead++;
//        }
//        return charRead;
//    }


    char[] buffer = new char[4];
    int head = 0, tail = 0;

    public int read(char[] buf, int n) {
        // Write your code here
        int i = 0;
        while (i < n) {
            if (head == tail) {               // queue is empty
                head = 0;
                tail = read4(buffer);         // enqueue
                if (tail == 0) {
                    break;
                }
            }
            while (i < n && head < tail) {
                buf[i++] = buffer[head++];    // dequeue
            }
        }
        return i;
    }
}
