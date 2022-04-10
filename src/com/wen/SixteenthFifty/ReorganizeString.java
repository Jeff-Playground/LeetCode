package com.wen.SixteenthFifty;

import java.util.Arrays;

public class ReorganizeString {
    public String reorganizeString(String S) {
        if(S==null || S.length()<=1){
            return S;
        }
        // count stores info on the count number by count[i]/100 and identifies char by count[i]%100
        int[] counts=new int[26];
        for(int i=0; i<26; i++){
            counts[i]=i;
        }
        int total=S.length();
        for(char c: S.toCharArray()){
            counts[c-'a']+=100;
        }
        Arrays.sort(counts);
        char[] result=new char[total];
        // Here the update starts with idx=1 because it updates the chars with smaller counts first, and the char with
        // largest count should take the first place idx=0 to avoid issues. Besides, updating by doing idx+=2 can ensure
        // the updates doesn't result in conflict in any way
        int idx=1;
        for(int info: counts){
            char ch=(char)('a'+info%100);
            int count=info/100;
            if(count>(total+1)/2){
                return "";
            }
            while(count-->0 && idx<total){
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
