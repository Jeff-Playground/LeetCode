package com.wen.TwentyThirdFifty;

/*
Given an array nums sorted in non-decreasing order, and a number target, return True if and only if target is a majority
element.

A majority element is an element that appears more than N/2 times in an array of length N.

Example 1:
Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
Output: true
Explanation:
The value 5 appears 5 times and the length of the array is 9.
Thus, 5 is a majority element because 5 > 9/2 is true.

Example 2:
Input: nums = [10,100,101,101], target = 101
Output: false
Explanation:
The value 101 appears 2 times and the length of the array is 4.
Thus, 101 is not a majority element because 2 > 4/2 is false.

Note:
1 <= nums.length <= 1000
1 <= nums[i] <= 10^9
1 <= target <= 10^9

 */

public class LQCheckIfANumberIsMajorityElementInASortedArray {
    // Binary search
    public boolean isMajorityElement(int[] nums, int target) {
        int l=nums.length;
        int left=0, right=l-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            } else{
                right=mid;
            }
        }
        return left+l/2<l && nums[left+l/2]==target;
    }
}
