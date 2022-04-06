package com.wen.SeventeenthFifty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
    public String toGoatLatin(String sentence) {
        String[] splited=sentence.split("\\s");
        StringBuilder sb=new StringBuilder();
        Set<Character> vowels=new HashSet<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        for(int i=0; i<splited.length; i++){
            String word=splited[i];
            if(vowels.contains(word.charAt(0))){
                sb.append(word+"ma");
            } else{
                sb.append(word.substring(1)+word.charAt(0)+"ma");
            }
            int count=i+1;
            while(count-->0){
                sb.append('a');
            }
            sb.append(" ");
        }
        return sb.substring(0, sb.length()-1);
    }
}
