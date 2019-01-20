package com.wen.FirstFifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    // Jumping based on words length are same
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<Integer>();
        if(s==null||s.length()==0||words==null||words.length==0){
            return result;
        }
        Map<String, Integer> wordsMap=new HashMap<String, Integer>();
        for(String word:words){
            if(wordsMap.containsKey(word)){
                wordsMap.put(word, wordsMap.get(word)+1);
            }else{
                wordsMap.put(word,1);
            }
        }

        int len=words[0].length();
        Map<String, Integer> current=new HashMap<String, Integer>();
        for(int i=0; i<len; i++){
            int start=i;
            int count=words.length;
            current.clear();
            for(int j=i; j<s.length()-len+1; j+=len){
                String sub=s.substring(j, j+len);
                if(wordsMap.containsKey(sub)){
                    if(current.containsKey(sub)){
                        current.put(sub, current.get(sub)+1);
                    }else{
                        current.put(sub, 1);
                    }
                    count--;
                    while(current.get(sub)>wordsMap.get(sub)){
                        String temp=s.substring(start, start+len);
                        current.put(temp, current.get(temp)-1);
                        start=start+len;
                        count++;
                    }
                    if(count==0){
                        result.add(start);
                        String temp=s.substring(start, start+len);
                        current.put(temp, current.get(temp)-1);
                        start=start+len;
                        count++;
                    }
                }else{
                    start=j+len;
                    current.clear();
                    count=words.length;
                }
            }
        }
        return result;
    }
}
