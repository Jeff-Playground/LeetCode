package com.wen.FifthFifty;

import java.util.Stack;

public class KthLargestElementInAnArray {
    // Note that it is the kth largest element in the sorted order, not the kth distinct element, otherwise a TreeSet
    // works better here
    // Quick sort with Stack iteratively
    public int findKthLargest(int[] nums, int k) {
        Stack<Integer> stack=new Stack<>();
        stack.push(nums.length-1);
        stack.push(0);
        int index=-1;
        while(index!=k-1) {
            int low=stack.pop();
            int high=stack.pop();
            int left=low, right=high;
            int temp=nums[left];
            while(left<right) {
                while(left<right && nums[right]<=temp) {
                    right--;
                }
                nums[left]=nums[right];
                while(left<right && nums[left]>temp) {
                    left++;
                }
                nums[right]=nums[left];
            }
            nums[left]=temp;
            if(left>k-1) {
                stack.push(left-1);
                stack.push(low);
            } else {
                stack.push(high);
                stack.push(left+1);
            }
            index=left;
        }
        return nums[index];
    }
}
