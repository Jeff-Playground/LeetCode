package com.wen.EighthFifty;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magCount=new HashMap<>();
        for(char c: magazine.toCharArray()){
            int count=magCount.getOrDefault(c, 0)+1;
            magCount.put(c, count);
        }
        for(char c: ransomNote.toCharArray()){
            int count=magCount.getOrDefault(c, 0);
            if(count<=0){
                return false;
            } else{
                magCount.put(c, count-1);
            }
        }
        return true;
    }
}
