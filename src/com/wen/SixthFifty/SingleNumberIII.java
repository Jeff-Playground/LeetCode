package com.wen.SixthFifty;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int num: nums){
            xor^=num;
        }
        // This is to get the lowest different bit
        int firstDiff=xor&(-xor);
        int x=0, y=0;
        for(int num: nums){
            if((num & firstDiff)==0){
                x^=num;
            } else{
                y^=num;
            }
        }
        return new int[]{x, y};
    }
}
