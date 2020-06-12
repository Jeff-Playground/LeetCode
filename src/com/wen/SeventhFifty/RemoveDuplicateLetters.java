package com.wen.SeventhFifty;

import java.util.Stack;

public class RemoveDuplicateLetters {
    // Greedy with Stack
    public String removeDuplicateLetters(String s) {
        int[] count=new int[26], visited=new int[26];
        for(char c: s.toCharArray()){
            count[c-'a']++;
        }
        Stack<Character> stack=new Stack<>();
        stack.push('0');
        for(char c: s.toCharArray()){
            if(visited[c-'a']==0){
                char last=stack.peek();
                while(last>c && count[last-'a']>0){
                    visited[last-'a']=0;
                    stack.pop();
                    last=stack.peek();
                }
                stack.push(c);
                visited[c-'a']=1;
            }
            count[c-'a']--;
        }
        StringBuilder sb=new StringBuilder();
        while(stack.size()>1){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

//    // Greedy with StringBuilder
//    public String removeDuplicateLetters(String s) {
//        int[] count=new int[26], visited=new int[26];
//        StringBuilder sb=new StringBuilder("0");
//        for(char c: s.toCharArray()){
//            count[c-'a']++;
//        }
//        for(char c: s.toCharArray()){
//            if(visited[c-'a']==0){
//                char last=sb.charAt(sb.length()-1);
//                while(last>c && count[last-'a']>0){
//                    visited[last-'a']=0;
//                    sb.deleteCharAt(sb.length()-1);
//                    last=sb.charAt(sb.length()-1);
//                }
//                sb.append(c);
//                visited[c-'a']=1;
//            }
//            count[c-'a']--;
//        }
//        return sb.substring(1);
//    }
}
