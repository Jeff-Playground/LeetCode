package com.wen.ThirdFifty;

public class SingleNumberII {
//    // Truth table
//    public int singleNumber(int[] nums) {
//        int high=0, low=0;
//        for(int i=0; i<nums.length; i++) {
//            low=~high&(low^nums[i]);
//            high=~low&(high^nums[i]);
//        }
//        return low;
//    }

    // one, two and three stands for the bit representation when num appears 1, 2 and 3 times
    public int singleNumber(int[] nums) {
        int one=0, two=0, three=0;
        for(int i=0; i<nums.length; i++){
            // Note here update two first because two is dependent on the last one
            two|=one&nums[i];
            // Then update one
            one^=nums[i];
            // If updated one and two are both 1, it means it's the third time this num appears
            three=one&two;
            // Clean up one and two if three is 1
            one&=~three;
            two&=~three;
        }
        return one;
    }

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
