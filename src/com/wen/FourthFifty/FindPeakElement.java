package com.wen.FourthFifty;

public class FindPeakElement {
//    // O(n) time complexity
//    public int findPeakElement(int[] nums) {
//        if(nums==null || nums.length==0){
//            return -1;
//        }
//        for(int i=1; i<nums.length; i++){
//            if(nums[i]<nums[i-1]){
//                return i-1;
//            }
//        }
//        return nums.length-1;
//    }

    // O(log n) time complexity
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int left=0, right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<nums[mid+1]){
                left=mid+1;
            } else{
                right=mid;
            }
        }
        return right;
    }

//    // O(log n) time complexity(my way)
//    public int findPeakElement(int[] nums) {
//        if(nums==null || nums.length==0){
//            return -1;
//        }
//        int left=0, right=nums.length-1;
//        while(left<right){
//            if(right-left==1){
//                return nums[left]>nums[right]?left:right;
//            }
//            int mid=left+(right-left)/2;
//            if(nums[mid]>nums[mid-1]){
//                if(nums[mid]>nums[mid+1]){
//                    return mid;
//                } else{
//                    left=mid+1;
//                }
//            } else{
//                if(nums[mid]>nums[mid+1]){
//                    right=mid-1;
//                } else{
//                    left=mid+1;
//                }
//            }
//        }
//        return left;
//    }
}
