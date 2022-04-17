package com.wen.NinthFifty;

public class StringCompression {
    public int compress(char[] chars) {
        int l=chars.length;
        int i, j, idx=0;
        for(i=0; i<l; i=j){
            char c=chars[i];
            j=i+1;
            while(j<l && chars[j]==c){
                j++;
            }
            chars[idx++]=c;
            if(j-i>1){
                for(char e: String.valueOf(j-i).toCharArray()){
                    chars[idx++]=e;
                }
            }
        }
        return idx;
    }
}
