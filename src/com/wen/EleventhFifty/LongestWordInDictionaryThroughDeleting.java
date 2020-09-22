package com.wen.EleventhFifty;

import java.util.*;

public class LongestWordInDictionaryThroughDeleting {
    // Use dictionary as is, so iteration need to go over the whole list
    public String findLongestWord(String s, List<String> d) {
        int length=0, maxIdx=-1, l=s.length();
        Map<Character, TreeSet<Integer>> idx=new HashMap<>();
        for(int i=0; i<l; i++){
            char c=s.charAt(i);
            idx.putIfAbsent(c, new TreeSet<>());
            idx.get(c).add(i);
        }
        for(int j=0; j<d.size(); j++){
            String word=d.get(j);
            if(word.length()<=l && word.length()>=length){
                int last=-1;
                for(int i=0; i<word.length(); i++){
                    char c=word.charAt(i);
                    Integer next=null;
                    if(idx.containsKey(c)){
                        next=idx.get(c).higher(last);
                    }
                    if(next!=null){
                        last=next;
                        if(i==word.length()-1){
                            if(length<word.length()){
                                length=word.length();
                                maxIdx=j;
                            } else{
                                if(word.compareTo(d.get(maxIdx))<0){
                                    maxIdx=j;
                                }
                            }
                        }
                    } else{
                        break;
                    }
                }
            }
        }
        return maxIdx==-1?"":d.get(maxIdx);
    }

//    // Sort given dictionary first, so the first match found is the result
//    public String findLongestWord(String s, List<String> d) {
//        int length=0, maxIdx=-1, l=s.length();
//        Map<Character, TreeSet<Integer>> idx=new HashMap<>();
//        for(int i=0; i<l; i++){
//            char c=s.charAt(i);
//            idx.putIfAbsent(c, new TreeSet<>());
//            idx.get(c).add(i);
//        }
//        Collections.sort(d, (a, b)->a.length()==b.length()?a.compareTo(b):b.length()-a.length());
//        for(int j=0; j<d.size(); j++){
//            String word=d.get(j);
//            if(word.length()<=l){
//                int last=-1;
//                for(int i=0; i<word.length(); i++){
//                    char c=word.charAt(i);
//                    Integer next=null;
//                    if(idx.containsKey(c)){
//                        next=idx.get(c).higher(last);
//                    }
//                    if(next!=null){
//                        last=next;
//                        if(i==word.length()-1){
//                            return word;
//                        }
//                    } else{
//                        break;
//                    }
//                }
//            }
//        }
//        return "";
//    }
}
