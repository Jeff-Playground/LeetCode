package com.wen.FirstFifty;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        if(nums.length<2 || nums==null){
            return;
        }
        int length=nums.length;
        int i=length-1;
        int index=-1;
        while(i>0){
            if(nums[i]<=nums[i-1]){
                i--;
            }else{
                index=i-1;
                break;
            }
        }
        if(index==-1){
            reverse(nums, 0, nums.length-1);
        }else{
            for(int j=length-1; j>=index; j--){
                if(nums[j]>nums[index]){
                    int temp=nums[j];
                    nums[j]=nums[index];
                    nums[index]=temp;
                    break;
                }
            }
            reverse(nums, index+1, nums.length-1);
        }
    }

    private static void reverse(int[] nums, int left, int right) {
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}
