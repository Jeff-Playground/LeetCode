package com.wen.EleventhFifty;

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int l=nums.length;
        int left=0, right=nums.length-1;
        while(left<right){
            int mid=(right-left)/2+left;
            // Because for i%2==0, i^1==i+1, (i+1)^1==i
            if(nums[mid]==nums[mid^1]){
                left=mid+1;
            } else{
                right=mid;
            }
        }
        return nums[left];
    }

//    public int singleNonDuplicate(int[] nums) {
//        int l=nums.length;
//        int left=0, right=nums.length-1;
//        while(left<right){
//            int mid=(right-left)/2+left;
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

//    public int singleNonDuplicate(int[] nums) {
//        int l=nums.length;
//        int left=0, right=nums.length-1;
//           while(left<right){
//            int mid=(right-left)/2+left;
//            if(nums[mid]==nums[mid+1]){
//                if((l-mid)%2==0){
//                    right=mid-1;
//                } else{
//                    left=mid+2;
//                }
//            } else{
//                if(mid==0 || nums[mid]!=nums[mid-1]){
//                    return nums[mid];
//                }
//                if((l-mid)%2==0){
//                    left=mid+1;
//                } else{
//                    right=mid;
//                }
//            }
//        }
//        return nums[left];
//    }
}
