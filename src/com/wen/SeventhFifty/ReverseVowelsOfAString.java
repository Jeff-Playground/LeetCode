package com.wen.SeventhFifty;

import java.util.*;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        Set<Character> vowels=new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        List<Integer> idx=new ArrayList<>();
        StringBuilder sb=new StringBuilder(s);
        int idx1=0, idx2=sb.length()-1;
        while(idx1<idx2){
            if(vowels.contains(sb.charAt(idx1)) && vowels.contains(sb.charAt(idx2))){
                char c=sb.charAt(idx1);
                sb.setCharAt(idx1++, sb.charAt(idx2));
                sb.setCharAt(idx2--, c);
            } else if(!vowels.contains(sb.charAt(idx1))){
                idx1++;
            } else if(!vowels.contains(sb.charAt(idx2))){
                idx2--;
            }
        }
        return sb.toString();
    }

//    public String reverseVowels(String s) {
//        Set<Character> vowels=new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
//        List<Integer> idx=new ArrayList<>();
//        for(int i=0; i<s.length(); i++){
//            if(vowels.contains(s.charAt(i))){
//                idx.add(i);
//            }
//        }
//        StringBuilder sb=new StringBuilder(s);
//        for(int i=0; i<idx.size()/2; i++){
//            int idx1=idx.get(i), idx2=idx.get(idx.size()-1-i);
//            if(sb.charAt(idx1)!=sb.charAt(idx2)){
//                char c=sb.charAt(idx1);
//                sb.setCharAt(idx1, sb.charAt(idx2));
//                sb.setCharAt(idx2, c);
//            }
//        }
//        return sb.toString();
//    }
}
