package com.wen.FirstFifty;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int l=strs.length, result=0;
        for(int i=0; i<strs[0].length(); i++){
            char c=strs[0].charAt(i);
            for(int j=1; j<l; j++){
                if(strs[j].length()>i && strs[j].charAt(i)==c){
                    continue;
                } else{
                    return strs[0].substring(0, result);
                }
            }
            result++;
        }
        return strs[0].substring(0, result);
    }
}
