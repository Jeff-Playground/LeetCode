package com.wen.SixthFifty;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        char[] pArray=pattern.toCharArray();
        String[] sArray=str.trim().split("\\s+");
        if(pArray.length!=sArray.length){
            return false;
        }
        int l=pArray.length;
        Map<Character, String> pToS=new HashMap<>();
        Map<String, Character> sToP=new HashMap<>();
        for(int i=0; i<l; i++){
            if(pToS.containsKey(pArray[i])){
                if(!pToS.get(pArray[i]).equals(sArray[i]) || !sToP.get(sArray[i]).equals(pArray[i])){
                    return false;
                }
            } else{
                if(sToP.containsKey(sArray[i])){
                    return false;
                }
                pToS.put(pArray[i], sArray[i]);
                sToP.put(sArray[i], pArray[i]);
            }
        }
        return true;
    }
}
