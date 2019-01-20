package com.wen.FirstFifty;

public class FindFirstAndLastPositionOfElementInSortedArray {
    // Binary search twice, O(logn)
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if(nums==null || nums.length==0){
            return result;
        }
        int left=0, right=nums.length-1;
        while(left<right){
            int mid=(right-left)/2+left;
            if(nums[mid]<target){
                left=mid+1;
            } else{
                right=mid;
            }
        }
        if(nums[right]!=target){
            return result;
        }
        result[0]=right;
        right=nums.length;
        while(left<right){
            int mid=(right-left)/2+left;
            if(nums[mid]<=target){
                left=mid+1;
            } else{
                right=mid;
            }
        }
        result[1]=left-1;
        return result;
    }


//    // Worst case O(n)
//    public int[] searchRange(int[] nums, int target) {
//        int[] result = new int[]{-1, -1};
//        if(nums==null){
//            return result;
//        }
//        int left=0, right=nums.length-1;
//        while(left<=right){
//            int mid=(right-left)/2+left;
//            if(nums[mid]==target){
//                left=mid-1;
//                while(left>=0 && nums[left]==target){
//                    left--;
//                }
//                result[0]=left+1;
//                right=mid+1;
//                while(right<=nums.length-1 && nums[right]==target){
//                    right++;
//                }
//                result[1]=right-1;
//                return result;
//            } else if(nums[mid]>target){
//                right=mid-1;
//            } else{
//                left=mid+1;
//            }
//        }
//        return result;
//    }
}
