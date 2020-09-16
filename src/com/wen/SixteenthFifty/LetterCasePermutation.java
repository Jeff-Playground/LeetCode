package com.wen.SixteenthFifty;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    // DFS
    public List<String> letterCasePermutation(String S) {
        List<String> result=new ArrayList<>();
        lcpHelper(S, 0, result);
        return result;
    }

    private void lcpHelper(String s, int idx, List<String> result){
        if(idx<s.length()){
            if(isLetter(s.charAt(idx))){
                char c=s.charAt(idx);
                StringBuilder sb=new StringBuilder(s);
                if(c<='Z'){
                    c+=32;
                } else{
                    c-=32;
                }
                sb.setCharAt(idx, c);
                lcpHelper(sb.toString(), idx+1, result);
            }
            lcpHelper(s, idx+1, result);
        } else{
            result.add(s);
        }
    }

    private boolean isLetter(char c){
        return (c>='a' && c<='z') || (c>='A' && c<='Z');
    }
}
