package com.wen.EighteenthFifty;

public class PeakIndexInAMountainArray {
    // Binary search
    public int peakIndexInMountainArray(int[] A) {
        int l=A.length;
        int left=1, right=l-2;
        while(left<right){
            int mid=left+(right-left)/2;
            if(A[mid]>A[mid-1] && A[mid]>A[mid+1]){
                return mid;
            } else if(A[mid]>A[mid-1]){
                left=mid+1;
            } else{
                right=mid-1;
            }
        }
        return left;
    }

//    public int peakIndexInMountainArray(int[] A) {
//        int l=A.length;
//        for(int i=1; i<l-1; i++){
//            if(A[i]>A[i+1]){
//                return i;
//            }
//        }
//        return -1;
//    }
}
