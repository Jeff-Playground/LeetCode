package com.wen.TenthFifty;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result=0, cur=0;
        for(int num: nums){
            cur=(cur+num)*num;
            result=Math.max(result, cur);
        }
        return result;
    }

//    public int findMaxConsecutiveOnes(int[] nums) {
//        int result=0, cur=0;
//        for(int num: nums){
//            if(num==1){
//                cur++;
//            } else{
//                result=Math.max(result, cur);
//                cur=0;
//            }
//        }
//        result=Math.max(result, cur);
//        return result;
//    }

//    public int findMaxConsecutiveOnes(int[] nums) {
//        int result=0, count=0;
//        for(int num: nums){
//            count=num==0?0:count+1;
//            result=Math.max(result, count);
//        }
//        return result;
//    }
}
