package com.wen.FifteenthFifty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestWordInDictionary {
    // Note the HashSet being used here is similar to a trie, but without the complexity of actually creating one

//    // PriorityQueue
//    public static String longestWord(String[] words) {
//        if(words==null || words.length==0){
//            return "";
//        }
//        String result="";
//        PriorityQueue<String> pq=new PriorityQueue<>();
//        for(String word: words){
//            pq.offer(word);
//        }
//        String last="";
//        while(!pq.isEmpty()){
//            String cur=pq.peek();
//            if(cur.length()-last.length()==1 && cur.startsWith(last)){
//                last=pq.poll();
//            } else{
//                if(last.length()>result.length()){
//                    result=last;
//                }
//                last="";
//                while(cur!=null && cur.length()>1){
//                    pq.poll();
//                    cur=pq.peek();
//                }
//            }
//        }
//        return last.length()>result.length()?last:result;
//    }

    // Sort
    public static String longestWord(String[] words) {
        if(words==null || words.length==0){
            return "";
        }
        Arrays.sort(words);
        String result="";
        Set<String> set=new HashSet<>();
        for(String word: words){
            int l=word.length();
            if(l==1 || set.contains(word.substring(0, l-1))){
                if(l>result.length()){
                    result=word;
                }
                set.add(word);
            }
        }
        return result;
    }
}
