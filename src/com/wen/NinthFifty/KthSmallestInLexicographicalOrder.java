package com.wen.NinthFifty;

public class KthSmallestInLexicographicalOrder {
    public static int findKthNumber(int n, int k) {
        int cur=1;
        k--;
        while(k>0){
            long step=0, start=cur, end=cur+1;
            while(start<=n){
                step+=Math.min(n+1, end)-start;
                start*=10;
                end*=10;
            }
            if(step<=k){
                cur++;
                k-=step;
            } else{
                cur*=10;
                k--;
            }
        }
        return cur;
    }
}
