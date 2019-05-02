package com.wen.FirstFifty;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    // Jumping based on words length are same
    // Use a Set<Integer> to do pruning for checked indices
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<>();
        if(s==null || s.length()==0 || words==null || words.length==0){
            return new ArrayList<Integer>(result);
        }
        Map<String, Integer> wordsMap=new HashMap<>();
        for(String word: words){
            wordsMap.put(word, wordsMap.getOrDefault(word, 0)+1);
        }
        int k=words[0].length(), l=words.length;
        Set<Integer> checked=new HashSet<>();
        for(int i=0; i<s.length()-k*l+1; i++){
            if(checked.contains(i)){
                continue;
            }
            if(wordsMap.containsKey(s.substring(i, i+k))){
                Map<String, Integer> current=new HashMap<>();
                int start=i, count=0;
                checked.add(start);
                for(int j=i; j<s.length(); j+=k){
                    if(j+k>s.length()){
                        break;
                    }
                    if(wordsMap.containsKey(s.substring(j, j+k))){
                        String word=s.substring(j, j+k);
                        while(current.getOrDefault(word, 0)==wordsMap.get(word)){
                            String startWord=s.substring(start, start+k);
                            current.put(startWord, current.get(startWord)-1);
                            count--;
                            start+=k;
                            checked.add(start);
                        }
                        current.put(word, current.getOrDefault(word, 0)+1);
                        count++;
                    } else{
                        break;
                    }
                    if(count==l){
                        result.add(start);
                        String startWord=s.substring(start, start+k);
                        current.put(startWord, current.get(startWord)-1);
                        count--;
                        start+=k;
                        checked.add(start);
                    }
                }
            }
        }
        return result;
    }
}
