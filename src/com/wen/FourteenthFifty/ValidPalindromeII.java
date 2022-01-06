package com.wen.FourteenthFifty;

public class ValidPalindromeII {
    // Two pointers
    public boolean validPalindrome(String s) {
        int left=0, right=s.length()-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            } else{
                if(isPalindrome(s, left, right-1) || isPalindrome(s, left+1, right)){
                    return true;
                } else{
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
