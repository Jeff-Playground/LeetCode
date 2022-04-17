package com.wen.FirstFifty;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l=nums.length;
        int left=0, right=l-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            } else if(nums[mid]<nums[right]){
                if(nums[mid]<target && nums[right]>=target){
                    left=mid+1;
                } else{
                    right=mid-1;
                }
            } else{
                if(nums[mid]>target && nums[left]<=target){
                    right=mid-1;
                } else{
                    left=mid+1;
                }
            }
        }
        return nums[left]==target?left:-1;
    }

//    public int search(int[] nums, int target) {
//        int l=nums.length;
//        int left=0, right=l-1;
//        while(left<right){
//            int mid=left+(right-left)/2;
//            if(nums[mid]==target){
//                return mid;
//            } else if(nums[mid]>=nums[left]){
//                if(nums[mid]>target && nums[left]<=target){
//                    right=mid-1;
//                } else{
//                    left=mid+1;
//                }
//            } else{
//                if(nums[mid]<target && nums[right]>=target){
//                    left=mid+1;
//                } else{
//                    right=mid-1;
//                }
//            }
//        }
//        return nums[left]==target?left:-1;
//    }
}
