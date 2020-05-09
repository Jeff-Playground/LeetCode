package com.wen.SeventhFifty;

import java.util.PriorityQueue;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int l=primes.length, cur=1;
        int[] idx=new int[l], ugly=new int[n];
        ugly[0]=1;
        while(cur<n){
            int min=Integer.MAX_VALUE, index=-1;
            for(int i=0; i<l; i++){
                if(primes[i]*ugly[idx[i]]<min){
                    min=primes[i]*ugly[idx[i]];
                    index=i;
                }
            }
            if(min!=ugly[cur-1]){
                ugly[cur++]=min;
            }
            idx[index]++;
        }
        return ugly[n-1];
    }

//    // Heap
//    public int nthSuperUglyNumber(int n, int[] primes) {
//        int k=primes.length;
//        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->a-b);
//        pq.offer(1);
//        int count=0, cur=-1, last=-1;
//        while(count<n){
//            cur=pq.poll();
//            if(cur!=last){
//                last=cur;
//                count++;
//                for(int p:primes){
//                    if((long)cur*p<=Integer.MAX_VALUE){
//                        pq.offer(cur*p);
//                    }
//                }
//            }
//        }
//        return cur;
//    }
}
