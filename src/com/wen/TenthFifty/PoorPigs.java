package com.wen.TenthFifty;

public class PoorPigs {
    // Convert into a problem where buckets is a k+1 based number, where k is the number of testing rounds
    // Let each pig handle one digit of the number
    // For each round, the pig would drink all the buckets which has roundNumber-1 in that digit
    // So after each round, we can get the number on one digit if the corresponding pig died
    // So when pig number is n, there should be (k+1)^n>=buckets
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int k=minutesToTest/minutesToDie;
        return (int)Math.ceil(Math.log(buckets)/Math.log(k+1));
    }
}
