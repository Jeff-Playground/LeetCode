package com.wen.FourthFifty;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArrayII {
//    // Iterative, note it handles array un-rotated in the loop
//    public int findMin(int[] nums) {
//        int left=0, right=nums.length-1;
//        while(left<right){
//        	if(nums[left]==nums[right]) {
//        		left++;
//        		continue;
//        	} else if(nums[left]<nums[right]) {
//        		return nums[left];
//        	}
//        	int mid=left+(right-left)/2;
//        	if(nums[left]==nums[mid]) {
//        	    left++;
//        	    // Underlying is alike, so can be simplified as above:
//        		// if(left<mid) {
//        		// 	left++;
//        		// } else {
//            	// 	left=mid+1;
//        		// }
//        	} else if(nums[left]<nums[mid]) {
//        		left=mid+1;
//        	} else {
//        		right=mid;
//        	}
//        }
//        return nums[right];
//    }

    public int findMin(int[] nums) {
        return findMinHelper(nums, 0, nums.length - 1);
    }

    public int findMinHelper(int[] nums, int left, int right){
        if(nums[left]<nums[right]){
            return nums[left];
        } else{
            int mid=left+(right-left)/2;
            if(mid==left){
                return Math.min(nums[left], nums[right]);   // This means right-left==1
            }
            if(nums[left]<nums[mid]){
                left=mid+1;
            } else if(nums[left]==nums[mid]){
                left++;
            } else{
                right=mid;
            }
            return findMinHelper(nums, left, right);
        }
    }
}
