package com.wen.TenthFifty;

public class PoorPigs {
    // (K+1)^n>=buckets
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int k=minutesToTest/minutesToDie;
        return (int)Math.ceil(Math.log(buckets)/Math.log(k+1));
    }
}
