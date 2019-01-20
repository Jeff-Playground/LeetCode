package com.wen.FirstFifty;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0 || strs==null){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        String result="";
        for(int index=0; index<strs[0].length(); index++){
            char c=strs[0].charAt(index);
            for(int i=0; i< strs.length; i++){
                if(index==strs[i].length()){
                    return result;
                } else{
                    if(strs[i].charAt(index)!=c){
                        return result;
                    } else{
                        if(i==strs.length-1){
                            result+=c;
                        }
                    }
                }
            }
        }
        return result;
    }
}
