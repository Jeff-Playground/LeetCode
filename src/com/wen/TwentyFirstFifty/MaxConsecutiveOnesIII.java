package com.wen.TwentyFirstFifty;

import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnesIII {
    // Sliding window, handles when input array can be a data stream
    public int longestOnes(int[] A, int K) {
        int result=0, idx=0, start=0, l=A.length;
        Queue<Integer> q=new LinkedList<>();
        while(idx<l){
            if(A[idx]==0){
                q.offer(idx);
                while(q.size()>K){
                    start=q.poll()+1;
                }
            }
            result=Math.max(result, idx-start+1);
            idx++;
        }
        return result;
    }

//    // Sliding window
//    public int longestOnes(int[] A, int K) {
//        int result=0, left=0, right=0, l=A.length, zeroCount=0;
//        while(right<l){
//            if(A[right]==0){
//                zeroCount++;
//                while(zeroCount>K){
//                    if(A[left++]==0){
//                        zeroCount--;
//                    }
//                }
//            }
//            result=Math.max(result, right-left+1);
//            right++;
//        }
//        return result;
//    }
}
