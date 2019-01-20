package com.wen.SecondFifty;

public class SortColors {
    // Two pointers
    public void sortColors(int[] nums) {
        int i0=0, i2=nums.length-1;
        for(int i=0; i<=i2; i++){
            if(nums[i]==0){
                nums[i]=nums[i0];
                nums[i0]=0;
                i0++;
            } else if(nums[i]==2){
                nums[i]=nums[i2];
                nums[i2]=2;
                i--;
                i2--;
            }
        }
    }

//    // Count and assign values
//    public void sortColors(int[] nums) {
//        int c0=0, c1=0, c2=0;
//        for(int num: nums){
//            if(num==0){
//                c0++;
//            } else if(num==1){
//                c1++;
//            } else{
//                c2++;
//            }
//        }
//        int i=0;
//        while(c0>0){
//            nums[i]=0;
//            i++;
//            c0--;
//        }
//        while(c1>0){
//            nums[i]=1;
//            i++;
//            c1--;
//        }
//        while(c2>0) {
//            nums[i] = 2;
//            i++;
//            c2--;
//        }
//    }
}
