package com.wen.FourteenthFifty;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0, max=Integer.MIN_VALUE;;
        for(int num: nums){
            sum+=num;
            max=Math.max(max, num);
        }
        if(sum%k!=0 || max>sum/k){
            return false;
        } else{
            Arrays.sort(nums);
            int l=nums.length;
            int[] visited=new int[l];
            return canPartitionKSubsets(nums, k, 0, sum/k, sum/k, visited);
        }
    }

    // Note here uses start to avoid TLE
    private boolean canPartitionKSubsets(int[] nums, int k, int start, int target, int remain, int[] visited){
        if(k==1){
            return true;
        } else{
            int l=nums.length;
            for(int i=start; i<l; i++){
                if(visited[i]==0){
                    if(nums[i]<remain){
                        visited[i]=1;
                        if(canPartitionKSubsets(nums, k, i+1, target, remain-nums[i], visited)){
                            return true;
                        } else{
                            visited[i]=0;
                        }
                    } else if(nums[i]==remain){
                        visited[i]=1;
                        if(canPartitionKSubsets(nums, k-1, 0, target, target, visited)){
                            return true;
                        } else{
                            visited[i]=0;
                        }
                    } else{
                        return false;
                    }
                }
            }
            return false;
        }
    }
}
