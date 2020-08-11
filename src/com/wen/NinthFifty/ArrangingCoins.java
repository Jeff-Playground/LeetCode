package com.wen.NinthFifty;

public class ArrangingCoins {
//    public int arrangeCoins(int n) {
//        return (int)((Math.sqrt((long)8*n+1)-1)/2);
//    }

    // Binary search
    public int arrangeCoins(int n) {
        long low=0, high=n;
        while(low<high){
            long mid=low+(high+1-low)/2;
            if((mid*mid+mid)/2<=n){
                low=mid;
            } else{
                high=mid-1;
            }
        }
        return (int)low;
    }
}
