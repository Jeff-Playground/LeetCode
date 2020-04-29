package com.wen.SeventhFifty;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k=primes.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->a-b);
        pq.offer(1);
        Set<Integer> visited=new HashSet<>();
        int count=0, cur=-1;
        while(count<n){
            cur=pq.poll();
            if(!visited.contains(cur)){
                visited.add(cur);
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
