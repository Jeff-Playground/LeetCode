package com.wen.FirstFifty;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int l=nums.length;
        int idx1=-1, idx2=-1;
        for(int i=l-1; i>0; i--){
            if(nums[i]>nums[i-1]){
                idx1=i-1;
                break;
            }
        }
        if(idx1==-1){
            reverse(nums, 0, l-1);
        } else{
            for(int i=l-1; i>idx1; i--){
                if(nums[i]>nums[idx1]){
                    idx2=i;
                    break;
                }
            }
            swap(nums, idx1, idx2);
            reverse(nums, idx1+1, l-1);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums, i++, j--);
        }
    }
}
