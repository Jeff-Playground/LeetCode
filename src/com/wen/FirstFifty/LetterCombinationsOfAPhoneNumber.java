package com.wen.FirstFifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Integer, String> map=new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        findLetterCombinations(digits, map, 0, "", result);
        return result;
    }

    private static void findLetterCombinations(String digits, Map<Integer, String> map, int level, String out, List<String> result) {
        if(level==digits.length()) {
            result.add(out);
        }else {
            int n=Integer.parseInt(String.valueOf(digits.charAt(level)));
            String value=map.get(n);
            for(int i=0; i<value.length(); i++) {
                findLetterCombinations(digits, map, level+1, out+value.charAt(i), result);
            }
        }
    }
}
