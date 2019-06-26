package com.wen.FirstFifty;

public class ImplementStrStr {
    // KMP
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        if(needle.length()>haystack.length() || haystack.length()==0){
            return -1;
        }
        int[] next=new int[needle.length()];
        next[0]=-1;
        int i=-1, j=0;
        while(j<needle.length()-1){
            if(i==-1 || needle.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(needle.charAt(i)!=needle.charAt(j)){
                    next[j]=i;
                } else{
                    next[j]=next[i];
                }
            } else{
                i=next[i];
            }
        }
        i=0; j=0;
        while(i<haystack.length() && j<needle.length()){
            if(j==-1 || haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j==needle.length()){
                    return i-needle.length();
                }
            } else{
                j=next[j];
            }
        }
        return -1;
    }

//    public int strStr(String haystack, String needle) {
//        if(needle.length()==0){
//            return 0;
//        }
//        if(needle.length()>haystack.length() || haystack.length()==0){
//            return -1;
//        }
//        for(int i=0; i<=(haystack.length()-needle.length()); i++){
//            if(haystack.charAt(i)==needle.charAt(0)){
//                int j=0;
//                for(j=0; j<needle.length(); j++){
//                    if(haystack.charAt(i+j)!=needle.charAt(j)){
//                        break;
//                    }
//                }
//                if(j==needle.length()){
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
}
