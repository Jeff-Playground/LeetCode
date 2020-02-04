package com.wen.FirstFifty;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int left=0, right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>=target){
                right=mid;
            } else{
                left=mid+1;
            }
        }
        if(nums[right]==target){
            return right;
        } else if(nums[right]<target){      // This is to handle when target>nums[nums.length-1]
            return right+1;
        } else{
            return right;
        }
    }
}
