package com.wen.FirstFifty;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0; i<n; i++){
            while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1]!=nums[i]){
                int temp=nums[i];
                nums[i]=nums[nums[i]-1];
                nums[temp-1]=temp;
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
}
