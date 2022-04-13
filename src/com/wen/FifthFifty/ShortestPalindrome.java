package com.wen.FifthFifty;

public class ShortestPalindrome {
    // Similar to KMP, but only construct the next array
    public static String shortestPalindrome(String s) {
        String temp=s+"$"+new StringBuilder(s).reverse().toString();
        int l=temp.length();
        int[] next=new int[l];
        next[0]=-1;
        int i=-1, j=0;
        while(j<l-1){
            if(i==-1 || temp.charAt(i)==temp.charAt(j)){
                i++;
                j++;
                next[j]=i;
            } else{
                i=next[i];
            }
        }
        return new StringBuilder(s).reverse().substring(0, s.length()-next[l-1]-1).toString()+s;
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
