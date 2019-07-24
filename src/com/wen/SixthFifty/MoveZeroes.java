package com.wen.SixthFifty;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int nonZero=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[nonZero++]=nums[i];
                // This means the above assign was assign to self
                if(i!=nonZero-1){
                    nums[i]=0;
                }
            }
        }
    }

//    public void moveZeroes(int[] nums) {
//        int nonZero=0;
//        for(int i=0; i<nums.length; i++){
//            if(nums[i]!=0){
//                nums[nonZero++]=nums[i];
//            }
//        }
//        for(int i=nonZero; i<nums.length; i++){
//            nums[i]=0;
//        }
//    }
}
