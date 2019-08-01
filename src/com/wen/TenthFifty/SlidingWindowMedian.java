package com.wen.TenthFifty;

import java.util.TreeSet;

public class SlidingWindowMedian {
    public static double[] medianSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return new double[]{};
        }
        int l=nums.length;
        double[] result=new double[l-k+1];
        // Note here for comparotor can't use nums[a]-nums[b] because this will overflow for Integer.MAX_VALUE and Integer.MIN_VALUE
        TreeSet<Integer> left=new TreeSet<>((a, b)->(nums[a]==nums[b]?a-b:Integer.compare(nums[a],nums[b])));
        TreeSet<Integer> right=new TreeSet<>((a, b)->(nums[a]==nums[b]?a-b:Integer.compare(nums[a],nums[b])));
        for(int i=0; i<l; i++){
            if(i<k-1){
                addNum(nums, left, right, i);
            } else if(i==k-1){
                addNum(nums, left, right, i);
                result[i-k+1]=getMedian(nums, left, right);
            } else{
                addNum(nums, left, right, i);
                removeNum(nums, left, right, i-k);
                result[i-k+1]=getMedian(nums, left, right);
            }
        }
        return result;
    }

    public static double getMedian(int[] nums, TreeSet<Integer> left, TreeSet<Integer> right){
        if(left.size()>right.size()){
            return (double)nums[left.last()];
        } else{
            int l=nums[left.last()];
            int r=nums[right.first()];
            if(l>=0){
                return r>=0?(r-l)/2.0+l:(l+r)/2.0;
            } else{
                return r<0?(r-l)/2.0+l:(l+r)/2.0;
            }
        }
    }

    public static void addNum(int[] nums, TreeSet<Integer> left, TreeSet<Integer> right, int index){
        if(left.size()>right.size()){
            int leftMaxIndex=left.last();
            if(nums[index]<nums[leftMaxIndex]){
                left.add(index);
                left.remove(leftMaxIndex);
                index=leftMaxIndex;
            }
            right.add(index);
        } else{
            if(right.size()>0){
                int rightMinIndex=right.first();
                if(nums[index]>nums[rightMinIndex]){
                    right.add(index);
                    right.remove(rightMinIndex);
                    index=rightMinIndex;
                }
            }
            left.add(index);
        }
    }

    public static void removeNum(int[] nums, TreeSet<Integer> left, TreeSet<Integer> right, int index){
        if(left.size()>right.size()){
            if(right.contains(index)){
                int leftMaxIndex=left.last();
                right.remove(index);
                right.add(leftMaxIndex);
                index=leftMaxIndex;
            }
            left.remove(index);
        } else {
            if(left.contains(index)){
                int rightMinIndex=right.first();
                left.remove(index);
                left.add(rightMinIndex);
                index=rightMinIndex;
            }
            right.remove(index);
        }
    }

//    // Insertion sort
//    public static double[] medianSlidingWindow(int[] nums, int k) {
//        if(nums==null || nums.length==0) {
//            return new double[] {};
//        }
//        int l=nums.length;
//        int[] window=new int[k];
//        for(int i=0; i<k && i<l; i++) {
//            insertionSort(window, 0, i, nums[i], true);
//        }
//        if(l<=k) {
//            double mid=0;
//            if(sameSign(window[(l-1)/2], window[l/2])) {
//                mid=(window[l/2]-window[(l-1)/2])/2.0+window[(l-1)/2];
//            } else {
//                mid=(window[l/2]+window[(l-1)/2])/2.0;
//            }
//            return new double[] {mid};
//        } else {
//            double[] result=new double[l-k+1];
//            if(sameSign(window[(k-1)/2], window[k/2])) {
//                result[0]=(window[k/2]-window[(k-1)/2])/2.0+window[(k-1)/2];
//            } else {
//                result[0]=(window[k/2]+window[(k-1)/2])/2.0;
//            }
//            for(int i=1; i<l-k+1; i++) {
//                int index=0;
//                for(int j=0; j<k; j++) {
//                    if(window[j]==nums[i-1]) {
//                        index=j;
//                        break;
//                    }
//                }
//                if(nums[i+k-1]<window[index]) {
//                    insertionSort(window, 0, index, nums[i+k-1], true);
//                } else if(nums[i+k-1]>window[index]) {
//                    insertionSort(window, index, k-1, nums[i+k-1], false);
//                }
//                if(sameSign(window[(k-1)/2], window[k/2])) {
//                    result[i]=(window[k/2]-window[(k-1)/2])/2.0+window[(k-1)/2];
//                } else {
//                    result[i]=(window[k/2]+window[(k-1)/2])/2.0;
//                }
//            }
//            return result;
//        }
//    }
//
//    public static boolean sameSign(int a, int b) {
//        if(a>=0) {
//            return b>=0;
//        } else {
//            return b<=0;
//        }
//    }
//
//    private static void insertionSort(int[] window, int start, int end, int v, boolean back) {
//        if(start==end) {
//            window[start]=v;
//        } else {
//            if(back) {
//                int i=end-1;
//                while(i>=0) {
//                    if(window[i]<=v) {
//                        break;
//                    } else {
//                        window[i+1]=window[i];
//                    }
//                    i--;
//                }
//                window[i+1]=v;
//            } else {
//                int i=start+1;
//                while(i<=end) {
//                    if(window[i]>=v) {
//                        break;
//                    } else {
//                        window[i-1]=window[i];
//                    }
//                    i++;
//                }
//                window[i-1]=v;
//            }
//        }
//    }
}
