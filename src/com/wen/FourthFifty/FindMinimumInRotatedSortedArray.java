package com.wen.FourthFifty;

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int left=0, right=nums.length-1;
        if(nums[left]<nums[right]){
            return nums[left];
        } else{
            while(left<right){
                int mid=left+(right-left)/2;
                if(mid==left){
                    break;
                }
                // Here it can't be left=mid+1 or right=mid-1 because it can exclude the min value of an array, it's different than looking for a targeted value(SearchInRotatedSortedArray)
                if(nums[left]<nums[mid]){
                    left=mid;
                } else{
                    right=mid;
                }
            }
            return Math.min(nums[left], nums[right]);
        }
    }
}
