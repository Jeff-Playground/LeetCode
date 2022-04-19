package com.wen.EighteenthFifty;

public class MonotonicArray {
    // Use 2 int to track the length of increasing/decreasing array, then eventually check if one of them is equal to l
    public boolean isMonotonic(int[] nums) {
        int l=nums.length;
        int incLength=1, decLength=1;
        for(int i=1; i<l; i++){
            if(nums[i]>=nums[i-1]){
                incLength++;
            }
            if(nums[i]<=nums[i-1]){
                decLength++;
            }
        }
        return incLength==l || decLength==l;
    }

//    // Use 2 booleans to identify increasing/decreasing, then update through iteration, they can't both be false for a
//    // monotonous array
//    public boolean isMonotonic(int[] nums) {
//        int l=nums.length;
//        boolean inc=true, dec=true;
//        for(int i=1; i<l; i++){
//            inc&=nums[i]>=nums[i-1];
//            dec&=nums[i]<=nums[i-1];
//            if(!inc && !dec){
//                return false;
//            }
//        }
//        return true;
//    }

//    // Naive
//    public boolean isMonotonic(int[] nums) {
//        int l=nums.length;
//        boolean desc=false, found=false;;
//        int i;
//        for(i=1; i<l && !found; i++){
//            if(nums[i]!=nums[i-1]){
//                desc=nums[i]<nums[i-1];
//                found=true;
//            }
//        }
//        if(!found){
//            return true;
//        } else{
//            for(; i<l; i++){
//                if((nums[i]>nums[i-1] && desc) || (nums[i]<nums[i-1] && !desc)){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}
