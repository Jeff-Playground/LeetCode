package com.wen.SecondFifty;

public class SortColors {
    // Two pointers2 using while loop
    public void sortColors(int[] nums) {
        int left=0, right=nums.length-1, cur=0;
        while(cur<=right){
            if(nums[cur]==0){
                nums[cur]=nums[left];
                nums[left++]=0;
            } else if(nums[cur]==2){
                nums[cur--]=nums[right];
                nums[right--]=2;
            }
            cur++;
        }
    }

//    // Two pointers1 using for loop
//    public void sortColors(int[] nums) {
//        int i0=0, i2=nums.length-1;
//        for(int i=0; i<=i2; i++){
//            if(nums[i]==0){
//                nums[i]=nums[i0];
//                nums[i0]=0;
//                i0++;
//                // Note this if doesn't need to do i-- because nums[i0] can only be 0 or 1, as it's already checked(i0<=i)
//            } else if(nums[i]==2){
//                nums[i]=nums[i2];
//                nums[i2]=2;
//                i2--;
//                // Note need to do i-- because there's no grantee nums[i2] was 1, so the swapped number need to be checked again
//                i--;
//            }
//        }
//    }

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
