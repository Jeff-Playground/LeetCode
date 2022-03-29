package com.wen.TwentyFifthFifty;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    // Use a Stack to track indices of (s, in the first iteration add all indices for )s need to be removed, then at the
    // end whatever left in Stack are indices of (s that need to be removed
    public String minRemoveToMakeValid(String s) {
        Set<Integer> remove=new HashSet<>();
        Stack<Integer> removeLeft=new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(c=='('){
                removeLeft.push(i);
            } else if(c==')'){
                if(!removeLeft.isEmpty()){
                    removeLeft.pop();
                } else{
                    remove.add(i);
                }
            }
        }
        while(!removeLeft.isEmpty()){
            remove.add(removeLeft.pop());
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(!remove.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

//    // Remove redundant ) by iterating from start to end, then remove redundant ( by iterating from end to start
//    public String minRemoveToMakeValid(String s) {
//        StringBuilder sb=new StringBuilder();
//        int count=0;
//        for(char c: s.toCharArray()){
//            if(c=='('){
//                count++;
//                sb.append(c);
//            } else if(c==')'){
//                if(count>0){
//                    count--;
//                    sb.append(c);
//                }
//            } else{
//                sb.append(c);
//            }
//        }
//        if(count==0){
//            return sb.toString();
//        }
//        count=0;
//        StringBuilder sb2=new StringBuilder();
//        for(int i=sb.length()-1; i>=0; i--){
//            char c=sb.charAt(i);
//            if(c==')'){
//                count++;
//                sb2.append(c);
//            } else if(c=='('){
//                if(count>0){
//                    count--;
//                    sb2.append(c);
//                }
//            } else{
//                sb2.append(c);
//            }
//        }
//        return sb2.reverse().toString();
//    }
}
