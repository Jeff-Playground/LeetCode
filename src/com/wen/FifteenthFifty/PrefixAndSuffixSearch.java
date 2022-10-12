package com.wen.FifteenthFifty;

import java.util.*;

public class PrefixAndSuffixSearch {
    class WordFilter {
        Map<String, List<Integer>> prefixIdx, suffixIdx;
        // Use this Set to get rid of duplicated input and boost performance
        Set<String> allWords;

        public WordFilter(String[] words) {
            prefixIdx=new HashMap<>();
            suffixIdx=new HashMap<>();
            allWords=new HashSet<>();
            int l=words.length;
            for(int i=l-1; i>=0; i--){
                String word=words[i];
                if(!allWords.contains(word)){
                    allWords.add(word);
                    prefixIdx.putIfAbsent(word, new ArrayList<>());
                    prefixIdx.get(word).add(i);
                    suffixIdx.putIfAbsent(word, new ArrayList<>());
                    suffixIdx.get(word).add(i);
                    for(int j=0; j<word.length()-1; j++){
                        String pref=word.substring(0, j+1), suff=word.substring(j+1);
                        prefixIdx.putIfAbsent(pref, new ArrayList<>());
                        prefixIdx.get(pref).add(i);
                        suffixIdx.putIfAbsent(suff, new ArrayList<>());
                        suffixIdx.get(suff).add(i);
                    }
                }
            }
        }

        public int f(String pref, String suff) {
            if(prefixIdx.containsKey(pref) && suffixIdx.containsKey(suff)){
                List<Integer> pIdx=prefixIdx.get(pref), sIdx=suffixIdx.get(suff);
                int i=0, j=0;
                // Note here can't use != because the JVM is caching Integer values. Hence the comparison with == only
                // works for numbers between -128 and 127
                while(!pIdx.get(i).equals(sIdx.get(j))){
                    if(pIdx.get(i)>sIdx.get(j)){
                        i++;
                    } else{
                        j++;
                    }
                    if(i==pIdx.size() || j==sIdx.size()){
                        return -1;
                    }
                }
                return pIdx.get(i);
            } else{
                return -1;
            }
        }
    }
}
