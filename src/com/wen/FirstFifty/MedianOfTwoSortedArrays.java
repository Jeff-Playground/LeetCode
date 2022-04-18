package com.wen.FirstFifty;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length, n=nums2.length;
        if(m>n){
            return findMedianSortedArrays(nums2, nums1);
        }
        int left=0, right=2*m;
        while(left<=right){
            // Cut is based on converting both original arrays to something like #1#2#3#, so the length of nums1 becomes
            // 2*m+1, nums2 becomes 2*n+1
            // The new indices of numbers can be converted to the old indices by newIdx/2
            int cut1=(left+right)/2;
            int cut2=m+n-cut1;
            double l1=cut1==0?Double.MIN_VALUE:nums1[(cut1-1)/2];
            double r1=cut1==2*m?Double.MAX_VALUE:nums1[cut1/2];
            double l2=cut2==0?Double.MIN_VALUE:nums2[(cut2-1)/2];
            double r2=cut2==2*n?Double.MAX_VALUE:nums2[cut2/2];
            if(l1>r2){
                right=cut1-1;
            } else if(l2>r1){
                left=cut1+1;
            } else {
                return (Math.max(l1,l2)+Math.min(r1,r2))/2;
            }
        }
        return -1;
    }

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m=nums1.length, n=nums2.length, left=(m+n-1)/2, right=(m+n)/2;
//        return (findKthNumber(nums1, 0, nums2, 0, left+1)+findKthNumber(nums1, 0, nums2, 0, right+1))/2.0;
//    }
//
//    public int findKthNumber(int[] nums1, int i, int[] nums2, int j, int k) {
//        int m=nums1.length, n=nums2.length;
//        if(i>=m){
//            return nums2[j+k-1];
//        }
//        if(j>=n){
//            return nums1[i+k-1];
//        }
//        if(k==1){
//            return Math.min(nums1[i], nums2[j]);
//        }
//        int mid1=i+k/2-1<m?nums1[i+k/2-1]:Integer.MAX_VALUE;
//        int mid2=j+k/2-1<n?nums2[j+k/2-1]:Integer.MAX_VALUE;
//        if(mid1>mid2) {
//            return findKthNumber(nums1, i, nums2, j+k/2, k-k/2);
//        } else {
//            return findKthNumber(nums1, i+k/2, nums2, j, k-k/2);
//        }
//    }
}
