package com.wen.EighthFifty;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
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
