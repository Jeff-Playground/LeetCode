package com.wen.EleventhFifty;

public class SingleElementInASortedArray {
    // Since it's sorted array, using bit manipulation(O(n)) won't be as effective as binary search(O(logn))

//    // Binary search
//    public int singleNonDuplicate(int[] nums) {
//        int l=nums.length;
//        int left=0, right=nums.length-1;
//        while(left<right){
//            int mid=left+(right-left)/2;
//            // Because for even number i%2==0, i^1==i+1, (i+1)^1==i
//            if(nums[mid]==nums[mid^1]){
//                left=mid+1;
//            } else{
//                right=mid;
//            }
//        }
//        return nums[left];
//    }

//    // Binary search 2
//    public int singleNonDuplicate(int[] nums) {
//        int l=nums.length;
//        int left=0, right=nums.length-1;
//        while(left<right){
//            int mid=left+(right-left)/2;
//            if(mid%2==1){
//                mid--;
//            }
//            if(nums[mid]==nums[mid+1]){
//                left=mid+2;
//            } else{
//                right=mid;
//            }
//        }
//        return nums[left];
//    }

    // Binary search 3
    public int singleNonDuplicate(int[] nums) {
        int l=nums.length;
        int left=0, right=nums.length-1;
           while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==nums[mid+1]){
                if((l-mid)%2==0){
                    right=mid-1;
                } else{
                    left=mid+2;
                }
            } else{
                if(mid==0 || nums[mid]!=nums[mid-1]){
                    return nums[mid];
                }
                if((l-mid)%2==0){
                    left=mid+1;
                } else{
                    right=mid;
                }
            }
        }
        return nums[left];
    }
}
