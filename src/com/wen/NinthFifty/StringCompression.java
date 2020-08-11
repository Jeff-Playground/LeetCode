package com.wen.NinthFifty;

public class StringCompression {
    public int compress(char[] chars) {
        int l=chars.length;
        int i=0, j=0, idx=0;
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

//    public int compress(char[] chars) {
//        int l=chars.length;
//        int idx=0, idxNew=0, count=0;
//        char last='a';
//        while(idx<l){
//            char c=chars[idx++];
//            if(count==0 || c!=last){
//                if(count>1){
//                    for(char e: String.valueOf(count).toCharArray()){
//                        chars[idxNew++]=e;
//                    }
//                }
//                last=c;
//                count=1;
//                chars[idxNew++]=c;
//            } else if(c==last){
//                count++;
//            }
//        }
//        if(count>1){
//            for(char e: String.valueOf(count).toCharArray()){
//                chars[idxNew++]=e;
//            }
//        }
//        return idxNew;
//    }
}
