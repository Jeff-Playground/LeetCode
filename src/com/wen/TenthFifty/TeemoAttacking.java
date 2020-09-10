package com.wen.TenthFifty;

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result=0, l=timeSeries.length;
        if(l>=1){
            for(int i=0; i<l-1; i++){
                result+=Math.min(timeSeries[i+1]-timeSeries[i], duration);
            }
            result+=duration;
        }
        return result;
    }
}
