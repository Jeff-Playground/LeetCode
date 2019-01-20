package com.wen.FirstFifty;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<Character, Integer>();
        roman.put('M', 1000);
        roman.put('D', 500);
        roman.put('C', 100);
        roman.put('L', 50);
        roman.put('X', 10);
        roman.put('V', 5);
        roman.put('I', 1);

        int result = 0;
        for(int i=0; i<s.length(); i++){
            if(i==s.length()-1 || roman.get(s.charAt(i))>=roman.get(s.charAt(i+1))){
                result+=roman.get(s.charAt(i));
            } else{
                result-=roman.get(s.charAt(i));
            }
        }
        return result;
    }
}
