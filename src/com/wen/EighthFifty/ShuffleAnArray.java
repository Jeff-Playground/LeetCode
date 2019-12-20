package com.wen.EighthFifty;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
    // To prove the shuffle is really random(each element can appear at each position with same possibility, and in the
    // final result each position can have each element with same possibility):
    // For the 1st position, each element appear at possibility: 1/n
    // For the 2nd position, the remaining (n-1) elements appear at possibility: (n-1)/n * 1/(n-1) = 1/n
    // For the 3rd position, the remaining (n-2) elements appear at possibility: (n-1)/n * (n-2)/(n-1) * 1/(n-2) = 1/n
    // ...
    // So in the final result each position can have each element with same possibility
    class Solution {
        int[] nums;
        Random r=new Random();

        public Solution(int[] nums) {
            this.nums=nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] result= Arrays.copyOf(nums, nums.length);
            for(int i=0; i<result.length; i++){
                // Knuth shuffling
                int t=r.nextInt(result.length-i)+i;
                if(t!=i){
                    int temp=result[i];
                    result[i]=result[t];
                    result[t]=temp;
                }
            }
            return result;
        }
    }
}
