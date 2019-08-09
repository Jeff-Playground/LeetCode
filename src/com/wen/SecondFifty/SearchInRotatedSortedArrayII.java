package com.wen.SecondFifty;

public class SearchInRotatedSortedArrayII {
    // return nums[right]==target or nums[left]==target because while(left<right) exits when left==right
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return false;
        }
        int l=nums.length;
        int left=0, right=l-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return true;
            } else if(nums[left]==nums[mid]){
                left++;
            } else if(nums[left]<nums[mid]){
                if(target>=nums[left] && target<nums[mid]){
                    right=mid-1;
                } else {
                    left=mid+1;
                }
            } else{
                if(target>nums[mid] && target<=nums[right]){
                    left=mid+1;
                } else {
                    right=mid-1;
                }
            }
        }
        return nums[right]==target;
    }

//    // return false becuase while(left<=right), so impossible to have nums[right]==target or nums[left]==target in the end
//    public boolean search(int[] nums, int target) {
//        if(nums==null || nums.length==0){
//            return false;
//        }
//        int left=0, right=nums.length-1;
//        while(left<=right){
//            int mid=left+(right-left)/2;
//            if(nums[mid]==target){
//                return true;
//            } else if(nums[mid]<nums[right]){
//                if(nums[mid]<target && nums[right]>=target){
//                    left=mid+1;
//                } else{
//                    right=mid-1;
//                }
//            } else if(nums[mid]>nums[right]){
//                if(nums[mid]>target && nums[left]<=target){
//                    right=mid-1;
//                } else{
//                    left=mid+1;
//                }
//            // This part handles when left==right==mid
//            } else{
//                right--;
//            }
//        }
//        return false;
//    }
}
