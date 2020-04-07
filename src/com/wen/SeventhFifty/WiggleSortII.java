package com.wen.SeventhFifty;

import java.util.Arrays;

public class WiggleSortII {
    public static void wiggleSort(int[] nums) {
        int n = nums.length, idx = 0, small = 1, big = ((n - 1) & 1) == 0 ? (n - 1) : (n - 2);
        int median = quickSelectIndexK(nums, 0, n - 1, (n - 1) / 2), tmp = 0;
        while(idx < n){
            if(nums[idx] > median && ((idx & 1) == 0 || idx >= small)){
                tmp = nums[idx];
                nums[idx] = nums[small];
                nums[small] = tmp;
                small += 2;
            }else if(nums[idx] < median && ((idx & 1) == 1 || idx <= big)){
                tmp = nums[idx];
                nums[idx] = nums[big];
                nums[big] = tmp;
                big -= 2;
            }else{
                idx++;
            }
        }
    }

    private static int quickSelectIndexK(int[] nums, int low, int high, int k){
        if(low==high){
            return nums[low];
        }
        int temp=nums[low], left=low, right=high;
        while(left<right){
            while(left<right && nums[right]>=temp){
                right--;
            }
            nums[left]=nums[right];
            while(left<right && nums[left]<=temp){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=temp;
        if(left==k){
            return nums[left];
        } else if(left>k){
            return quickSelectIndexK(nums, low, left-1, k);
        } else{
            return quickSelectIndexK(nums, left+1, high, k);
        }
    }

//    public void wiggleSort(int[] nums) {
//        if(nums==null || nums.length<2){
//            return;
//        }
//        int[] temp= Arrays.copyOf(nums, nums.length);
//        Arrays.sort(temp);
//        int mid=(temp.length-1)/2, right=temp.length-1;
//        for(int i=0; i<nums.length; i++){
//            if(i%2==0){
//                nums[i]=temp[mid--];
//            } else{
//                nums[i]=temp[right--];
//            }
//        }
//    }
}
