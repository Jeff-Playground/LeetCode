package com.wen.EighthFifty;

/*
Design a Phone Directory which supports the following operations:
1. get: Provide a number which is not assigned to anyone.
2. check: Check if a number is available or not.
3. release: Recycle or release a number.

Example:

// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2);
 */

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
