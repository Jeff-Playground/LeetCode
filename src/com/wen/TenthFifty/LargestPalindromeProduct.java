package com.wen.TenthFifty;

public class LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        int upper=(int)Math.pow(10, n)-1, lower=upper/10+1;
        for(int i=upper; i>=lower; i--){
            StringBuilder seed=new StringBuilder(i+"");
            long num=Long.valueOf(seed.toString()+seed.reverse().toString());
            for(long j=upper; j*j>=num; j--){
                if(num%j==0){
                    return (int)(num%1337);
                }
            }
        }
        return 9;
    }
}
