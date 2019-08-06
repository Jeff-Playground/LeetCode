package com.wen.TwelfthFifty;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    // start keeps moving to front and end keeps to back, when stop get the result
    public int findUnsortedSubarray(int[] nums) {
        if(nums==null || nums.length<2){
            return 0;
        }
        int l=nums.length;
        int min=nums[l-1], max=nums[0];
        int start=-1, end=-2;
        for(int i=1; i<l; i++){
            max=Math.max(max, nums[i]);
            min=Math.min(min, nums[l-1-i]);
            if(nums[i]<max){
                end=i;
            }
            if(nums[l-1-i]>min){
                start=l-1-i;
            }
        }
        return end-start+1;
    }

//    // Sort then find differences
//    public int findUnsortedSubarray(int[] nums) {
//        if (nums == null || nums.length < 2) {
//            return 0;
//        }
//        int l = nums.length;
//        int[] orig = Arrays.copyOf(nums, l);
//        Arrays.sort(nums);
//        int start = -1, end = -1;
//        for (int i = 0; i < l; i++) {
//            if (orig[i] != nums[i]) {
//                start = i;
//                break;
//            }
//        }
//        if (start == -1) {
//            return 0;
//        } else {
//            for (int i = l - 1; i >= 0; i--) {
//                if (orig[i] != nums[i]) {
//                    end = i;
//                    break;
//                }
//            }
//            return end - start + 1;
//        }
//    }
}
