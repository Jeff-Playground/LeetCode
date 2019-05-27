package com.wen.FifthFifty;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null){
            throw new IllegalArgumentException("Given nums should not be null!");
        }
        int l=nums.length;
        if(l==0){
            return new int[]{};
        }
        Deque<Integer> deque=new LinkedList<>();
        for(int i=0; i<k && i<l; i++){
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        if(l<=k){
            return new int[]{nums[deque.peekFirst()]};
        } else{
            int[] result=new int[l-k+1];
            result[0]=nums[deque.peekFirst()];
            for(int i=1; i<=l-k; i++){
                if(deque.peekFirst()==i-1){
                    deque.pollFirst();
                }
                while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i+k-1]){
                    deque.pollLast();
                }
                deque.offerLast(i+k-1);
                result[i]=nums[deque.peekFirst()];
            }
            return result;
        }
    }
}
