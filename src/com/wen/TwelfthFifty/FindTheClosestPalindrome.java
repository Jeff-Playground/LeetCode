package com.wen.TwelfthFifty;

import java.util.PriorityQueue;

public class FindTheClosestPalindrome {
    public String nearestPalindromic(String n) {
        int l=n.length();
        long num=Long.parseLong(n), minDiff=Long.MAX_VALUE, result=0;
        PriorityQueue<Long> nums=new PriorityQueue<>((a, b)->Math.abs(a-num)<Math.abs(b-num)?-1:1);
        nums.offer((long)Math.pow(10, l)+1);
        nums.offer((long)Math.pow(10, l-1)-1);
        long prefix=Long.parseLong(n.substring(0, (l+1)/2));
        for(long i=-1; i<=1; i++){
            StringBuilder pre=new StringBuilder(String.valueOf(prefix+i));
            String built=pre.toString()+pre.reverse().substring(0+(l&1));
            long cur=Long.parseLong(built);
            nums.offer(cur);
        }
        while(nums.peek()==num){
            nums.poll();
        }
        return String.valueOf(nums.poll());
    }
}
