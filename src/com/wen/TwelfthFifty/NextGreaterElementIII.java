package com.wen.TwelfthFifty;

import java.util.Arrays;

public class NextGreaterElementIII {
    public static int nextGreaterElement(int n) {
        char[] chars=String.valueOf(n).toCharArray();
        int l=chars.length, i=0;
        for(i=l-1; i>0; i--){
            if(chars[i]>chars[i-1]){
                break;
            }
        }
        if(i==0){
            return -1;
        } else{
            int i1=i-1;
            for(i=l-1; i>i1; i--){
                if(chars[i]>chars[i1]){
                    break;
                }
            }
            int i2=i;
            char temp=chars[i1];
            chars[i1]=chars[i2];
            chars[i2]=temp;
            String s=new String(Arrays.copyOf(chars, i1+1))+(i1+1<l?new StringBuilder(new String(Arrays.copyOfRange(chars,i1+1, l))).reverse().toString():"");
            long result=Long.parseLong(s);
            return result>Integer.MAX_VALUE?-1:(int)result;
        }
    }
}
