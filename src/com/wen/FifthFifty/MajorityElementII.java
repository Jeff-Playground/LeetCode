package com.wen.FifthFifty;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result=new ArrayList<>();
        if(nums==null || nums.length==0){
            return result;
        }
        int num1=0, num2=0, count1=0, count2=0;
        for(int num: nums){
            if(num==num1){
                count1++;
            } else if(num==num2){
                count2++;
            } else if(count1==0){
                num1=num;
                count1=1;
            } else if(count2==0){
                num2=num;
                count2=1;
            } else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int num: nums){
            if(num==num1){
                count1++;
            // Note here it has to be else if instead of if because this can prevent false result when num is equal to num2 init value, e.g. [0,0,0]
            } else if(num==num2){
                count2++;
            }
        }
        if(count1>nums.length/3){
            result.add(num1);
        }
        if(count2>nums.length/3){
            result.add(num2);
        }
        return result;
    }
}
