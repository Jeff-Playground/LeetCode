package com.wen.SeventhFifty;

import java.util.*;

public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int result=0, l=words.length;
        int[] mask=new int[l];
        for(int i=0; i<l; i++){
            for(char c: words[i].toCharArray()){
                mask[i]|=1<<(c-'a');
            }
            for(int j=0; j<i; j++){
                if((mask[i]&mask[j])==0){
                    result=Math.max(result, words[i].length()*words[j].length());
                }
            }
        }
        return result;
    }

//    public int maxProduct(String[] words) {
//        int result=0;
//        TreeMap<Integer, Set<Integer>> lwMap=new TreeMap<>(Collections.reverseOrder());
//        for(String word: words){
//            int l=word.length(), v=0;
//            for(char c: word.toCharArray()){
//                v|=1<<(c-'a');
//            }
//            Set<Integer> val=lwMap.getOrDefault(l, new HashSet<>());
//            val.add(v);
//            lwMap.put(l, val);
//        }
//        List<Integer> ls=new ArrayList<>(lwMap.keySet());
//        int size=ls.size();
//        for(int i=0; i<size; i++){
//            int cur=0;
//            for(int j=0; j<size && ls.get(j)*ls.get(i)>result; j++){
//                for(int word1: lwMap.get(i)){
//                    for(int word2: lwMap.get(j)){
//                        if((word1&word2)==0){
//                            cur=ls.get(j)*ls.get(i);
//                            break;
//                        }
//                    }
//                    if(cur>result){
//                        break;
//                    }
//                }
//                if(cur>result){
//                    break;
//                }
//            }
//            result=Math.max(result, cur);
//        }
//        return result;
//    }
}
