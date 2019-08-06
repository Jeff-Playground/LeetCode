package com.wen.ThirteenthFifty;

public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        int[] result=new int[2];
        for(int i=0; i<nums.length; i++){
            // This won't go into dead loop because for the duplicated number, once one of them is in the right place, we have nums[i]==nums[nums[i]-1]
            while(nums[i]!=nums[nums[i]-1]){
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=i+1){
                result[0]=nums[i];
                result[1]=i+1;
            }
        }
        return result;
    }

//    // Use -value to denote a number at a certain index exists without changing the value
//    public int[] findErrorNums(int[] nums) {
//        int[] result=new int[2];
//        for(int num: nums){
//            if(nums[Math.abs(num)-1]<0){
//                result[0]=Math.abs(num);
//            } else{
//                nums[Math.abs(num)-1]*=-1;
//            }
//        }
//        for(int i=0; i<nums.length; i++){
//            if(nums[i]>0){
//                result[1]=i+1;
//            }
//        }
//        return result;
//    }

//    public int[] findErrorNums(int[] nums) {
//        int[] result=new int[2];
//        int[] count=new int[nums.length];
//        for(int num: nums){
//            count[num-1]++;
//        }
//        for(int i=0; i<nums.length; i++){
//            if(result[0]!=0 && result[1]!=0){
//                return result;
//            }
//            if(count[i]==2){
//                result[0]=i+1;
//            }
//            if(count[i]==0){
//                result[1]=i+1;
//            }
//        }
//        return result;
//    }
}
