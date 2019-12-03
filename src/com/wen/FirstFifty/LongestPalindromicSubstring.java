package com.wen.FirstFifty;

public class LongestPalindromicSubstring {
    // Manacher's algorithm
    public static String longestPalindrome(String s) {
        String t="#$";
        for(int i=0; i<s.length(); i++){
            t+=s.charAt(i)+"$";
        }
        int l=t.length();
        String result="";
        int[] r=new int[l];
        int maxMid=0, maxR=0, lastMid=0, lastR=0;
        for(int i=1; i<l; i++){
            r[i]= i<=lastMid+lastR-1 ? Math.min(r[lastMid*2-i],lastMid+lastR-i) : 1;
            while(i-r[i]>=0 && i+r[i]<l && t.charAt(i-r[i])==t.charAt(i+r[i])){
                r[i]++;
            }
            if(i+r[i]-1>lastMid+lastR-1){
                lastMid=i;
                lastR=r[i];
            }
            if(r[i]>maxR){
                maxMid=i;
                maxR=r[i];
            }
        }
        if(maxMid!=0){
            result=s.substring((maxMid-maxR+1)/2, (maxMid+maxR-1)/2);
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
