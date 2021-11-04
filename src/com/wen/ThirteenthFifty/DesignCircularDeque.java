package com.wen.ThirteenthFifty;

public class DesignCircularDeque {
    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     * MyCircularDeque obj = new MyCircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */
    class MyCircularDeque {
        int[] data;
        int start, end, size;
        public MyCircularDeque(int k) {
            start=end=-1;
            size=k;
            data=new int[k];
        }

        public boolean insertFront(int value) {
            if(isFull()){
                return false;
            } else{
                if(isEmpty()){
                    start=end=0;
                } else{
                    start=(start-1+size)%size;
                }
                data[start]=value;
                return true;
            }
        }

        public boolean insertLast(int value) {
            if(isFull()){
                return false;
            } else{
                if(isEmpty()){
                    start=end=0;
                } else{
                    end=(end+1)%size;
                }
                data[end]=value;
                return true;
            }
        }

        public boolean deleteFront() {
            if(isEmpty()){
                return false;
            } else{
                if(start==end){
                    start=end=-1;
                } else{
                    start=(start+1)%size;
                }
                return true;
            }
        }

        public boolean deleteLast() {
            if(isEmpty()){
                return false;
            } else{
                if(start==end){
                    start=end=-1;
                } else{
                    end=(end-1+size)%size;
                }
                return true;
            }
        }

        public int getFront() {
            if(isEmpty()){
                return -1;
            } else{
                return data[start];
            }
        }

        public int getRear() {
            if(isEmpty()){
                return -1;
            } else{
                return data[end];
            }
        }

        public boolean isEmpty() {
            return start==-1;
        }

        public boolean isFull() {
            return start==(end+1)%size;
        }
    }
}
