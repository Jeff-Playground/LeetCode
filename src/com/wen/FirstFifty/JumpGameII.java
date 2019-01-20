package com.wen.FirstFifty;

public class JumpGameII {
    public static int jump(int[] nums) {
        int cur=0;
        int jump=0;
        while(cur<nums.length-1){
            jump++;
            int temp=0, tempCur=0;
            if(cur+nums[cur]>=nums.length-1){
                break;
            }
            for(int i=1; i<=nums[cur]; i++){
                if(cur+i+nums[cur+i]>temp){
                    tempCur=cur+i;
                    temp=cur+i+nums[cur+i];
                }
            }
            cur=tempCur;
        }
        return jump;
    }

//    public static int jump(int[] nums) {
//        int pre=0, cur=0;
//        int jump=0;
//        for(int i=0; i<nums.length-1; i++){
//            cur=Math.max(cur, i+nums[i]);
//            if(i==pre){
//                pre=cur;
//                jump++;
//                if(cur>=nums.length-1){
//                    break;
//                }
//            }
//        }
//        return jump;
//    }
}
