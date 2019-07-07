package com.wen.EleventhFifty;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if(nums==null || nums.length<2){
            return 0;
        }
        int l=nums.length, left=Integer.MAX_VALUE, right=Integer.MIN_VALUE;
        for(int i=0; i<l; i++){
            if(i+1<l && nums[i]>nums[i+1]){
                int temp=nums[i+1], cur=i;
                while(i-1>=0 && nums[i-1]>temp){
                    i--;
                }
                left=Math.min(left,i);
                i=cur;
            }
        }
        if(left==Integer.MAX_VALUE){
            return 0;
        }
        for(int i=l-1; i>=0; i--){
            if(i-1>=0 && nums[i]<nums[i-1]){
                int temp=nums[i-1], cur=i;
                while(i+1<l && nums[i+1]<temp){
                    i++;
                }
                right=Math.max(right, i);
                i=cur;
            }
        }
        return right-left+1;
    }

//    public int findUnsortedSubarray(int[] nums) {
//        if(nums==null || nums.length<2){
//            return 0;
//        }
//        int l=nums.length;
//        int[] orig= Arrays.copyOf(nums, l);
//        Arrays.sort(nums);
//        int start=-1, end=-1;
//        for(int i=0; i<l; i++){
//            if(orig[i]!=nums[i]){
//                start=i;
//                break;
//            }
//        }
//        if(start==-1){
//            return 0;
//        } else{
//            for(int i=l-1; i>=0; i--){
//                if(orig[i]!=nums[i]){
//                    end=i;
//                    break;
//                }
//            }
//            return end-start+1;
//        }
//    }

//    public int findUnsortedSubarray(int[] nums) {
//        if(nums==null || nums.length<2){
//            return 0;
//        }
//        int l=nums.length;
//        int min=nums[l-1], max=nums[0];
//        int start=-1, end=-2;
//        for(int i=1; i<l; i++){
//            max=Math.max(max, nums[i]);
//            min=Math.min(min, nums[l-1-i]);
//            if(nums[i]<max){
//                end=i;
//            }
//            if(nums[l-1-i]>min){
//                start=l-1-i;
//            }
//        }
//        // Note end init to -2, so even the original array is in order, this is 0 and still right
//        return end-start+1;
//    }
}
