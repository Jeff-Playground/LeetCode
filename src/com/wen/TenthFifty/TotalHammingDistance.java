package com.wen.TenthFifty;

public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        if(nums==null || nums.length<=1){
            return 0;
        }
        int l=nums.length, result=0;
        int[] count0=new int[32], count1=new int[32];
        for(int i=0; i<l; i++){
            int num=nums[i];
            int j=0;
            while(num>0){
                if((num&1)==1){
                    count1[j]++;
                } else{
                    count0[j]++;
                }
                num>>=1;
                j++;
            }
            while(j<32){
                count0[j++]++;
            }
        }
        for(int i=0; i<32; i++){
            result+=count0[i]*count1[i];
        }
        return result;
    }
}
