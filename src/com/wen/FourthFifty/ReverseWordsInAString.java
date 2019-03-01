package com.wen.FourthFifty;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        int storeIndex=0, n=s.length();
        StringBuilder sb=new StringBuilder(s).reverse();
        for(int i=0; i<n; i++){
            if(sb.charAt(i)!=' '){
                if (storeIndex != 0) {
                    sb.setCharAt(storeIndex++, ' ');
                }
                int j=i;
                while(j<n && sb.charAt(j)!=' '){
                    sb.setCharAt(storeIndex++, sb.charAt(j++));
                }
                String t=new StringBuilder(sb.substring(storeIndex-(j-i), storeIndex)).reverse().toString();
                sb.replace(storeIndex-(j-i), storeIndex, t);
                i=j;
            }
        }
        sb.setLength(storeIndex);
        return sb.toString();
    }

//    public static String reverseWords(String s) {
//        String result="";
//        if(s.trim().isEmpty()){
//            return result;
//        }
//        String[] words=s.split("\\s+");
//        for(int i=words.length-1; i>0; i--){
//            if(!words[i].isEmpty()){
//                result+=words[i]+" ";
//            }
//        }
//        return (result+words[0]).trim();
//    }

//    // Char by char
//    public String reverseWords(String s) {
//        String result="";
//        String word="";
//        for(int i=0; i<s.length(); i++){
//            if(s.charAt(i)==' '){
//                if(word.isEmpty()){
//                    continue;
//                } else{
//                    result=word+" "+result;
//                    word="";
//                }
//            } else{
//                word+=s.charAt(i);
//            }
//        }
//        return (word+" "+result).trim();
//    }

//    // Using Java internal API
//    public static String reverseWords(String s) {
//        String[] words=s.split("\\s+");
//        Collections.reverse(Arrays.asList(words));
//        return String.join(" ", words).trim();
//    }
}
