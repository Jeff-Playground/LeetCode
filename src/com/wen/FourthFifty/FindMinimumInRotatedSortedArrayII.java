package com.wen.FourthFifty;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArrayII {
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
//        		if(left<mid) {
//        			left++;
//        		} else {
//            		left=mid+1;
//        		}
//        	} else if(nums[left]<nums[mid]) {
//        		left=mid+1;
//        	} else {
//        		right=mid;
//        	}
//        }
//        return nums[right];
//    }
    
    // Iterative, this is similar to recursive logically, because left++ and left=mid+1, right=mid-1 can all make the new array non-rotated, keep tracking the min value from each part
    public int findMin(int[] nums) {
        int left=0, right=nums.length-1;
        int result=nums[0];
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[left]<nums[mid]){
                result=Math.min(result, nums[left]);
                left=mid+1;
            } else if(nums[left]==nums[mid]){
                result=Math.min(result, nums[left]); // Add this to make sure answer doesn't get excluded for left==mid
                left++;
            } else{
                result=Math.min(result, nums[mid]);
                right=mid-1;
            }
        }
        return Math.min(Math.min(nums[left], nums[right]), result);
    }

//    // This has to be recursive because doing left++ may make the new array non-rotated
//    public static int findMin(int[] nums) {
//        int left=0, right=nums.length-1;
//        if(nums[left]<nums[right]){
//            return nums[left];
//        } else{
//            int mid=left+(right-left)/2;
//            if(mid==left){
//                return Math.min(nums[left], nums[right]);
//            }
//            if(nums[left]<nums[mid]){
//                left=mid;
//            } else if(nums[left]==nums[mid]){
//                left++;
//            } else{
//                right=mid;
//            }
//            return findMin(Arrays.copyOfRange(nums, left, right+1));
//        }
//    }
}
