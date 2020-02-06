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
            for(int i=0; i<l-k; i++){
                result[i]=nums[deque.peekFirst()];
                if(deque.peekFirst()==i){
                    deque.pollFirst();
                }
                while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i+k]){
                    deque.pollLast();
                }
                deque.offerLast(i+k);
            }
            result[l-k]=nums[deque.peekFirst()];
            return result;
        }
    }
}
