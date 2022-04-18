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
        if(nums[left]!=target){
            return result;
        }
        result[0]=left;
        right=nums.length-1;
        while(left<right){
            int mid=(right-left)/2+left;
            if(nums[mid]<=target){
                left=mid+1;
            } else{
                right=mid;
            }
        }
        result[1]=nums[left]==target?left:left-1;
        return result;
    }


//    // Binary search once, worst case O(n)
//    public int[] searchRange(int[] nums, int target) {
//        int[] result = new int[]{-1, -1};
//        int l=nums.length;
//        if(nums==null || l==0){
//            return result;
//        }
//        int left=0, right=l-1;
//        while(left<right){
//            int mid=(right-left)/2+left;
//            if(nums[mid]<target){
//                left=mid+1;
//            } else{
//                right=mid;
//            }
//        }
//        if(nums[left]!=target){
//            return result;
//        } else{
//            while(right+1<l && nums[right+1]==target){
//                right++;
//            }
//            result[0]=left;
//            result[1]=right;
//        }
//        return result;
//    }
}
