package com.wen.SeventhFifty;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] count=new int[26], visited=new int[26];
        StringBuilder sb=new StringBuilder("0");
        for(char c: s.toCharArray()){
            count[c-'a']++;
        }
        for(char c: s.toCharArray()){
            if(visited[c-'a']==0){
                char last=sb.charAt(sb.length()-1);
                while(last>c && count[last-'a']>0){
                    visited[last-'a']=0;
                    sb.deleteCharAt(sb.length()-1);
                    last=sb.charAt(sb.length()-1);
                }
                sb.append(c);
                visited[c-'a']=1;
            }
            count[c-'a']--;
        }
        return sb.substring(1);
    }
}
