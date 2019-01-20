package com.wen.SecondFifty;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return false;
        }
        int left=0, right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return true;
            } else if(nums[mid]<=nums[right]){
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
        return false;
    }
}
