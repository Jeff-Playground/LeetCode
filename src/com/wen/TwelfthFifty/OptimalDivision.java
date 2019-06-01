package com.wen.TwelfthFifty;

public class OptimalDivision {
    public String optimalDivision(int[] nums) {
        StringBuilder result=new StringBuilder();
        if(nums==null || nums.length==0){
            return result.toString();
        } else if(nums.length==1){
            return result.append(nums[0]).toString();
        } else if(nums.length==2){
            return result.append(nums[0]+"/"+nums[1]).toString();
        } else{
            result.append(nums[0]+"/(");
            for(int i=1; i<nums.length; i++){
                result.append(nums[i]+"/");
            }
            return result.deleteCharAt(result.length()-1).append(")").toString();
        }
    }
}
