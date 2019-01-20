package com.wen.SecondFifty;

public class JumpGame {
    // Dynamic Programming
    public boolean canJump(int[] nums) {
        int[] dp=new int[nums.length];
        for(int i=1; i<nums.length; i++){
            dp[i]=Math.max(dp[i-1], nums[i-1])-1;
            if(dp[i]<0){
                return false;
            }
        }
        return dp[nums.length-1]>=0;
    }

//    public boolean canJump(int[] nums) {
//        int pre=0, cur=nums[pre]+pre;
//        if(cur==0 && nums.length==1){
//            return true;
//        }
//        int max=cur;
//        while(pre<cur){
//            if(cur>=nums.length-1){
//                return true;
//            }
//            for(int i=pre+1; i<=cur; i++){
//                if(nums[i]+i>max){
//                    max=nums[i]+i;
//                }
//            }
//            pre=cur;
//            cur=max;
//        }
//        return false;
//    }
}
