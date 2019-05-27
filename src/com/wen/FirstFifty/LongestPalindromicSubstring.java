package com.wen.FirstFifty;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        String t="#$";
        for(int i=0; i<s.length(); i++){
            t+=s.charAt(i)+"$";
        }
        int l=t.length();
        String result="";
        int[] reach=new int[l];
        int mid=0, rMax=0;
        for(int i=1; i<l; i++){
            reach[i]=i<=mid+rMax-1?Math.min(reach[mid*2-i],mid+rMax-i):1;
            while(i-reach[i]>=0 && i+reach[i]<l && t.charAt(i-reach[i])==t.charAt(i+reach[i])){
                reach[i]++;
            }
            if(reach[i]>rMax){
                mid=i;
                rMax=reach[i];
            }
        }
        if(mid!=0){
            result=s.substring((mid-rMax+1)/2, (mid+rMax-1)/2);
        }
        return result;
    }


//    Dynamic Programming O(n^2)
//    public static String longestPalindrome(String s) {
//        if(s.length()<=1){
//            return s;
//        }
//        int[][] isPalindrome=new int[s.length()][s.length()];
//        int left=0, right=0, len=0;
//        for(int j=0; j<s.length(); j++){
//            for(int i=0; i<=j; i++){
//                if(i==j){
//                    isPalindrome[i][j]=1;
//                } else if(i==j-1){
//                    isPalindrome[i][j]=s.charAt(i)==s.charAt(j)?1:0;
//                } else{
//                    isPalindrome[i][j]=(isPalindrome[i+1][j-1]==1)&&s.charAt(i)==s.charAt(j)?1:0;
//                }
//                if(isPalindrome[i][j]==1 && j-i+1>len){
//                    len=j-i+1;
//                    left=i;
//                    right=j;
//                }
//            }
//        }
//        return s.substring(left, right+1);
//    }
}
