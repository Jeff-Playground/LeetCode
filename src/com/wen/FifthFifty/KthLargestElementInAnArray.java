package com.wen.FifthFifty;

import java.util.Stack;

public class KthLargestElementInAnArray {
//    // Note that it is the kth largest element in the sorted order, not the kth distinct element, otherwise a TreeSet
//    // works better here
//    // Quick sort with Stack iteratively
//    public int findKthLargest(int[] nums, int k) {
//        Stack<Integer> stack=new Stack<>();
//        stack.push(nums.length-1);
//        stack.push(0);
//        int index=-1;
//        while(index!=k-1) {
//            int low=stack.pop();
//            int high=stack.pop();
//            int left=low, right=high;
//            int temp=nums[left];
//            while(left<right) {
//                while(left<right && nums[right]<=temp) {
//                    right--;
//                }
//                nums[left]=nums[right];
//                while(left<right && nums[left]>temp) {
//                    left++;
//                }
//                nums[right]=nums[left];
//            }
//            nums[left]=temp;
//            if(left>k-1) {
//                stack.push(left-1);
//                stack.push(low);
//            } else {
//                stack.push(high);
//                stack.push(left+1);
//            }
//            index=left;
//        }
//        return nums[index];
//    }

    // Quick sort recursively
    // Note the comparison need to be >= or <= instead of > or <, otherwise
    public int findKthLargest(int[] nums, int k) {
        return fklHelper(nums, 0, nums.length-1, k);
    }

    private int fklHelper(int[] nums, int left, int right, int k){
        int cur=nums[left], l=left, r=right;
        while(l<r){
            while(l<r && nums[r]<=cur){
                r--;
            }
            nums[l]=nums[r];
            while(l<r && nums[l]>=cur){
                l++;
            }
            nums[r]=nums[l];
        }
        nums[l]=cur;
        if(l-left+1==k){
            return nums[l];
        } else if(l-left+1<k){
            return fklHelper(nums, l+1, right, k-(l-left+1));
        } else{
            return fklHelper(nums, left, l-1, k);
        }
    }
}
