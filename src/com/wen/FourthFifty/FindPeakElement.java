package com.wen.FourthFifty;

public class FindPeakElement {
//    // O(n) time complexity
//    public int findPeakElement(int[] nums) {
//        if(nums==null || nums.length==0){
//            return -1;
//        }
//        for(int i=1; i<nums.length; i++){
//            // here no need to check nums[i-1]>nums[i-2] because this is already done in last iteration
//            // also no need to check nums[i-1]==nums[i-2] because in constraints it says nums[i]!=nums[i+1] for all valid i
//            if(nums[i-1]>nums[i]){
//                return i-1;
//            }
//        }
//        // this handles when nums.length==1
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
            // peak is the larger value, so we pick the larger side
            if(nums[mid]<nums[mid+1]){
                left=mid+1;
            } else{
                right=mid;
            }
        }
        return left;
    }
}
