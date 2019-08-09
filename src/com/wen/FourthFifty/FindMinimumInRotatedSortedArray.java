package com.wen.FourthFifty;

public class FindMinimumInRotatedSortedArray {
//    // Handle array unrotated in the loop
//    public int findMin(int[] nums) {
//        int left=0, right=nums.length-1;
//        while(left<right){
//        	if(nums[left]<=nums[right]) {
//        		return nums[left];
//        	}
//        	int mid=left+(right-left)/2;
//        	// Note there're no duplicates so equals can't happen
//        	if(nums[left]<nums[mid]) {
//        		left=mid+1;
//        	} else if(nums[left]>nums[mid]){
//        		right=mid;
//        	}
//        }
//        return nums[right];
//    }
    
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
                // Here it can't be left=mid+1 or right=mid-1 because it can exclude the min value of an array,
                // it's possible that after a certain loop, the checked range became un-rotated
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
