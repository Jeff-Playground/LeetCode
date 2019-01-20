package com.wen.FirstFifty;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }
        String t="#$";
        for(int i=0; i<s.length(); i++){
            t+=s.charAt(i);
            t+="$";
        }

        int mid=0, rmax=0, midr=0, rr=0;
        int[] flags=new int[t.length()];
        for(int i=0; i<t.length(); i++){
            flags[i]=rmax>=i?Math.min(flags[2*mid-i], rmax-i):1;
            while(i+flags[i]<t.length()&&i-flags[i]>=0){
                if(t.charAt(i+flags[i])==t.charAt(i-flags[i])){
                    flags[i]++;
                }else{
                    break;
                }
            }
            if(i+flags[i]-1>rmax){
                mid=i;
                rmax=i+flags[i]-1;
            }
            if((rmax-mid+1)>rr){
                rr=rmax-mid+1;
                midr=mid;
            }
        }
        return s.substring((midr-rr)/2, (midr+rr)/2-1);
    }


//    Dynamic Programming O(n^2)
//    public static String longestPalindrome(String s) {
//        if(s.length()<=1){
//            return s;
//        }
//        int[][] flags=new int[s.length()][s.length()];
//        int left=0, right=0, len=0;
//        for(int j=0; j<s.length(); j++){
//            for(int i=0; i<=j; i++){
//                if(i==j){
//                    flags[i][j]=1;
//                } else if(i==j-1){
//                    flags[i][j]=s.charAt(i)==s.charAt(j)?1:0;
//                } else{
//                    flags[i][j]=(flags[i+1][j-1]==1)&&s.charAt(i)==s.charAt(j)?1:0;
//                }
//                if(flags[i][j]==1 && j-i+1>len){
//                    len=j-i+1;
//                    left=i;
//                    right=j;
//                }
//            }
//        }
//        return s.substring(left, right+1);
//    }
}
