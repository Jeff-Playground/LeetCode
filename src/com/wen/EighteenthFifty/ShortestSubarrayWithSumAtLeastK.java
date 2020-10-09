package com.wen.EighteenthFifty;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class ShortestSubarrayWithSumAtLeastK {
//    // Use a PriorityQueue to maintain the previous prefix sums, and find cases when sum[b]-sum[a]>=K
//    public int shortestSubarray(int[] A, int K) {
//        int l=A.length, curSum=0, result=Integer.MAX_VALUE;
//        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[0]-b[0]);
//        for(int i=0; i<l; i++){
//            curSum+=A[i];
//            if(curSum>=K){
//                result=Math.min(result, i+1);
//            }
//            while(!pq.isEmpty() && curSum-pq.peek()[0]>=K){
//                int[] last=pq.poll();
//                result=Math.min(result, i-last[1]);
//            }
//            pq.offer(new int[]{curSum, i});
//        }
//        return result==Integer.MAX_VALUE?-1:result;
//    }

    // Use a Deque to store prefix sums that's can potentially form cases when sum[b]-sum[a]>=K
    public int shortestSubarray(int[] A, int K) {
        int l=A.length, result=Integer.MAX_VALUE;
        int[] sum=new int[l+1];
        for(int i=1; i<l+1; i++){
            sum[i]=sum[i-1]+A[i-1];
        }
        Deque<Integer> dq=new LinkedList<>();
        for(int i=0; i<l+1; i++){
            // Here remove from front because even if it's useful later, it won't be shorter than current length
            while(!dq.isEmpty() && sum[i]-sum[dq.peekFirst()]>=K){
                result=Math.min(result, i-dq.pollFirst());
            }
            // Here remove from back because sum[i] is more useful for later sums
            while(!dq.isEmpty() && sum[i]<=sum[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}
