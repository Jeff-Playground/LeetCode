package com.wen.TwentyFirstFifty;

import java.util.Arrays;

public class LongestDuplicateSubstring {
    public static String longestDupSubstring(String s) {
        int l=s.length();
        Integer[] sa=new Integer[l];
        for(int i=0; i<l; i++){
            sa[i]=i;
        }
        Arrays.sort(sa, (a, b)->s.substring(a).compareTo(s.substring(b)));
        int max=0;
        String result="";
        for(int i=1; i<l; i++){
            int len=0, i1=sa[i-1], i2=sa[i];
            while(i1<l && i2<l && s.charAt(i1)==s.charAt(i2)){
                i1++;
                i2++;
                len++;
            }
            if(len>max){
                max=len;
                result=s.substring(sa[i], sa[i]+len);
            }
        }
        return result;
    }
}
