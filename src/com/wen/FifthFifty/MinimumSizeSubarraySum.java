package com.wen.FifthFifty;

public class MinimumSizeSubarraySum {
//    // Sliding window, T: O(n)
//    public int minSubArrayLen(int s, int[] nums) {
//        if(nums==null || nums.length==0){
//            return 0;
//        }
//        int result=Integer.MAX_VALUE;
//        int left=0, right=0, sum=nums[0];
//        while(right<nums.length){
//            if(sum>=s){
//                result=Math.min(result, right-left+1);
//                if(result==1){
//                    return result;
//                }
//                sum-=nums[left++];
//            } else{
//                if(right<nums.length-1){
//                    sum+=nums[++right];
//                } else{
//                    break;
//                }
//            }
//        }
//        return result==Integer.MAX_VALUE?0:result;
//    }

    // Binary search, T: O(nlogn)
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int result=Integer.MAX_VALUE, l=nums.length;
        for(int i=1; i<l; i++){
            nums[i]+=nums[i-1];
        }
        for(int i=0; i<l; i++){
            int exclude=i==0?0:nums[i-1];
            int target=s+exclude;
            int left=i, right=l-1;
            // Note here the binary search condition has to be left<=right because right might originally be invalid(
            // nums[right]<target might happen), so the range is started with nums[idx]<target and has to exit when
            // nums[idx]>=target
            while(left<=right){
                int mid=left+(right-left)/2;
                if(nums[mid]<target){
                    left=mid+1;
                } else{
                    right=mid-1;
                }
            }
            if(left<l){
                result=Math.min(result, left-i+1);
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }
}
