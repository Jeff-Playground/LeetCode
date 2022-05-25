package com.wen.TwentySixthFifty;

public class FindTheSmallestDivisorGivenAThreshold {
    // Binary search
    public int smallestDivisor(int[] nums, int threshold) {
        int left=1, right=1_000_000;
        while(left<right){
            int mid=left+(right-left)/2;
            int total=0;
            for(int num: nums){
                total+=divide(num, mid);
                if(total>threshold){
                    break;
                }
            }
            if(total>threshold){
                left=mid+1;
            } else{
                right=mid;
            }
        }
        return left;
    }

    private int divide(int num, int divisor){
        return num%divisor==0?num/divisor:num/divisor+1;
    }
}
