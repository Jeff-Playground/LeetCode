package com.wen.FifthFifty;

public class MinimumSizeSubarraySum {
//    // Sliding window, T: O(n)
//    public int minSubArrayLen(int s, int[] nums) {
//        int result=Integer.MAX_VALUE;
//        if(nums==null || nums.length==0){
//            return 0;
//        }
//        int left=0, right=0, sum=0;
//        while(left<=right){
//            if(sum<s){
//                if(right==nums.length){
//                    break;
//                }
//                sum+=nums[right];
//                right++;
//            } else{
//                result=Math.min(result, right-left);
//                sum-=nums[left];
//                left++;
//            }
//        }
//        return result==Integer.MAX_VALUE?0:result;
//    }

    // Binary search, T: O(nlogn)
    public static int minSubArrayLen(int s, int[] nums) {
        int result=Integer.MAX_VALUE;
        if(nums==null || nums.length==0){
            return 0;
        }
        int[] sums=new int[nums.length+1];
        for(int i=1; i<nums.length+1; i++){
            sums[i]=sums[i-1]+nums[i-1];
        }
        for(int i=0; i<sums.length; i++){
            int right=searchRight(i+1, s+sums[i], sums);
            if(right==sums.length){
                break;     // This means s+sums[i]>sums[sums.length-1]
            }
            result=Math.min(result, right-i);
        }
        return result==Integer.MAX_VALUE?0:result;
    }

    // Find the first index for which sums[index]>=target
    public static int searchRight(int left, int target, int[] sums){
        int right=sums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(sums[mid]<target){
                left=mid+1;
            } else{
                right=mid-1;
            }
        }
        return left;
    }
}
