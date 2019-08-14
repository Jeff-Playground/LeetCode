package com.wen.SixteenthFifty;

import java.util.Arrays;

public class ReorganizeString {
    public String reorganizeString(String S) {
        if(S==null || S.length()<=1){
            return S;
        }
        int[] count=new int[26];
        for(int i=0; i<26; i++){
            count[i]=i;
        }
        int total=S.length();
        for(char c: S.toCharArray()){
            count[c-'a']+=100;
        }
        Arrays.sort(count);
        char[] result=new char[total];
        int idx=1;
        for(int c: count){
            char ch=(char)('a'+c%100);
            int num=c/100;
            if(num>(total+1)/2){
                return "";
            }
            while(num-->0 && idx<total){
                result[idx]=ch;
                idx+=2;
                if(idx>=total){
                    idx=0;
                }
            }
        }
        return new String(result);
    }
}