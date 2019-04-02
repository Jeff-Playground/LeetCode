package com.wen.FourthFifty;

import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] result=new int[2];
        Arrays.fill(result,-1);
        int left=0, right=numbers.length-1;
        while(left<right){
            if(numbers[left]+numbers[right]>target){
                right--;
            } else if(numbers[left]+numbers[right]<target){
                left++;
            } else{
                result[0]=left+1;
                result[1]=right+1;
                break;
            }
        }
        return result;
    }
}
