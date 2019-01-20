package com.wen.SecondFifty;

public class RemoveDuplicatesFromSortedArrayII {
    // One cursor
    public static int removeDuplicates(int[] nums) {
        int result=0;
        if(nums==null){
            return result;
        }
        if(nums.length<=2){
            return nums.length;
        }
        result=2;
        for(int i=2; i<nums.length; i++){
            if(nums[result-2]!=nums[i]){
                nums[result++]=nums[i];
            }
        }
        return result;
    }

//    // Slow and fast cursor with index to set value
//    public static int removeDuplicates(int[] nums) {
//        int result=0;
//        if(nums==null || nums.length==0){
//            return result;
//        }
//        int fast=1, slow=0, idx=1;
//        while(fast<nums.length){
//            if(nums[fast]==nums[slow]){
//                if(fast==slow+1){
//                    nums[idx]=nums[fast];
//                    idx++;
//                    result++;
//                }
//                fast++;
//            } else{
//                nums[idx]=nums[fast];
//                result++;
//                idx++;
//                slow=fast;
//                fast++;
//            }
//        }
//        if(fast>=slow+1){
//            result++;
//        }
//        return result;
//    }
}
