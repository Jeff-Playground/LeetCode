package com.wen.TenthFifty;

import java.util.TreeSet;

public class SlidingWindowMedian {
    // Note when computing the median, to avoid overflow, need to do num1+(num2-num1)/2 for two possible/negative values,
    // while for two values with different signs, do (num1+num2)/2

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int l=nums.length;
        double[] result=new double[l-k+1];
        // Note here for comparator can't use nums[a]-nums[b] because this will overflow for Integer.MAX_VALUE and Integer.MIN_VALUE
        // Also note the comparator also does (a-b) when nums[a]==nums[b], otherwise same num in different idx don't get added properly
        TreeSet<Integer> left=new TreeSet<>((a, b)->nums[a]!=nums[b]?Integer.compare(nums[a], nums[b]):a-b), right=new TreeSet<>((a, b)->nums[a]!=nums[b]?Integer.compare(nums[a], nums[b]):a-b);
        for(int i=0; i<l; i++){
            if(i>=k){
                int ri=i-k;
                if(left.size()>right.size()){
                    if(left.contains(ri)){
                        left.remove(ri);
                    } else{
                        right.remove(ri);
                        right.add(left.last());
                        left.remove(left.last());
                    }
                } else{
                    if(left.contains(ri)){
                        left.remove(ri);
                        left.add(right.first());
                        right.remove(right.first());
                    } else{
                        right.remove(ri);
                    }
                }
            }
            if(left.size()>right.size()){
                if(nums[left.last()]>nums[i]){
                    right.add(left.last());
                    left.remove(left.last());
                    left.add(i);
                } else{
                    right.add(i);
                }
            } else{
                if(!right.isEmpty() && nums[right.first()]<nums[i]){
                    left.add(right.first());
                    right.remove(right.first());
                    right.add(i);
                } else{
                    left.add(i);
                }
            }
            if(i>=k-1){
                System.out.println(left.size());
                System.out.println(right.size());
                if(left.size()>right.size()){
                    result[i-k+1]=(double)nums[left.last()];
                    System.out.println("h");
                } else{
                    int n1=nums[left.last()], n2=nums[right.first()];
                    if((n1>0 && n2>0) || (n1<0 && n2<0)){
                        result[i-k+1]=(double)n1+((double)(n2-n1))/2;
                    } else{
                        result[i-k+1]=((double)(n1+n2))/2;
                    }
                    System.out.println("h2");
                }
            }
        }
        return result;
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
//    private static boolean sameSign(int a, int b) {
//        if(a>=0) {
//            return b>=0;
//        } else {
//            return b<=0;
//        }
//    }
//
//    private static void insertionSort(int[] window, int start, int end, int value, boolean back) {
//        if(start==end) {
//            window[start]=value;
//        } else {
//            if(back) {
//                int i=end-1;
//                while(i>=0) {
//                    if(window[i]<=value) {
//                        break;
//                    } else {
//                        window[i+1]=window[i];
//                    }
//                    i--;
//                }
//                window[i+1]=value;
//            } else {
//                int i=start+1;
//                while(i<=end) {
//                    if(window[i]>=value) {
//                        break;
//                    } else {
//                        window[i-1]=window[i];
//                    }
//                    i++;
//                }
//                window[i-1]=value;
//            }
//        }
//    }
}
