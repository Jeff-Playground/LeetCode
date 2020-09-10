package com.wen.TenthFifty;

import java.util.*;

public class KeyboardRow {
    public static String[] findWords(String[] words) {
        List<String> result=new ArrayList<>();
        Map<Integer, Set<Character>> row=new HashMap<>();
        row.put(1, new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p')));
        row.put(2, new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l')));
        row.put(3, new HashSet<>(Arrays.asList('z','x','c','v','b','n','m')));
        for(String word: words){
            int r=-1;
            for(char c: word.toCharArray()){
                c=c<='Z'?(char)(c+32):c;
                for(int key: row.keySet()){
                    if(row.get(key).contains(c)){
                        if(r!=-1 && r!=key){
                            r=-1;
                            break;
                        } else{
                            r=key;
                            break;
                        }
                    }
                }
                if(r==-1){
                    break;
                }
            }
            if(r!=-1){
                result.add(word);
            }
        }
        String[] r=new String[result.size()];
        for(int i=0; i<result.size(); i++){
            r[i]=result.get(i);
        }
        return r;
    }
}
