package com.wen.FirstFifty;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        if (m == 0) return (nums2[(n - 1) / 2] + nums2[n / 2]) / 2.0;
        int left = 0;
        int right = 2 * m;
        while (left <= right) {
            int mid1 = (left+right)/2;
            int mid2 = m+n-mid1;

            double L1 = mid1==0 ? Double.MIN_VALUE : nums1[(mid1-1)/2];
            double L2 = mid2==0 ? Double.MIN_VALUE : nums2[(mid2-1)/2];
            double R1 = mid1==2*m ? Double.MAX_VALUE : nums1[mid1/2];
            double R2 = mid2==2*n ? Double.MAX_VALUE : nums2[mid2/2];

            if(L1>R2){
                right = mid1-1;
            } else if(L2>R1){
                left = mid1+1;
            } else{
                return (Math.max(L1,L2)+Math.min(R1,R2))/2;
            }
        }
        return -1;
    }
}
