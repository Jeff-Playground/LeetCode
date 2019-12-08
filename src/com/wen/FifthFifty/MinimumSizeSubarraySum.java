package com.wen.FifthFifty;

public class MinimumSizeSubarraySum {
    // T: O(n)
    public int minSubArrayLen(int s, int[] nums) {
        int result=Integer.MAX_VALUE;
        if(nums==null || nums.length==0){
            return 0;
        }
        int left=0, right=0, sum=0;
        while(left<=right){
            if(sum<s){
                if(right==nums.length){
                    break;
                }
                sum+=nums[right];
                right++;
            } else{
                result=Math.min(result, right-left);
                sum-=nums[left];
                left++;
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }

//    // T: O(nlogn)
//    public int minSubArrayLen(int s, int[] nums) {
//        int result=Integer.MAX_VALUE;
//        if(nums==null || nums.length==0){
//            return 0;
//        }
//        int[] sums=new int[nums.length+1];
//        for(int i=1; i<nums.length+1; i++){
//            sums[i]=sums[i-1]+nums[i-1];
//        }
//        for(int i=0; i<sums.length; i++){
//            int right=searchRight(i+1, s+sums[i], sums);
//            if(right>sums.length){
//                break;
//            }
//            result=Math.min(result, right-i);
//        }
//        return result==Integer.MAX_VALUE?0:result;
//    }
//
//    public int searchRight(int left, int target, int[] sums){
//        int l=left, r=sums.length-1;
//        while(l<=r){
//            int m=l+(r-l)/2;
//            if(sums[m]<target){
//                l=m+1;
//            } else{
//                r=m-1;
//            }
//        }
//        return l;
//    }
}
