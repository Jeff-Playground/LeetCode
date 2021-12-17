package com.wen.SixthFifty;

/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is
decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}

Machine 2 (receiver) has the function:

vector<string> decode(string s) {
  //... your code
  return strs;
}


So Machine 1 does:

string encoded_string = encode(strs);

and Machine 2 does:

vector<string> strs2 = decode(encoded_string);

strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note:

The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized
enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 */

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
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        if(str==null){
            return null;
        }
        if(str.isEmpty()){
            return new ArrayList<>();
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
