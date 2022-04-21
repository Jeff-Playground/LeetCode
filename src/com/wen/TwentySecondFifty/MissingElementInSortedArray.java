package com.wen.TwentySecondFifty;

public class MissingElementInSortedArray {
//    // Recursive
//    public int missingElement(int[] nums, int k) {
//        return missingElementHelper(nums, 0, nums.length-1, k);
//    }
//
//    private int missingElementHelper(int[] nums, int left, int right, int k){
//        if(nums[right]-nums[left]+1-(right-left+1)<k){
//            return nums[right]+k-(nums[right]-nums[left]+1-(right-left+1));
//        } else{
//            int mid=left+(right-left)/2;
//            // When left==mid, it means left+1==right
//            if(left==mid){
//                return nums[left]+k;
//            }
//            if(nums[mid]-nums[left]+1-(mid-left+1)<k){
//                return missingElementHelper(nums, mid, right, k-(nums[mid]-nums[left]+1-(mid-left+1)));
//            } else{
//                return missingElementHelper(nums, left, mid, k);
//            }
//        }
//    }

    // Similar idea but iterative
    public int missingElement(int[] nums, int k) {
        int l=nums.length;
        int left=0, right=l-1;
        if(nums[right]-nums[left]+1-l<k){
            return nums[right]+k-(nums[right]-nums[left]+1-l);
        } else{
            while(left<right){
                int mid=left+(right-left)/2;
                if(left==mid){
                    return nums[left]+k;
                }
                if(nums[mid]-nums[left]+1-(mid-left+1)<k){
                    k-=nums[mid]-nums[left]+1-(mid-left+1);
                    left=mid;
                } else{
                    right=mid;
                }
            }
            return -1;
        }
    }
}
