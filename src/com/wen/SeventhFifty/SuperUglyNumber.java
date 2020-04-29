package com.wen.SeventhFifty;

import java.util.PriorityQueue;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k=primes.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->a-b);
        pq.offer(1);
        int count=0, cur=-1, last=-1;
        while(count<n){
            cur=pq.poll();
            if(cur!=last){
                last=cur;
                count++;
                for(int p:primes){
                    if((long)cur*p<=Integer.MAX_VALUE){
                        pq.offer(cur*p);
                    }
                }
            }
        }
        return cur;
    }
}
