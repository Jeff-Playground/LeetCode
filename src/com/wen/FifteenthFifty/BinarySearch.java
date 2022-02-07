package com.wen.FifteenthFifty;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int l=nums.length;
        int left=0, right=l-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            } else if(nums[mid]<target){
                left=mid+1;
            } else{
                right=mid-1;
            }
        }
        return nums[left]==target?left:-1;
    }
}
