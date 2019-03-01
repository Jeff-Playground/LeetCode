package com.wen.ThirdFifty;

public class SingleNumberII {
    // Truth table
    public int singleNumber(int[] nums) {
        int high=0, low=0;
        for(int i=0; i<nums.length; i++) {
            low=~high&(low^nums[i]);
            high=~low&(high^nums[i]);
        }
        return low;
    }

//    public int singleNumber(int[] nums) {
//        int one=0, two=0, three=0;
//        for(int i=0; i<nums.length; i++){
//            two|=one&nums[i];
//            one^=nums[i];
//            three=one&two;
//            one&=~three;
//            two&=~three;
//        }
//        return one;
//    }

//    public int singleNumber(int[] nums) {
//        int result=0;
//        for(int i=0; i<32; i++){
//            int sum=0;
//            for(int j=0; j<nums.length; j++){
//                sum+=(nums[j]>>i)&1;
//            }
//            result|=(sum%3)<<i;
//        }
//        return result;
//    }
}
