package com.wen.SixthFifty;

import java.util.ArrayList;
import java.util.List;

public class LQEncodeAndDecodeStrings {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        if(strs==null){
            return null;
        }
        if(strs.size()==0){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        for(String str: strs){
            sb.append(str.length()+"/");
            sb.append(str);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        if(str==null){
            return null;
        }
        if(str.isEmpty()){
            return new ArrayList<String>();
        }
        int length=0, start=0, end=0;
        List<String> result=new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='/'){
                end=i;
                length=Integer.parseInt(str.substring(start, end));
                String s=str.substring(end+1, end+1+length);
                result.add(s);
                start=end+1+length;
                i=end+1+length;
            }
        }
        return result;
    }
}
