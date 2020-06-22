package com.wen.SeventhFifty;

public class SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        int l=x.length;
        for(int i=3; i<l; i++){
            if(x[i]>=x[i-2] && x[i-1]<=x[i-3]){
                return true;
            }
            if(i>=4 && x[i-1]==x[i-3] && x[i]+x[i-4]>=x[i-2]){
                return true;
            }
            if(i>=5 && x[i-2]>=x[i-4] && x[i-3] >= x[i-1] && x[i]+x[i-4]>=x[i-2] && x[i-1]+x[i-5]>=x[i-3]){
                return true;
            }
        }
        return false;
    }
}
