package com.wen.ThirteenthFifty;

public class DesignCircularQueue {
    // Note the logic for resetting start/end when empty
    class MyCircularQueue {
        int[] data;
        int start, end, size;

        public MyCircularQueue(int k) {
            data=new int[k];
            start=-1;
            end=0;
            size=k;
        }

        public boolean enQueue(int value) {
            if(isFull()){
                return false;
            } else{
                if(start==-1){
                    start=0;
                }
                data[end]=value;
                end=(end+1)%size;
                return true;
            }
        }

        public boolean deQueue() {
            if(isEmpty()){
                return false;
            } else{
                start=(start+1)%size;
                if(start==end){
                    start=-1;
                    end=0;
                }
                return true;
            }
        }

        public int Front() {
            if(isEmpty()){
                return -1;
            } else{
                return data[start];
            }
        }

        public int Rear() {
            if(isEmpty()){
                return -1;
            } else{
                return data[(end-1+size)%size];
            }
        }

        public boolean isEmpty() {
            return start==-1;
        }

        public boolean isFull() {
            return start==end;
        }
    }

//    // Added a new variable count to simplify the logic
//    class MyCircularQueue {
//        int[] data;
//        int start, end, size, count;
//
//        public MyCircularQueue(int k) {
//            data=new int[k];
//            start=0;
//            end=0;
//            size=k;
//            count=0;
//        }
//
//        public boolean enQueue(int value) {
//            if(isFull()){
//                return false;
//            } else{
//                data[end]=value;
//                end=(end+1)%size;
//                count++;
//                return true;
//            }
//        }
//
//        public boolean deQueue() {
//            if(isEmpty()){
//                return false;
//            } else{
//                start=(start+1)%size;
//                count--;
//                return true;
//            }
//        }
//
//        public int Front() {
//            if(isEmpty()){
//                return -1;
//            } else{
//                return data[start];
//            }
//        }
//
//        public int Rear() {
//            if(isEmpty()){
//                return -1;
//            } else{
//                return data[(end-1+size)%size];
//            }
//        }
//
//        public boolean isEmpty() {
//            return this.count==0;
//        }
//
//        public boolean isFull() {
//            return this.size==this.count;
//        }
//    }
}
