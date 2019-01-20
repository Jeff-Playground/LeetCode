package com.wen.FirstFifty;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0 || (x!=0&&x%10==0)) {
            return false;
        }
        if(x<10) {
            return true;
        }
        int revert=0;
        int temp=x;
        while(temp!=0) {
            revert=revert*10+temp%10;
            temp/=10;
        }
        if(revert==x) {
            return true;
        }else {
            return false;
        }
    }
}
