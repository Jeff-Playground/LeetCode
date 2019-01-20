package com.wen.FirstFifty;

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        if(needle.length()>haystack.length() || haystack.length()==0){
            return -1;
        }
        for(int i=0; i<=(haystack.length()-needle.length()); i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                int j=0;
                for(j=0; j<needle.length(); j++){
                    if(haystack.charAt(i+j)!=needle.charAt(j)){
                        break;
                    }
                }
                if(j==needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }
}
