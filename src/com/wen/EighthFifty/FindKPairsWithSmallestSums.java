package com.wen.EighthFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        List<List<Integer>> result=new ArrayList<>();
//        int l1=nums1.length, l2=nums2.length, c1=Math.min(l1, k), c2=Math.min(l2, k);
//        PriorityQueue<List<Integer>> pq=new PriorityQueue<>((a, b)->(a.get(0)-b.get(0)+a.get(1)-b.get(1)));
//        for(int i=0; i<c1; i++){
//            for(int j=0; j<c2; j++){
//                pq.offer(Arrays.asList(nums1[i], nums2[j]));
//            }
//        }
//        for(int i=0; i<k; i++){
//            if(pq.isEmpty()){
//                break;
//            }
//            result.add(pq.poll());
//        }
//        return result;
//    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result=new ArrayList<>();
        int l1=nums1.length, l2=nums2.length, size=Math.min(k, l1*l2);
        int[] idx=new int[l1];
        for(int i=0; i<size; i++){
            int sum=Integer.MAX_VALUE, cur=-1;
            for(int j=0; j<l1; j++){
                if(idx[j]<l2 && nums1[j]+nums2[idx[j]]<sum){
                    sum=nums1[j]+nums2[idx[j]];
                    cur=j;
                }
            }
            if(cur!=-1){
                result.add(Arrays.asList(nums1[cur], nums2[idx[cur]++]));
            }
        }
        return result;
    }
}
