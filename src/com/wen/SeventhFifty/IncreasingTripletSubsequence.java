package com.wen.SeventhFifty;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums==null || nums.length<3) {
            return false;
        } else {
            int first=Integer.MAX_VALUE, second=Integer.MAX_VALUE;
            for(int num: nums) {
                if(first>=num) {
                    first=num;
                } else if(second>=num) {
                    second=num;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

//    public boolean increasingTriplet(int[] nums) {
//        int[] min=new int[nums.length];
//        int[] max=new int[nums.length];
//        for(int i=0; i<nums.length; i++) {
//            if(i==0) {
//                min[i]=nums[i];
//            } else {
//                min[i]=Math.min(min[i-1], nums[i]);
//            }
//        }
//        for(int i=nums.length-1; i>=0; i--) {
//            if(i==nums.length-1) {
//                max[i]=nums[i];
//            } else {
//                max[i]=Math.max(max[i+1], nums[i]);
//            }
//        }
//        for(int i=0; i<nums.length; i++) {
//            if(min[i]<nums[i] && nums[i]<max[i]) {
//                return true;
//            }
//        }
//        return false;
//    }
}
