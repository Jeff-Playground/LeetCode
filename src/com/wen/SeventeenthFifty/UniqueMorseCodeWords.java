package com.wen.SeventeenthFifty;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> result=new HashSet<>();
        for(String word: words){
            StringBuilder sb=new StringBuilder();
            for(char c: word.toCharArray()){
                sb.append(codes[c-'a']);
            }
            result.add(sb.toString());
        }
        return result.size();
    }
}
