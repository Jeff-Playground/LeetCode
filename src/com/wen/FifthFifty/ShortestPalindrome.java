package com.wen.FifthFifty;

public class ShortestPalindrome {
    // KMP
    public String shortestPalindrome(String s) {
        return null;
    }

//    // Two pointers
//    public String shortestPalindrome(String s) {
//        int i=0, j=s.length()-1;
//        while(i<s.length() && j>=0){
//            if(s.charAt(i)==s.charAt(j)){
//                i++;
//            }
//            j--;
//        }
//        if(i==s.length()){
//            return s;
//        } else{
//            StringBuilder add=new StringBuilder(s.substring(i)).reverse();
//            return add.append(shortestPalindrome(s.substring(0, i))).append(s.substring(i)).toString();
//        }
//    }
}
