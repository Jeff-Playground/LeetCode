package com.wen.ThirdFifty;

public class ValidPalindrome {
    // Note condition (s.charAt(left)!=s.charAt(right) && Math.abs(s.charAt(left)-s.charAt(right))!=Math.abs('A'-'a')) won't work
    // because it can produce false equal for a number and a letter, for example 0(zero) and P
    public static boolean isPalindrome(String s) {
        if(s==null){
            return false;
        }
        int left=0, right=s.length()-1;
        while(left<right){
            if(!isLetterNumChar(s.charAt(left))){
                left++;
            } else if(!isLetterNumChar(s.charAt(right))){
                right--;
            } else if((s.charAt(left)-'a'+32)%32!=(s.charAt(right)-'a'+32)%32){ // 'a'-'A'==32
                return false;
            } else{
                left++;
                right--;
            }
        }
        return true;
    }

    private static boolean isLetterNumChar(char c) {
        if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9')){
            return true;
        }
        return false;
    }
}
