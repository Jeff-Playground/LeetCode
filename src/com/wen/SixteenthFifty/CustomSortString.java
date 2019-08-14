package com.wen.SixteenthFifty;

public class CustomSortString {
    public String customSortString(String S, String T) {
        int[] tCount=new int[26];
        for(char c: T.toCharArray()){
            tCount[c-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(char c: S.toCharArray()){
            while(tCount[c-'a']-->0){
                sb.append(c);
            }
        }
        for(int i=0; i<26; i++){
            while(tCount[i]-->0){
                sb.append((char)('a'+i));
            }
        }
        return sb.toString();
    }
}
