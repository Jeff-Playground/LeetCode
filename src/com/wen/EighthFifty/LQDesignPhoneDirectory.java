package com.wen.EighthFifty;

public class LQDesignPhoneDirectory {
    class PhoneDirectory{
        int[] available;
        int[] recycled;
        int maxNum, next, rcIdx;

        public PhoneDirectory(int maxNum){
            this.maxNum=maxNum;
            next=0;
            rcIdx=-1;
            available=new int[maxNum];
            recycled=new int[maxNum];
        }

        public int get(){
            if(next==maxNum && rcIdx<0){
                return -1;
            }
            if(rcIdx>=0){
                available[recycled[rcIdx]]=0;
                int num=recycled[rcIdx--];
                return num;
            }
            available[next]=0;
            return next++;
        }

        public boolean check(int num){
            return num>=0 && num<maxNum && available[num]==1;
        }

        public void release(int num){
            if(num>=0 && num<maxNum && available[num]==0){
                available[num]=1;
                recycled[++rcIdx]=num;
            }
        }
    }
}
